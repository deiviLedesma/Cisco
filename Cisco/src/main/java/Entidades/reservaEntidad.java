/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="Reserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idReserva")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fechaReserva", nullable = false)
    private LocalDateTime fechaReserva;
    
    @Column(name = "horaInicio", nullable = false)
    private Time horaInicio;
    
    @Column(name = "horaFin", nullable = false)
    private Time horaFin;
    
    @ManyToOne(targetEntity = AlumnoEntidad.class)
    @JoinColumn(name = "idAlumno", nullable = false)
    private AlumnoEntidad reservaAlumno;
    
    @ManyToOne(targetEntity = ComputadoraEntidad.class)
    @JoinColumn(name = "idComputadora", nullable = false)
    private ComputadoraEntidad reservaCompu;
    
    /**
     * 
     */
    public ReservaEntidad() {
    }

    public ReservaEntidad(Long id, LocalDateTime fechaReserva, Time horaInicio, Time horaFin, AlumnoEntidad reservaAlumno, ComputadoraEntidad reservaCompu) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.reservaAlumno = reservaAlumno;
        this.reservaCompu = reservaCompu;
    }

    public ReservaEntidad(LocalDateTime fechaReserva, Time horaInicio, Time horaFin) {
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public AlumnoEntidad getReservaAlumno() {
        return reservaAlumno;
    }

    public void setReservaAlumno(AlumnoEntidad reservaAlumno) {
        this.reservaAlumno = reservaAlumno;
    }

    public ComputadoraEntidad getReservaCompu() {
        return reservaCompu;
    }

    public void setReservaCompu(ComputadoraEntidad reservaCompu) {
        this.reservaCompu = reservaCompu;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaEntidad)) {
            return false;
        }
        ReservaEntidad other = (ReservaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.reservaEntidad[ id=" + id + " ]";
    }
    
}
