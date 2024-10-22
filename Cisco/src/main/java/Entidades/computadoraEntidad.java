/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="tblComputadoras")
public class computadoraEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idComputadora")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="numeroMaquina",nullable=false)
    private int numeroMaquina;
    
    @Column(name="nombreAlumno",length=20,nullable=false)
    private String nombreAlumno;
    
    @Column(name="IP",length=20,nullable=false)
    private String IP;
    
    @OneToOne(mappedBy = "programa")
    private programasDeComputadoraEntidad programa;
    
    @ManyToOne(targetEntity = centroDeComputoEntidad.class)
    @JoinColumn(name = "idCentroDeComputo", nullable = false)
    private centroDeComputoEntidad centroComputadora;
    
    @OneToMany(mappedBy = "reservaCompu", cascade = {CascadeType.PERSIST})
    private List<reservaEntidad> reservaCompu;
    
    
    /**
     * 
     */
    public computadoraEntidad() {
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
        if (!(object instanceof computadoraEntidad)) {
            return false;
        }
        computadoraEntidad other = (computadoraEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.computadoraEntidad[ id=" + id + " ]";
    }
    
}
