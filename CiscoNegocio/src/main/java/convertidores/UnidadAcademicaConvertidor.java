/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.UnidadAcademicaEntidad;
import Negocio.CarreraNegocio;
import Negocio.UnidadAcademicaNegocio;
import exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author filor
 */
public class UnidadAcademicaConvertidor {
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static UnidadAcademicaEntidad convertirDTOAEntidad(UnidadAcademicaNegocio dto) throws PersistenciaException {
        UnidadAcademicaEntidad entidad = new UnidadAcademicaEntidad();

        entidad.setId(dto.getIdUnidad());
        entidad.setNombreUnidad(dto.getNombreUnidad());
        
        List<CentroDeComputoEntidad> centros = convertirCentrosIds(dto.getIdsCentros());
        entidad.setCentroUnidad(centros);

        return entidad;
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<CentroDeComputoEntidad> convertirCentrosIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<CentroDeComputoEntidad> centros = new ArrayList<>();
        for (Long pagoId : ids) {
            CentroDeComputoEntidad entidad = new CentroDeComputoEntidad();
            entidad.setId(pagoId);
            
            centros.add(entidad);
        }
        return centros;
    }
}
