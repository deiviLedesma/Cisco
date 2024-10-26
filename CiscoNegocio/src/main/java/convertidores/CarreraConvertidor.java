/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Negocio.CarreraNegocio;
import exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import service.CarreraService;

/**
 *
 * @author filor
 */
public class CarreraConvertidor {
    
    /**
     * 
     * @param beneficarioDTO
     * @return
     * @throws PersistenciaException 
     */
    public static CarreraEntidad convertirDTOAEntidad(CarreraNegocio dto) throws PersistenciaException {
        CarreraEntidad entidad = new CarreraEntidad();

        asignarAtributosSimplesDTOaEntidad(entidad, dto);
        
        List<AlumnoEntidad> alumnos = convertirAlumnosIds(dto.getIdsAlumnos());
        entidad.setCarreraAlumno(alumnos);

        return entidad;
    }
    
    /**
     * 
     * @param entidad
     * @param dto 
     */
    private static void asignarAtributosSimplesDTOaEntidad(CarreraEntidad entidad, CarreraNegocio dto) {
        entidad.setId(dto.getIdCarrera());
        entidad.setNombreDeCarrera(dto.getNombreCarrera());
        entidad.setTiempoLimite(dto.getTiempoLimite());
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<AlumnoEntidad> convertirAlumnosIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<AlumnoEntidad> alumnos = new ArrayList<>();
        for (Long pagoId : ids) {
            AlumnoEntidad entidad = new AlumnoEntidad();
            entidad.setId(pagoId);
            
            alumnos.add(entidad);
        }
        return alumnos;
    }
}
