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
public class UnidadAcademicaNegocio {
    public Long idUnidad;
    public String NombreUnidad;
    private List<Long> idsCentros;

    public UnidadAcademicaNegocio() {
    }

    public UnidadAcademicaNegocio(String NombreUnidad) {
        this.NombreUnidad = NombreUnidad;
    }

    public UnidadAcademicaNegocio(Long idUnidad, String NombreUnidad) {
        this.idUnidad = idUnidad;
        this.NombreUnidad = NombreUnidad;
    }

    public List<Long> getIdsCentros() {
        return idsCentros;
    }

    public void setIdsCentros(List<Long> idsCentros) {
        this.idsCentros = idsCentros;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
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
