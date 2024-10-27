/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.BloqueoEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Negocio.BloqueoNegocio;
import Negocio.CentroComputoNegocio;
import daos.AlumnoDAO;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import java.util.List;

/**
 *
 * @author filor
 */
public class BloqueoConvertidor {
    private static IAlumnoDAO alumnoDAO;
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static BloqueoEntidad convertirDTOAEntidad(BloqueoNegocio dto) throws PersistenciaException {
        alumnoDAO = new AlumnoDAO();
        BloqueoEntidad bloqueo = new BloqueoEntidad();

        asignarAtributosSimplesDTOaEntidad(bloqueo, dto);
        
        bloqueo.setBloqueoAlumno(alumnoDAO.consultarAlumnoPorID(dto.getIdAlumno()));
        
        return bloqueo;
    }
    
    /**
     * 
     * @param entidad
     * @param dto 
     */
    private static void asignarAtributosSimplesDTOaEntidad(BloqueoEntidad entidad, BloqueoNegocio dto) {
        entidad.setId(dto.getIdBloqueo());
        entidad.setFechaBloqueo(dto.getFechaDeBloqueo());
        entidad.setMotivo(dto.getMotivo());
    }
}
