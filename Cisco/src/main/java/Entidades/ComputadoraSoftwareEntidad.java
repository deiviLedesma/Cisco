/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author filor
 */
@Entity
public class ComputadoraSoftwareEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = ComputadoraEntidad.class)
    @JoinColumn(name = "idComputadora", nullable = false)
    private ComputadoraEntidad computadora;
    
    @ManyToOne(targetEntity = SoftwareEntidad.class)
    @JoinColumn(name = "idSoftware", nullable = false)
    private SoftwareEntidad software;
    
    public ComputadoraSoftwareEntidad() {
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
        if (!(object instanceof ComputadoraSoftwareEntidad)) {
            return false;
        }
        ComputadoraSoftwareEntidad other = (ComputadoraSoftwareEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.computadoraSoftwareEntidad[ id=" + id + " ]";
    }
    
}
