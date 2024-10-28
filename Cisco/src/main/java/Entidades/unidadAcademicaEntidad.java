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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="UnidadAcademica")
public class UnidadAcademicaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idUnidad")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombreUnidad",length=100,nullable=false)
    private String nombreUnidad;
    
    @OneToMany(mappedBy = "centroUnidad")
    private List<CentroDeComputoEntidad> centroUnidad;
    /**
     * 
     */
    public UnidadAcademicaEntidad() {
    }

    public UnidadAcademicaEntidad(Long id, String nombreUnidad, List<CentroDeComputoEntidad> centroUnidad) {
        this.id = id;
        this.nombreUnidad = nombreUnidad;
        this.centroUnidad = centroUnidad;
    }

    public UnidadAcademicaEntidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    
    public UnidadAcademicaEntidad(String nombreUnidad, List<CentroDeComputoEntidad> centroUnidad) {
        this.nombreUnidad = nombreUnidad;
        this.centroUnidad = centroUnidad;
    }

    public List<CentroDeComputoEntidad> getCentroUnidad() {
        return centroUnidad;
    }

    public void setCentroUnidad(List<CentroDeComputoEntidad> centroUnidad) {
        this.centroUnidad = centroUnidad;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
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
        if (!(object instanceof UnidadAcademicaEntidad)) {
            return false;
        }
        UnidadAcademicaEntidad other = (UnidadAcademicaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.unidadAcademicaEntidad[ id=" + id + " ]" + "nombre: " + this.getNombreUnidad();
    }
    
}
