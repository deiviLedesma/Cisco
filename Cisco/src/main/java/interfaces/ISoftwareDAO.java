/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.SoftwareEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface ISoftwareDAO {
    public void agregarSoftware(SoftwareEntidad unidad) throws PersistenciaException;
    
    public void eliminarAlumno(Long id) throws PersistenciaException;
    
    public SoftwareEntidad consultarSoftwarePorID(Long id) throws PersistenciaException;
}
