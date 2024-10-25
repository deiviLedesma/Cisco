/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.CentroDeComputoEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface ICentroDeComputoDAO {
    public void agregarCentro(CentroDeComputoEntidad centro) throws PersistenciaException;
    
    public void eliminarCentro(Long id) throws PersistenciaException;
    
    public void editarCentro(CentroDeComputoEntidad entidad) throws PersistenciaException;
}
