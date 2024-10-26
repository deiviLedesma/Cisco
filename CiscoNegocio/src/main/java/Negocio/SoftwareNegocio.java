/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;

/**
 *
 * @author filor
 */
public class SoftwareNegocio {
    private Long idSoftware;
    private String nombre;
    private List<Long> idsPCs;

    public SoftwareNegocio() {
    }

    public SoftwareNegocio(String nombre) {
        this.nombre = nombre;
    }

    public SoftwareNegocio(Long idSoftware, String nombre) {
        this.idSoftware = idSoftware;
        this.nombre = nombre;
    }

    public List<Long> getIdsPCs() {
        return idsPCs;
    }

    public void setIdsPCs(List<Long> idsPCs) {
        this.idsPCs = idsPCs;
    }

    public Long getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Long idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "SoftwareNegocio{" + "idSoftware=" + idSoftware + ", nombre=" + nombre + '}';
    }
    
}
