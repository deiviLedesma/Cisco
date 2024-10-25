/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.Date;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class CentroComputoNegocio {
    public String nombreCentro, contraseñaMaestra;
    public Date horaApertura, horaCierre;

    public CentroComputoNegocio(String nombreCentro, String contraseñaMaestra, Date horaApertura, Date horaCierre) {
        this.nombreCentro = nombreCentro;
        this.contraseñaMaestra = contraseñaMaestra;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
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

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return "CentroComputoNegocio{" + "nombreCentro=" + nombreCentro + ", contrase\u00f1aMaestra=" + contraseñaMaestra + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
    
    
}
