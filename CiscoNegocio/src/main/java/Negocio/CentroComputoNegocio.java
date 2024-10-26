/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class CentroComputoNegocio {
    public Long idCentro;
    public String nombreCentro, contraseñaMaestra;
    public Time horaApertura, horaCierre;
    public Long idUnidad;
    private List<Long> idsPCs;

    public CentroComputoNegocio() {
    }

    public CentroComputoNegocio(Long idCentro, String nombreCentro, String contraseñaMaestra, Time horaApertura, Time horaCierre, Long idUnidad) {
        this.idCentro = idCentro;
        this.nombreCentro = nombreCentro;
        this.contraseñaMaestra = contraseñaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.idUnidad = idUnidad;
    }

    public CentroComputoNegocio(String nombreCentro, String contraseñaMaestra, Time horaApertura, Time horaCierre) {
        this.nombreCentro = nombreCentro;
        this.contraseñaMaestra = contraseñaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public List<Long> getIdsPCs() {
        return idsPCs;
    }

    public void setIdsPCs(List<Long> idsPCs) {
        this.idsPCs = idsPCs;
    }

    public Long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Long idCentro) {
        this.idCentro = idCentro;
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

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }
    
    
    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    @Override
    public String toString() {
        return "CentroComputoNegocio{" + "nombreCentro=" + nombreCentro + ", contrase\u00f1aMaestra=" + contraseñaMaestra + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
    
    
}
