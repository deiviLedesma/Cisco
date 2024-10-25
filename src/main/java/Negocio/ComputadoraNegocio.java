/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Edgar Artuto Acevedo Acosta
 */
public class ComputadoraNegocio {
    public int numeroMaquina;
    public String estatus, ip;

    public ComputadoraNegocio(int numeroMaquina, String estatus, String ip) {
        this.numeroMaquina = numeroMaquina;
        this.estatus = estatus;
        this.ip = ip;
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
