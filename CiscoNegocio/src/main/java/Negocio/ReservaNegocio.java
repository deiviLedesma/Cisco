/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class ReservaNegocio {
    public Long idReserva;
    public Date horaInicio,horaFin;
    public LocalDateTime fechaReserva;
    public Long idAlumno, idPC;

    public ReservaNegocio() {
    }

    public ReservaNegocio(Long idReserva, Date horaInicio, Date horaFin, LocalDateTime fechaReserva, Long idAlumno, Long idPC) {
        this.idReserva = idReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaReserva = fechaReserva;
        this.idAlumno = idAlumno;
        this.idPC = idPC;
    }

    public ReservaNegocio(Long idReserva, Date horaInicio, Date horaFin, LocalDateTime fechaReserva) {
        this.idReserva = idReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaReserva = fechaReserva;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdPC() {
        return idPC;
    }

    public void setIdPC(Long idPC) {
        this.idPC = idPC;
    }
    
    
    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "ReservaNegocio{" + "fechaReserva=" + fechaReserva + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
}
