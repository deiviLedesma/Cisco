/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.CarreraEntidad;
import Negocio.CarreraNegocio;
import static convertidores.CarreraConvertidor.convertirDTOAEntidad;
import daos.CarreraDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.ICarreraDAO;
import java.math.BigDecimal;

/**
 *
 * @author filor
 */
public class CarreraService {
    private ICarreraDAO carreraDAO;

    public CarreraService() {
        this.carreraDAO = new CarreraDAO();
    }

    public CarreraService(ICarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }
    
    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarCarrera(CarreraNegocio dto) throws NegocioException {

        validarCarrera(dto);

        try {
            CarreraEntidad entidad = convertirDTOAEntidad(dto);

            carreraDAO.agregarCarrera(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la carrera en la capa de negocio", e);
        }
    }
    /**
     * 
     * @param id
     * @throws NegocioException 
     */
    public void eliminarCarrera(Long id) throws NegocioException {
        try {
            CarreraEntidad entidad = carreraDAO.consultarCarreraPorID(id);
            validarCarrera(entidad);
            carreraDAO.eliminarCarrera(entidad.getId());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar la carrera.", ex);
        }
    }
    
    
    public void editarCarrera(CarreraNegocio dto) throws NegocioException {
        try {
            validarCarrera(dto);
            CarreraEntidad entidad = convertirDTOAEntidad(dto);
            carreraDAO.editarCarrera(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al editar la carrera", e);
        }
    }
    
    /**
     * 
     * @param carrera
     * @throws NegocioException 
     */
    private void validarCarrera(CarreraNegocio carrera) throws NegocioException {
        if (carrera.getNombreCarrera() == null) {
            throw new NegocioException("El nombre de la carrera no puede estar vacío");
        }
        
        if (carrera.getTiempoLimite() <0) {
            throw new NegocioException("No puede tener tiempo en negativo");
        }
    }
    
    private void validarCarrera(CarreraEntidad carrera) throws NegocioException {

        if (carrera == null) {
            throw new NegocioException("la carrera no existe.");
        }
    }
}
