create database ciscoITSON;
use ciscoITSON;

-- Creación de la tabla Unidad Académica
CREATE TABLE UnidadAcademica (
    idUnidad INT PRIMARY KEY AUTO_INCREMENT,
    nombreUnidad VARCHAR(100) NOT NULL
);

-- Creación de la tabla Carrera
CREATE TABLE Carrera (
    idCarrera INT PRIMARY KEY AUTO_INCREMENT,
    nombreCarrera VARCHAR(100) NOT NULL,
    tiempoLimite INT NOT NULL -- Tiempo máximo permitido por alumno (en minutos)
);

-- Creación de la tabla Alumno
CREATE TABLE Alumno (
    idAlumno INT PRIMARY KEY AUTO_INCREMENT,
    nombreAlumno VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100) NOT NULL,
    apellidoMaterno VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    idCarrera INT NOT NULL,
    FOREIGN KEY (idCarrera) REFERENCES Carrera(idCarrera),
    estatus VARCHAR(50) NOT NULL -- Activo o Bloqueado
);

-- Creación de la tabla Bloqueo
CREATE TABLE Bloqueo (
    idBloqueo INT PRIMARY KEY AUTO_INCREMENT,
    idAlumno INT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fechaDeBloqueo DATE NOT NULL,
    FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno)
);

-- Creación de la tabla Centro de Cómputo
CREATE TABLE CentroComputo (
    idCentro INT PRIMARY KEY AUTO_INCREMENT,
    nombreCentro VARCHAR(100) NOT NULL,
    horaApertura TIME NOT NULL,
    horaCierre TIME NOT NULL,
    contrasenaMaestra VARCHAR(100) NOT NULL,
    idUnidad INT NOT NULL,
    FOREIGN KEY (idUnidad) REFERENCES UnidadAcademica(idUnidad)
);

-- Creación de la tabla Computadora
CREATE TABLE Computadora (
    idComputadora INT PRIMARY KEY AUTO_INCREMENT,
    numeroMaquina INT NOT NULL,
    estatus VARCHAR(50) NOT NULL, -- Disponible, Ocupada, o Fuera de servicio
    ip VARCHAR(50) NOT NULL,
    idCentro INT NOT NULL,
    FOREIGN KEY (idCentro) REFERENCES CentroComputo(idCentro)
);

-- Creación de la tabla Software 
CREATE TABLE Software (
    idSoftware INT PRIMARY KEY AUTO_INCREMENT,
    nombreSoftware VARCHAR(100) NOT NULL
);

-- Relación Computadora-Software
CREATE TABLE ComputadoraSoftware (
    idComputadora INT NOT NULL,
    idSoftware INT NOT NULL,
    PRIMARY KEY (idComputadora, idSoftware),
    FOREIGN KEY (idComputadora) REFERENCES Computadora(idComputadora),
    FOREIGN KEY (idSoftware) REFERENCES Software(idSoftware)
);

-- Creación de la tabla Reserva
CREATE TABLE Reserva (
    idReserva INT PRIMARY KEY AUTO_INCREMENT,
    idAlumno INT NOT NULL,
    idComputadora INT NOT NULL,
    fechaReserva DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno),
    FOREIGN KEY (idComputadora) REFERENCES Computadora(idComputadora)
);


DELIMITER //

-- Trigger para verificar el tiempo de uso de la computadora
CREATE TRIGGER VerificarTiempoLimite
BEFORE INSERT ON Reserva
FOR EACH ROW
BEGIN
    DECLARE tiempoTotal INT;
    DECLARE tiempoLimite INT;
    
    -- Calcular el tiempo total de la reserva en minutos
    SET tiempoTotal = TIME_TO_SEC(TIMEDIFF(NEW.horaFin, NEW.horaInicio)) / 60;
    
    -- Obtener el tiempo límite permitido para el alumno
    SELECT tiempoLimite INTO tiempoLimite FROM Carrera
    WHERE idCarrera = (SELECT idCarrera FROM Alumno WHERE idAlumno = NEW.idAlumno);
    
    -- Si el tiempo total de la reserva excede el límite, lanzamos un error
    IF tiempoTotal > tiempoLimite THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Tiempo de reserva excede el límite permitido para su carrera';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER VerificarSuperposicionReserva
BEFORE INSERT ON Reserva
FOR EACH ROW
BEGIN
    DECLARE reservaExistente INT;

    -- Contar las reservas que se superponen con la nueva reserva
    SELECT COUNT(*) INTO reservaExistente
    FROM Reserva
    WHERE idComputadora = NEW.idComputadora
      AND fechaReserva = NEW.fechaReserva
      AND (NEW.horaInicio BETWEEN horaInicio AND horaFin
           OR NEW.horaFin BETWEEN horaInicio AND horaFin
           OR horaInicio BETWEEN NEW.horaInicio AND NEW.horaFin);

    -- Si hay una superposición, se lanza un error
    IF reservaExistente > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La computadora ya está reservada en ese intervalo de tiempo';
    END IF;
END //

DELIMITER ;

DELIMITER //
-- tener en cuenta las reglas, las aplicaremos?
CREATE TRIGGER BloquearPorExcesoDeHoras
AFTER INSERT ON Reserva
FOR EACH ROW
BEGIN
    DECLARE minutosTotales INT;
    DECLARE tiempoLimite INT;

    -- Obtener el tiempo límite permitido para el alumno
    SELECT tiempoLimite INTO tiempoLimite FROM Carrera
    WHERE idCarrera = (SELECT idCarrera FROM Alumno WHERE idAlumno = NEW.idAlumno);
    
    -- Calcular el tiempo total reservado por el alumno en el día
    SELECT SUM(TIME_TO_SEC(TIMEDIFF(r.horaFin, r.horaInicio)) / 60) INTO minutosTotales
    FROM Reserva r
    WHERE r.idAlumno = NEW.idAlumno
      AND r.fechaReserva = NEW.fechaReserva;

    -- Si el tiempo reservado supera el límite, bloquear al alumno
    IF minutosTotales > tiempoLimite THEN
        UPDATE Alumno
        SET estatus = 'Bloqueado'
        WHERE idAlumno = NEW.idAlumno;

        -- Registrar el motivo del bloqueo
        INSERT INTO Bloqueo (idAlumno, motivo, fechaDeBloqueo)
        VALUES (NEW.idAlumno, 'Exceso de tiempo permitido en un solo día', CURDATE());
    END IF;
END //

DELIMITER ;

DELIMITER //

-- Marcar la computadora como "Ocupada" cuando se hace una reserva
CREATE TRIGGER MarcarComputadoraOcupada
AFTER INSERT ON Reserva
FOR EACH ROW
BEGIN
    UPDATE Computadora
    SET estatus = 'Ocupada'
    WHERE idComputadora = NEW.idComputadora;
END //

-- Marcar la computadora como "Disponible" cuando se elimina una reserva
CREATE TRIGGER MarcarComputadoraDisponible
AFTER DELETE ON Reserva
FOR EACH ROW
BEGIN
    UPDATE Computadora
    SET estatus = 'Disponible'
    WHERE idComputadora = OLD.idComputadora;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ReporteUsoPorCarrera(IN carreraID INT)
BEGIN
    SELECT a.nombreAlumno, c.numeroMaquina, SUM(TIME_TO_SEC(TIMEDIFF(r.horaFin, r.horaInicio)) / 60) AS minutosUsados
    FROM Alumno a
    JOIN Reserva r ON a.idAlumno = r.idAlumno
    JOIN Computadora c ON r.idComputadora = c.idComputadora
    WHERE a.idCarrera = carreraID
    GROUP BY a.nombreAlumno, c.numeroMaquina;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ReporteAlumnosBloqueados()
BEGIN
    SELECT a.nombreAlumno, b.motivo, b.fechaDeBloqueo
    FROM Alumno a
    JOIN Bloqueo b ON a.idAlumno = b.idAlumno
    WHERE a.estatus = 'Bloqueado';
END //

DELIMITER ;
