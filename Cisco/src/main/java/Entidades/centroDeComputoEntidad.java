/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
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
import javax.persistence.Table;

/**
 *
 * @author filor
 */
@Entity
@Table(name="tblCentrosDeComputo")
public class centroDeComputoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idCentroDeComputo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nombreDeCentro",length=30,nullable=false)
    private String nombreDeCentro;
    
    @Column(name="nombreDeUnidad",length=20,nullable=false)
    private String contraseñaMaestra;
    
    @Column(name = "horaApertura", nullable = false)
    private Time horaApertura;
    
    @Column(name = "horaCierre", nullable = false)
    private Time horaCierre;
    
    @ManyToOne(targetEntity = unidadAcademicaEntidad.class)
    @JoinColumn(name = "idUnidadAcademica", nullable = false)
    private unidadAcademicaEntidad centroUnidad;
    
    @OneToMany(mappedBy = "centroComputadora", cascade = {CascadeType.PERSIST})
    private List<computadoraEntidad> centroCompuadora;

    /**
     * 
     */
    public centroDeComputoEntidad() {
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
        if (!(object instanceof centroDeComputoEntidad)) {
            return false;
        }
        centroDeComputoEntidad other = (centroDeComputoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.centroDeComputoEntidad[ id=" + id + " ]";
    }
    
}
