/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.AlumnoEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface IAlumnoDAO {
    public void agregarAlumno(AlumnoEntidad alumno) throws PersistenciaException;
    
    public void eliminarAlumno(Long id) throws PersistenciaException;
    
    public AlumnoEntidad consultarAlumnoPorID(Long id) throws PersistenciaException;
}
