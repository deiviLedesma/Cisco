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
import javax.persistence.Table;
import javax.persistence.OneToOne;


/**
 *
 * @author filor
 */
@Entity
@Table(name="tblAlumnos")
public class alumnoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idAlumno")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name="Nombres",length=40,nullable=false)
    private String nombres;
    
    @Column(name="APaterno",length=20,nullable=false)
    private String aPaterno;
    
    @Column(name="AMaterno",length=20,nullable=false)
    private String aMaterno;
    
    @Column(name="contrasenha",length=20,nullable=false)
    private String contrasenha;
    
    @Column(name="minutosReservados",nullable=false)
    private int minutosReservados;

    @OneToOne (targetEntity = carreraEntidad.class)
    @JoinColumn(name = "Carrera")
    private carreraEntidad carreraEntidad;
    
    @OneToMany(mappedBy = "bloqueoAlumno", cascade = {CascadeType.PERSIST})
    private List<bloqueoEntidad> bloqueoAlumno;
    
    @OneToMany(mappedBy = "reservaAlumno", cascade = {CascadeType.PERSIST})
    private List<reservaEntidad> reservaAlumno;
    /**
     * 
     */
    public alumnoEntidad() {
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
        if (!(object instanceof alumnoEntidad)) {
            return false;
        }
        alumnoEntidad other = (alumnoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.alumnoEntidad[ id=" + id + " ]";
    }
    
}
