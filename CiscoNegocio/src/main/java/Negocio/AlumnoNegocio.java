/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class AlumnoNegocio {
    public Long idAlumno;
    public String nombreAlumno;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String contraseña;
    public Long idCarrera;
    private List<Long> idsReservas;
    private List<Long> idsBloqueos;

    public AlumnoNegocio() {
    }
    
    public AlumnoNegocio(String nombreAlumno, String apellidoPaterno, String apellidoMaterno, String contraseña) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
    }

    public AlumnoNegocio(Long idAlumno, String nombreAlumno, String apellidoPaterno, String apellidoMaterno, String contraseña, Long idCarrera) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.idCarrera = idCarrera;
    }

    public AlumnoNegocio(Long idAlumno, String nombreAlumno, String apellidoPaterno, String apellidoMaterno, String contraseña) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
    }

    public List<Long> getIdsReservas() {
        return idsReservas;
    }

    public void setIdsReservas(List<Long> idsReservas) {
        this.idsReservas = idsReservas;
    }

    public List<Long> getIdsBloqueos() {
        return idsBloqueos;
    }

    public void setIdsBloqueos(List<Long> idsBloqueos) {
        this.idsBloqueos = idsBloqueos;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
    
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
