/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.ComputadoraEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface IComputadoraDAO {
    public void agregarComputadora(ComputadoraEntidad entidad) throws PersistenciaException;
    
    public void eliminarComputadora(Long id) throws PersistenciaException;
    
    public ComputadoraEntidad consultarPCPorID(Long id) throws PersistenciaException;
}
