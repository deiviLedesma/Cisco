/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class CarreraNegocio {
    public String nombreCarrera;
    public int tiempoLimite;

    public CarreraNegocio(String nombreCarrera, int tiempoLimite) {
        this.nombreCarrera = nombreCarrera;
        this.tiempoLimite = tiempoLimite;
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
