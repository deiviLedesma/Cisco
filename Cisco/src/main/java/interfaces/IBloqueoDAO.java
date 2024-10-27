/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.BloqueoEntidad;
import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author filor
 */
public interface IBloqueoDAO {
    public void agregarBloqueo(BloqueoEntidad entidad) throws PersistenciaException;
    
    public void eliminarBloqueo(Long id) throws PersistenciaException;
    
    public List<BloqueoEntidad> listaBloqueos() throws PersistenciaException;
    
    BloqueoEntidad consultarBloqueoPorID(Long id) throws PersistenciaException;
}
