/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Negocio.AlumnoNegocio;
import Negocio.BloqueoNegocio;
import Negocio.CarreraNegocio;
import Negocio.CentroComputoNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.ComputadoraSoftwareNegocio;
import Negocio.ReservaNegocio;
import Negocio.SoftwareNegocio;
import Negocio.UnidadAcademicaNegocio;
import exceptions.NegocioException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AlumnoService;
import service.BloqueoService;
import service.CarreraService;
import service.CentroDeComputoService;
import service.ComputadoraService;
import service.ComputadoraSoftwareService;
import service.ReservaService;
import service.SoftwareService;
import service.UnidadAcademicaService;

/**
 *
 * @author filor
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CentroDeComputoService centro = new CentroDeComputoService();
        
        try {
            List<CentroComputoNegocio> centros = centro.listaCentrosPaginado(1, 3, "editado");
            for(CentroComputoNegocio entidad: centros){
            System.out.println(entidad);
        }
        } catch (NegocioException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
