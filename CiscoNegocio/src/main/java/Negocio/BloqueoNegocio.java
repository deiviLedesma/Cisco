/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class BloqueoNegocio {
    public Long idBloqueo;
    public String motivo;
    public LocalDateTime fechaDeBloqueo;
    public Long idAlumno;

    public BloqueoNegocio(Long idBloqueo, String motivo, LocalDateTime fechaDeBloqueo, Long idAlumno) {
        this.idBloqueo = idBloqueo;
        this.motivo = motivo;
        this.fechaDeBloqueo = fechaDeBloqueo;
        this.idAlumno = idAlumno;
    }

    public BloqueoNegocio(String motivo, LocalDateTime fechaDeBloqueo) {
        this.motivo = motivo;
        this.fechaDeBloqueo = fechaDeBloqueo;
    }

    public BloqueoNegocio() {
    }

    public Long getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(Long idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public LocalDateTime getFechaDeBloqueo() {
        return fechaDeBloqueo;
    }

    public void setFechaDeBloqueo(LocalDateTime fechaDeBloqueo) {
        this.fechaDeBloqueo = fechaDeBloqueo;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    @Override
    public String toString() {
        return "BloqueoNegocio{" + "motivo=" + motivo + ", fechaDeBloqueo=" + fechaDeBloqueo + '}';
    }
    
    
}
