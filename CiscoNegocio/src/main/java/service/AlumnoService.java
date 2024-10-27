/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.AlumnoEntidad;
import Entidades.ComputadoraEntidad;
import Negocio.AlumnoNegocio;
import Negocio.ComputadoraNegocio;
import static convertidores.AlumnoConvertidor.convertirDTOAEntidad;
import daos.AlumnoDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;

/**
 *
 * @author filor
 */
public class AlumnoService {
    private IAlumnoDAO alumnoDAO;

    public AlumnoService() {
        this.alumnoDAO = new AlumnoDAO();
    }
    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarAlumno(AlumnoNegocio dto) throws NegocioException {
        validarAlumno(dto);
        
        try {
            AlumnoEntidad alumno = convertirDTOAEntidad(dto);
            
            alumnoDAO.agregarAlumno(alumno);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar al alumno en la capa de negocio", e);
        }
    }
    /**
     * 
     * @param alumno
     * @throws NegocioException 
     */
    private void validarAlumno(AlumnoNegocio alumno) throws NegocioException {
        if (alumno.getNombreAlumno().equals("") || alumno.getApellidoPaterno().equals("")) {
            throw new NegocioException("El alumno debe terner nombre");
        }
        if (alumno.getContraseña().equals("")) {
            throw new NegocioException("El alumno debe tener contrasena");
        }
    }
}
