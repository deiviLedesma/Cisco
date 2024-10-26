/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import Negocio.CarreraNegocio;
import Negocio.CentroComputoNegocio;
import static convertidores.CarreraConvertidor.convertirDTOAEntidad;
import daos.CarreraDAO;
import daos.CentroDeComputoDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.ICarreraDAO;
import interfaces.ICentroDeComputoDAO;

/**
 *
 * @author filor
 */
public class CentroDeComputoService {
    private ICentroDeComputoDAO centroDAO;

    public CentroDeComputoService() {
        this.centroDAO = new CentroDeComputoDAO();
    }

    public CentroDeComputoService(ICentroDeComputoDAO centroDAO) {
        this.centroDAO = centroDAO;
    }
    
    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarCentro(CentroComputoNegocio dto) throws NegocioException {

        validarCentro(dto);

        try {
            CentroDeComputoEntidad entidad = convertirDTOAEntidad(dto);

            centroDAO.agregarCentro(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la carrera en la capa de negocio", e);
        }
    }
    
    /**
     * 
     * @param centro
     * @throws NegocioException 
     */
    private void validarCentro(CentroComputoNegocio centro) throws NegocioException {
        if (centro.getNombreCentro().equals("")) {
            throw new NegocioException("El nombre de del centro de computo no puede estar vacío");
        }
        if (centro.getContraseñaMaestra().equals("")) {
            throw new NegocioException("la contrasena del centro de computo no puede estar vacío");
        }
        if (centro.getHoraApertura()==null || centro.getHoraCierre()==null) {
            throw new NegocioException("El centro de computo no puede tener horarios nulos");
        }
    }
}
