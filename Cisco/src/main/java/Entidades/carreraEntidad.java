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
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="tblCarreras")
public class carreraEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idCarreras")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombreDeCarrera",length=30,nullable=false)
    private String nombreDeCarrera;
    
    @Column(name="tiempoLimite",nullable=false)
    private int tiempoLimite;
    
    /**
     * 
     */
    public carreraEntidad() {
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
        if (!(object instanceof carreraEntidad)) {
            return false;
        }
        carreraEntidad other = (carreraEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.carreraEntidad[ id=" + id + " ]";
    }
    
}
