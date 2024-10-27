/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.ReservaEntidad;
import Negocio.AlumnoNegocio;
import Negocio.ComputadoraNegocio;
import daos.CarreraDAO;
import daos.CentroDeComputoDAO;
import exceptions.PersistenciaException;
import interfaces.ICarreraDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author filor
 */
public class AlumnoConvertidor {
    private static ICarreraDAO carreraDAO;
    
    public static AlumnoEntidad convertirDTOAEntidad(AlumnoNegocio dto) throws PersistenciaException {
        carreraDAO = new CarreraDAO(); 
        
        AlumnoEntidad alumno = new AlumnoEntidad();
        
        asignarAtributosSimplesDTOaEntidad(alumno, dto);
        
        alumno.setCarreraEntidad(carreraDAO.consultarCarreraPorID(dto.getIdCarrera()));
        
        List<ReservaEntidad> reservas = convertirReservasIds(dto.getIdsReservas());
        alumno.setReservaAlumno(reservas);
        
        List<BloqueoEntidad> bloqueos = convertirBloqueosIds(dto.getIdsBloqueos());
        alumno.setBloqueoAlumno(bloqueos);
        
        return alumno;
    }
    
    /**
     * 
     * @param entidad
     * @param dto 
     */
    private static void asignarAtributosSimplesDTOaEntidad(AlumnoEntidad entidad, AlumnoNegocio dto) {
        entidad.setContrasenha(dto.getContraseña());
        entidad.setEstatus(dto.getStatus());
        entidad.setId(dto.getIdAlumno());
        entidad.setNombres(dto.getNombreAlumno());
        entidad.setaPaterno(dto.getApellidoPaterno());
        entidad.setaMaterno(dto.getApellidoMaterno());
        entidad.setMinutosReservados(dto.getMinutosReservados());
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<ReservaEntidad> convertirReservasIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<ReservaEntidad> reservas = new ArrayList<>();
        for (Long id : ids) {
            ReservaEntidad entidad = new ReservaEntidad();
            entidad.setId(id);
            
            reservas.add(entidad);
        }
        return reservas;
    }
    
    private static List<BloqueoEntidad> convertirBloqueosIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        for (Long id : ids) {
            BloqueoEntidad entidad = new BloqueoEntidad();
            entidad.setId(id);
            
            bloqueos.add(entidad);
        }
        return bloqueos;
    }
}
