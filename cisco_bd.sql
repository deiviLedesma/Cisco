create database Cisco;
use Cisco;

CREATE TABLE CentroComputo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreCentro VARCHAR(100) NOT NULL,
    contraseniaMaestra VARCHAR(255) NOT NULL
);

CREATE TABLE Computadora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ip VARCHAR(15) NOT NULL,
    estatus ENUM('Disponible', 'Ocupada') NOT NULL,
    nombreAlumno VARCHAR(100) DEFAULT 'Disponible',
    id_centro_computo INT,
    FOREIGN KEY (id_centro_computo) REFERENCES CentroComputo(id)
);

CREATE TABLE Alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    carrera INT,
    bloqueado BOOLEAN DEFAULT FALSE,
    fecha_bloqueo DATE DEFAULT NULL
);

CREATE TABLE Carrera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tiempo_maximo_uso INT NOT NULL  -- Tiempo máximo en minutos
);

CREATE TABLE Bloqueo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT,
    fecha DATE NOT NULL,
    motivo VARCHAR(255),
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id)
);

 DELIMITER //
CREATE TRIGGER asignarAlumno
BEFORE UPDATE ON Computadora
FOR EACH ROW
BEGIN
    IF NEW.nombrealumno IS NOT NULL THEN
        SET NEW.estatus = 'Ocupada';
    ELSE
        SET NEW.estatus = 'Disponible';
    END IF;
END;
DELIMITTER; -- Cuando se asigna un alumno a una computadora, el estatus de la computadora se actualiza automáticamente a "Ocupada".

DELIMITER //
CREATE TRIGGER registrarBloqueo
AFTER UPDATE ON Alumno
FOR EACH ROW
BEGIN
    IF NEW.bloqueado = TRUE AND OLD.bloqueado = FALSE THEN
        INSERT INTO Bloqueo (id_alumno, fecha, motivo)
        VALUES (NEW.id, NOW());
    END IF;
END;
DELIMITER; -- Este trigger registra el bloqueo de un alumno cuando la columna bloqueado se actualiza a TRUE.

DELIMITER //

CREATE PROCEDURE asignarComputadora(
    IN p_matricula VARCHAR(20),
    IN p_centro_computo INT
)
BEGIN
    DECLARE v_alumno_id INT;
    DECLARE v_computadora_id INT;
    
    -- Buscar ID del alumno
    SELECT id INTO v_alumno_id FROM Alumno WHERE matricula = p_matricula;
    
    -- Verificar si el alumno está bloqueado
    IF (SELECT bloqueado FROM Alumno WHERE id = v_alumno_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El alumno está bloqueado';
    ELSE
        -- Buscar una computadora disponible
        SELECT id INTO v_computadora_id 
        FROM Computadora 
        WHERE id_centro_computo = p_centro_computo AND estatus = 'Disponible' LIMIT 1;
        
        IF v_computadora_id IS NULL THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay computadoras disponibles';
        ELSE
            -- Asignar la computadora al alumno
            UPDATE Computadora
            SET nombre_alumno = (SELECT nombre FROM Alumno WHERE id = v_alumno_id)
            WHERE id = v_computadora_id;
        END IF;
    END IF;
    
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE bloquearAlumno(
    IN p_matricula VARCHAR(20),
    IN p_motivo VARCHAR(255)
)
BEGIN
    DECLARE v_alumno_id INT;
    
    -- Buscar el ID del alumno
    SELECT id INTO v_alumno_id FROM Alumno WHERE matricula = p_matricula;
    
    -- Bloquear al alumno
    UPDATE Alumno
    SET bloqueado = TRUE, fecha_bloqueo = CURDATE(), motivo_bloqueo = p_motivo
    WHERE id = v_alumno_id;
    
    -- Registrar bloqueo en la tabla de bloqueos
    INSERT INTO Bloqueo (id_alumno, fecha, motivo)
    VALUES (v_alumno_id, CURDATE());
    
END //

DELIMITER ; -- Este procedimiento bloquea a un alumno, registra la fecha y el motivo del bloqueo.

ALTER TABLE Computadora
ADD CONSTRAINT fk_centro_computo
FOREIGN KEY (id_centro_computo)
REFERENCES CentroComputo(id)
ON DELETE CASCADE;

ALTER TABLE Alumno
ADD CONSTRAINT fk_carrera
FOREIGN KEY (carrera)
REFERENCES Carrera(id);




