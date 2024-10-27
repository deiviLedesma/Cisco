/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import Entidades.ReservaEntidad;
import Negocio.AlumnoNegocio;
import Negocio.ReservaNegocio;
import daos.AlumnoDAO;
import daos.CarreraDAO;
import daos.ComputadoraDAO;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import interfaces.IComputadoraDAO;
import java.util.List;

/**
 *
 * @author filor
 */
public class ReservaConvertidor {
    private static IAlumnoDAO alumnoDAO;
    private static IComputadoraDAO pcDAO;
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static ReservaEntidad convertirDTOAEntidad(ReservaNegocio dto) throws PersistenciaException {
        alumnoDAO = new AlumnoDAO();
        pcDAO = new ComputadoraDAO();
        ReservaEntidad reserva = new ReservaEntidad();
        
        asignarAtributosSimplesDTOaEntidad(reserva, dto);
        
        reserva.setReservaAlumno(alumnoDAO.consultarAlumnoPorID(dto.getIdAlumno()));
        reserva.setReservaCompu(pcDAO.consultarPCPorID(dto.getIdPC()));
        
        return reserva;
    }
    
    /**
     * 
     * @param entidad
     * @param dto 
     */
    private static void asignarAtributosSimplesDTOaEntidad(ReservaEntidad entidad, ReservaNegocio dto) {
        entidad.setFechaReserva(dto.getFechaReserva());
        entidad.setHoraFin(dto.getHoraFin());
        entidad.setHoraInicio(dto.getHoraInicio());
        entidad.setId(dto.getIdAlumno());
    }
}
