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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="Carrera")
public class CarreraEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idCarrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Column(name="nombreCarrera",length=30,nullable=false)
    private String nombreDeCarrera;
    
    @Column(name="tiempoLimite",nullable=false)
    private int tiempoLimite;
    
    @OneToMany(mappedBy = "carreraEntidad", cascade = {CascadeType.PERSIST})
    private List<AlumnoEntidad> carreraAlumno;
    
    /**
     * 
     */
    public CarreraEntidad() {
    }

    public CarreraEntidad(String nombreDeCarrera, int tiempoLimite) {
        this.nombreDeCarrera = nombreDeCarrera;
        this.tiempoLimite = tiempoLimite;
    }

    
    public CarreraEntidad(String nombreDeCarrera, int tiempoLimite, List<AlumnoEntidad> carreraAlumno) {
        this.nombreDeCarrera = nombreDeCarrera;
        this.tiempoLimite = tiempoLimite;
        this.carreraAlumno = carreraAlumno;
    }

    public String getNombreDeCarrera() {
        return nombreDeCarrera;
    }

    public void setNombreDeCarrera(String nombreDeCarrera) {
        this.nombreDeCarrera = nombreDeCarrera;
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public List<AlumnoEntidad> getCarreraAlumno() {
        return carreraAlumno;
    }

    public void setCarreraAlumno(List<AlumnoEntidad> carreraAlumno) {
        this.carreraAlumno = carreraAlumno;
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
        if (!(object instanceof CarreraEntidad)) {
            return false;
        }
        CarreraEntidad other = (CarreraEntidad) object;
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
