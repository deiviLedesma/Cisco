/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author filor
 */
public class ComputadoraSoftwareNegocio {
    private Long idPCsoftware, idPC, idSoftware;

    public ComputadoraSoftwareNegocio() {
    }

    public ComputadoraSoftwareNegocio(Long idPCsoftware, Long idPC, Long idSoftware) {
        this.idPCsoftware = idPCsoftware;
        this.idPC = idPC;
        this.idSoftware = idSoftware;
    }

    public ComputadoraSoftwareNegocio(Long idPC, Long idSoftware) {
        this.idPC = idPC;
        this.idSoftware = idSoftware;
    }

    public Long getIdPCsoftware() {
        return idPCsoftware;
    }

    public void setIdPCsoftware(Long idPCsoftware) {
        this.idPCsoftware = idPCsoftware;
    }

    public Long getIdPC() {
        return idPC;
    }

    public void setIdPC(Long idPC) {
        this.idPC = idPC;
    }

    public Long getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Long idSoftware) {
        this.idSoftware = idSoftware;
    }

    @Override
    public String toString() {
        return "ComputadoraSoftwareNegocio{" + "idPCsoftware=" + idPCsoftware + ", idPC=" + idPC + ", idSoftware=" + idSoftware + '}';
    }
    
}
