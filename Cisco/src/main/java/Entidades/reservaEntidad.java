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
@Table(name="tblReserva")
public class reservaEntidad implements Serializable {

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
    
    @ManyToOne(targetEntity = alumnoEntidad.class)
    @JoinColumn(name = "idAlumno", nullable = false)
    private alumnoEntidad reservaAlumno;
    
    @ManyToOne(targetEntity = computadoraEntidad.class)
    @JoinColumn(name = "idComputadora", nullable = false)
    private computadoraEntidad reservaCompu;
    
    /**
     * 
     */
    public reservaEntidad() {
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
        if (!(object instanceof reservaEntidad)) {
            return false;
        }
        reservaEntidad other = (reservaEntidad) object;
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
