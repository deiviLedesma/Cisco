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
public class ComputadoraNegocio {
    public Long idCompu;
    public int numeroMaquina;
    public String estatus, ip, alumno;
    public Long idCentro;
    private List<Long> idsReservas;
    private List<Long> idsSoftwares;

    public ComputadoraNegocio() {
    }

    public ComputadoraNegocio(Long idCompu, int numeroMaquina, String estatus, String ip, String alumno, Long idCentro) {
        this.idCompu = idCompu;
        this.numeroMaquina = numeroMaquina;
        this.estatus = estatus;
        this.ip = ip;
        this.alumno = alumno;
        this.idCentro = idCentro;
    }

    public ComputadoraNegocio(int numeroMaquina, String estatus, String ip, String alumno) {
        this.numeroMaquina = numeroMaquina;
        this.estatus = estatus;
        this.ip = ip;
        this.alumno = alumno;
    }

    
    public ComputadoraNegocio(int numeroMaquina, String estatus, String ip) {
        this.numeroMaquina = numeroMaquina;
        this.estatus = estatus;
        this.ip = ip;
    }

    public Long getIdCompu() {
        return idCompu;
    }

    public void setIdCompu(Long idCompu) {
        this.idCompu = idCompu;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Long idCentro) {
        this.idCentro = idCentro;
    }

    public int getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(int numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ComputadoraNegocio{" + "numeroMaquina=" + numeroMaquina + ", estatus=" + estatus + ", ip=" + ip + '}';
    }
    
}
