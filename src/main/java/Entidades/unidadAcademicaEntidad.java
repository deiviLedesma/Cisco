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
@Table(name="tblUnidadesAcademicas")
public class unidadAcademicaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombreUnidad",length=20,nullable=false)
    private String nombreUnidad;
    
    @OneToMany(mappedBy = "centroUnidad", cascade = {CascadeType.PERSIST})
    private List<centroDeComputoEntidad> centroUnidad;
    /**
     * 
     */
    public unidadAcademicaEntidad() {
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
        if (!(object instanceof unidadAcademicaEntidad)) {
            return false;
        }
        unidadAcademicaEntidad other = (unidadAcademicaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.unidadAcademicaEntidad[ id=" + id + " ]";
    }
    
}
