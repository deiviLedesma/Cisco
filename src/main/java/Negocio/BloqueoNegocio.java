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
public class BloqueoNegocio {
    public String motivo;
    public Date fechaDeBloqueo;

    public BloqueoNegocio(String motivo, Date fechaDeBloqueo) {
        this.motivo = motivo;
        this.fechaDeBloqueo = fechaDeBloqueo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaDeBloqueo() {
        return fechaDeBloqueo;
    }

    public void setFechaDeBloqueo(Date fechaDeBloqueo) {
        this.fechaDeBloqueo = fechaDeBloqueo;
    }

    @Override
    public String toString() {
        return "BloqueoNegocio{" + "motivo=" + motivo + ", fechaDeBloqueo=" + fechaDeBloqueo + '}';
    }
    
    
}
