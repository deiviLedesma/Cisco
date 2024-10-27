/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Negocio.CentroComputoNegocio;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.IUnidadAcademicaDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author filor
 */
public class CentroConvertidor {
    
    private static IUnidadAcademicaDAO unidadDAO;

    /**
     *
     * @param dto
     * @return
     * @throws PersistenciaException
     */
    public static CentroDeComputoEntidad convertirDTOAEntidad(CentroComputoNegocio dto) throws PersistenciaException {
        unidadDAO = new UnidadAcademicaDAO();
        
        CentroDeComputoEntidad entidad = new CentroDeComputoEntidad();
        
        asignarAtributosSimplesDTOaEntidad(entidad, dto);
        
        entidad.setCentroUnidad(unidadDAO.consultarUnidadPorID(dto.getIdUnidad()));
        
        List<ComputadoraEntidad> pcs = convertirComputadoraIds(dto.getIdsPCs());
        entidad.setCentroCompuadora(pcs);
        
        return entidad;
    }

    /**
     *
     * @param entidad
     * @param dto
     */
    private static void asignarAtributosSimplesDTOaEntidad(CentroDeComputoEntidad entidad, CentroComputoNegocio dto) {
        entidad.setContrasenaMaestra(dto.getContraseñaMaestra());
        entidad.setHoraApertura(dto.getHoraApertura());
        entidad.setHoraCierre(dto.getHoraCierre());
        entidad.setNombreDeCentro(dto.getNombreCentro());
        entidad.setId(dto.getIdCentro());
    }

    /**
     *
     * @param ids
     * @return
     * @throws PersistenciaException
     */
    private static List<ComputadoraEntidad> convertirComputadoraIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }
        
        List<ComputadoraEntidad> pcs = new ArrayList<>();
        for (Long pagoId : ids) {
            ComputadoraEntidad entidad = new ComputadoraEntidad();
            entidad.setId(pagoId);
            
            pcs.add(entidad);
        }
        return pcs;
    }
    
    public static CentroComputoNegocio convertirEntidadADTO(CentroDeComputoEntidad entidad) throws PersistenciaException {
        CentroComputoNegocio centro = new CentroComputoNegocio();
        
        asignarAtributosSimplesEntidadADTO(entidad, centro);
        
        List<Long> pcs = convertirPcEntidades(entidad.getCentroCompuadora());
        centro.setIdsPCs(pcs);
        return centro;
    }

    /**
     *
     * @param entidad
     * @param dto
     */
    private static void asignarAtributosSimplesEntidadADTO(CentroDeComputoEntidad entidad, CentroComputoNegocio dto) {
        dto.setIdCentro(entidad.getId());
        dto.setContraseñaMaestra(entidad.getContrasenaMaestra());
        dto.setNombreCentro(entidad.getNombreDeCentro());
        dto.setHoraApertura(entidad.getHoraApertura());
        dto.setHoraCierre(entidad.getHoraCierre());
    }
    
    private static List<Long> convertirPcEntidades(List<ComputadoraEntidad> compus) throws PersistenciaException {
        List<Long> ids = new ArrayList<>();
        for (ComputadoraEntidad entidad : compus) {
            ids.add(entidad.getId());
        }
        return ids;
    }
}
