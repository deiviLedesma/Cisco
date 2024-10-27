/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author filor
 */
public interface IUnidadAcademicaDAO {
    public void agregarUnidad(UnidadAcademicaEntidad unidad) throws PersistenciaException;
    
    public UnidadAcademicaEntidad consultarUnidadPorID(Long id) throws PersistenciaException;
    
    public List<UnidadAcademicaEntidad> listaUnidades() throws PersistenciaException;
}
