/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.ReservaEntidad;
import Entidades.SoftwareEntidad;
import Negocio.CentroComputoNegocio;
import Negocio.SoftwareNegocio;
import daos.ComputadoraSoftwareDAO;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.IComputadoraSoftwareDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author filor
 */
public class SoftwareConvertidor {
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static SoftwareEntidad convertirDTOAEntidad(SoftwareNegocio dto) throws PersistenciaException {
        SoftwareEntidad software = new SoftwareEntidad();
        
        software.setId(dto.getIdSoftware());
        software.setNombreSoftware(dto.getNombre());
        
        List<ComputadoraSoftwareEntidad> compuSoftwares = convertirCompuSoftwaresIds(dto.getIdsPCs());
        software.setSoftware(compuSoftwares);
        
        return software;
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<ComputadoraSoftwareEntidad> convertirCompuSoftwaresIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<ComputadoraSoftwareEntidad> lista = new ArrayList<>();
        for (Long id : ids) {
            ComputadoraSoftwareEntidad entidad = new ComputadoraSoftwareEntidad();
            entidad.setId(id);
            
            lista.add(entidad);
        }
        return lista;
    }
}
