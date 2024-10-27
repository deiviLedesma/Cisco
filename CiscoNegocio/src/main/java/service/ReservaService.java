/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.ComputadoraEntidad;
import Entidades.ReservaEntidad;
import Negocio.ComputadoraNegocio;
import Negocio.ReservaNegocio;
import static convertidores.ReservaConvertidor.convertirDTOAEntidad;
import daos.ReservaDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IReservaDAO;

/**
 *
 * @author filor
 */
public class ReservaService {
    private IReservaDAO reservaDAO;

    public ReservaService() {
    this.reservaDAO = new ReservaDAO();
    }
    
    public void agregarReserva(ReservaNegocio dto) throws NegocioException {
        
        validarReserva(dto);
        
        try {
            ReservaEntidad reserva = convertirDTOAEntidad(dto);
            reservaDAO.agregarReserva(reserva);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la unidad en la capa de negocio", e);
        }
    }
    
    private void validarReserva(ReservaNegocio reserva) throws NegocioException {
        if (reserva.getFechaReserva()==null) {
            throw new NegocioException("Se debe registrar la fecha de la reserva");
        }
        if (reserva.getHoraFin()==null || reserva.getHoraInicio()==null) {
            throw new NegocioException("La reserva tiene que contar con inicio y final");
        }
    }
}
