/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="tblProgramasDeComputadura")
public class programasDeComputadoraEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idPrograma")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombrePrograma",length=30,nullable=false)
    private String nombrePrograma;
    
    @OneToOne
    @JoinColumn(name = "idComputadora")
    private computadoraEntidad programa;
    /**
     * 
     */
    public programasDeComputadoraEntidad() {
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
        if (!(object instanceof programasDeComputadoraEntidad)) {
            return false;
        }
        programasDeComputadoraEntidad other = (programasDeComputadoraEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.programasDeComputaduraEntidad[ id=" + id + " ]";
    }
    
}
