/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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
@Table(name="tblBloqueos")
public class bloqueoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idBloqueo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "fechaBloqueo", nullable = false)
    private LocalDateTime fechaBloqueo;
    
    @Column(name="Motivo",length=40,nullable=false)
    private String motivo;
    
    @ManyToOne(targetEntity = alumnoEntidad.class)
    @JoinColumn(name = "idAlumno", nullable = false)
    private alumnoEntidad bloqueoAlumno;
    

    /**
     * 
     */
    public bloqueoEntidad() {
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
        if (!(object instanceof bloqueoEntidad)) {
            return false;
        }
        bloqueoEntidad other = (bloqueoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.bloqueoEntidad[ id=" + id + " ]";
    }
    
}
