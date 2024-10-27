/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.ComputadoraSoftwareEntidad;
import exceptions.PersistenciaException;

/**
 *
 * @author filor
 */
public interface IComputadoraSoftwareDAO {
    public void agregarComputadoraSoftware(ComputadoraSoftwareEntidad entidad) throws PersistenciaException;
}
