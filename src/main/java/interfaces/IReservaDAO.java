/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.ReservaEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface IReservaDAO {
    public void agregarReserva(ReservaEntidad entidad) throws PersistenciaException;
    
    public void eliminarReserva(Long id) throws PersistenciaException;
}
