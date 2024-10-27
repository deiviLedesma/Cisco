/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.CentroDeComputoEntidad;
import Negocio.CentroComputoNegocio;
import static convertidores.CentroConvertidor.convertirDTOAEntidad;
import static convertidores.CentroConvertidor.convertirEntidadADTO;
import daos.CentroDeComputoDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.ICentroDeComputoDAO;
import java.util.ArrayList;
import java.util.List;

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
            throw new NegocioException("Error al agregar en centro en la capa de negocio", e);
        }
    }
    
    public void editarCentro(CentroComputoNegocio dto) throws NegocioException {

        validarCentro(dto);

        try {
            CentroDeComputoEntidad entidad = convertirDTOAEntidad(dto);

            centroDAO.editarCentro(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar en centro en la capa de negocio", e);
        }
    }
    
    /**
     * 
     * @param limite
     * @param numeroPagina
     * @param nombreCentro
     * @return
     * @throws NegocioException 
     */
    public List<CentroComputoNegocio> listaCentrosPaginado(int limite, int numeroPagina, String nombreCentro) throws NegocioException {
        System.out.println(numeroPagina);
        try {
            List<CentroDeComputoEntidad> listaEntidad = centroDAO.listaCentrosPaginado(limite, numeroPagina, nombreCentro);
            List<CentroComputoNegocio> listaCentrosDTO = new ArrayList<>();

            for (CentroDeComputoEntidad centro : listaEntidad) {
                CentroComputoNegocio centroDTO = convertirEntidadADTO(centro);
                listaCentrosDTO.add(centroDTO);
            }
            if (listaCentrosDTO.isEmpty() && numeroPagina == 1) {
                throw new NegocioException("No existen centros registrados");

            }
            return listaCentrosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de los centros de computo desde la base de datos.", e);
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
