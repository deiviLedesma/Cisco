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
public class CarreraNegocio {
    public Long idCarrera;
    public String nombreCarrera;
    public int tiempoLimite;
    private List<Long> idsAlumnos;

    public CarreraNegocio() {
    }
    
    public CarreraNegocio(String nombreCarrera, int tiempoLimite) {
        this.nombreCarrera = nombreCarrera;
        this.tiempoLimite = tiempoLimite;
    }

    public CarreraNegocio(Long idCarrera, String nombreCarrera, int tiempoLimite) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.tiempoLimite = tiempoLimite;
    }

    public List<Long> getIdsAlumnos() {
        return idsAlumnos;
    }

    public void setIdsAlumnos(List<Long> idsAlumnos) {
        this.idsAlumnos = idsAlumnos;
    }

    
    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    @Override
    public String toString() {
        return "CarreraNegocio{" + "nombreCarrera=" + nombreCarrera + ", tiempoLimite=" + tiempoLimite + '}';
    }
    
}
