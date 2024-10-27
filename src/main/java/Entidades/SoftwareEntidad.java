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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="Software")
public class SoftwareEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idSoftware")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombreSoftware",length=30,nullable=false)
    private String nombreSoftware;
    
    @OneToMany(mappedBy = "software")
    private List<ComputadoraSoftwareEntidad> software;
    /**
     * 
     */
    public SoftwareEntidad() {
    }

    public SoftwareEntidad(Long id, String nombreSoftware, List<ComputadoraSoftwareEntidad> software) {
        this.id = id;
        this.nombreSoftware = nombreSoftware;
        this.software = software;
    }

    public SoftwareEntidad(String nombreSoftware) {
        this.nombreSoftware = nombreSoftware;
    }

    public String getNombreSoftware() {
        return nombreSoftware;
    }

    public void setNombreSoftware(String nombreSoftware) {
        this.nombreSoftware = nombreSoftware;
    }

    public List<ComputadoraSoftwareEntidad> getSoftware() {
        return software;
    }

    public void setSoftware(List<ComputadoraSoftwareEntidad> software) {
        this.software = software;
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
        if (!(object instanceof SoftwareEntidad)) {
            return false;
        }
        SoftwareEntidad other = (SoftwareEntidad) object;
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
