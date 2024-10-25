/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class UnidadAcademicaNegocio {
    public String NombreUnidad;

    public UnidadAcademicaNegocio(String NombreUnidad) {
        this.NombreUnidad = NombreUnidad;
    }

    

    public String getNombreUnidad() {
        return NombreUnidad;
    }

    public void setNombreUnidad(String NombreUnidad) {
        this.NombreUnidad = NombreUnidad;
    }

    @Override
    public String toString() {
        return "AlumnoNegocio{" + "NombreUnidad=" + NombreUnidad + '}';
    }
    
}
