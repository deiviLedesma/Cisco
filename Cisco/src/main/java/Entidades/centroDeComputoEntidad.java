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
@Table(name="CentroComputo")
public class CentroDeComputoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idCentro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nombreCentro",length=100,nullable=false)
    private String nombreDeCentro;
    
    @Column(name="contrasenaMaestra",length=100,nullable=false)
    private String contrasenaMaestra;
    
    @Column(name = "horaApertura", nullable = false)
    private Time horaApertura;
    
    @Column(name = "horaCierre", nullable = false)
    private Time horaCierre;
    
    @ManyToOne(targetEntity = UnidadAcademicaEntidad.class)
    @JoinColumn(name = "idUnidad", nullable = false)
    private UnidadAcademicaEntidad centroUnidad;
    
    @OneToMany(mappedBy = "centroComputadora")
    private List<ComputadoraEntidad> centroCompuadora;

    /**
     * 
     */
    public CentroDeComputoEntidad() {
    }

    public CentroDeComputoEntidad(String nombreDeCentro, String contrasenaMaestra, Time horaApertura, Time horaCierre, UnidadAcademicaEntidad centroUnidad, List<ComputadoraEntidad> centroCompuadora) {
        this.nombreDeCentro = nombreDeCentro;
        this.contrasenaMaestra = contrasenaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.centroUnidad = centroUnidad;
        this.centroCompuadora = centroCompuadora;
    }

    public CentroDeComputoEntidad(String nombreDeCentro, String contrasenaMaestra, Time horaApertura, Time horaCierre, UnidadAcademicaEntidad centroUnidad) {
        this.nombreDeCentro = nombreDeCentro;
        this.contrasenaMaestra = contrasenaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.centroUnidad = centroUnidad;
    }

    public CentroDeComputoEntidad(String nombreDeCentro, String contrasenaMaestra, Time horaApertura, Time horaCierre) {
        this.nombreDeCentro = nombreDeCentro;
        this.contrasenaMaestra = contrasenaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    

    public String getNombreDeCentro() {
        return nombreDeCentro;
    }

    public void setNombreDeCentro(String nombreDeCentro) {
        this.nombreDeCentro = nombreDeCentro;
    }

    public String getContrasenaMaestra() {
        return contrasenaMaestra;
    }

    public void setContrasenaMaestra(String contrasenaMaestra) {
        this.contrasenaMaestra = contrasenaMaestra;
    }

    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Time getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    public UnidadAcademicaEntidad getCentroUnidad() {
        return centroUnidad;
    }

    public void setCentroUnidad(UnidadAcademicaEntidad centroUnidad) {
        this.centroUnidad = centroUnidad;
    }

    public List<ComputadoraEntidad> getCentroCompuadora() {
        return centroCompuadora;
    }

    public void setCentroCompuadora(List<ComputadoraEntidad> centroCompuadora) {
        this.centroCompuadora = centroCompuadora;
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
        if (!(object instanceof CentroDeComputoEntidad)) {
            return false;
        }
        CentroDeComputoEntidad other = (CentroDeComputoEntidad) object;
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
