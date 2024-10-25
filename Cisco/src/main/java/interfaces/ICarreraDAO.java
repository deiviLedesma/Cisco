/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.CarreraEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface ICarreraDAO {
    public void agregarCarrera(CarreraEntidad carrera) throws PersistenciaException;
    
    public CarreraEntidad consultarCarreraPorID(Long id) throws PersistenciaException;
    
    public void editarCarrera(CarreraEntidad entidad) throws PersistenciaException;
}
