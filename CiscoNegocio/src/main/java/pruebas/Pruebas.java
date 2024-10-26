/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Negocio.CarreraNegocio;
import Negocio.UnidadAcademicaNegocio;
import exceptions.NegocioException;
import service.CarreraService;
import service.UnidadAcademicaService;

/**
 *
 * @author filor
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NegocioException {
        UnidadAcademicaService unidadService = new UnidadAcademicaService();
        UnidadAcademicaNegocio unidadNegocio = new UnidadAcademicaNegocio("Unidad1");
        UnidadAcademicaNegocio unidadNegocio2 = new UnidadAcademicaNegocio("Unidad2");
        UnidadAcademicaNegocio unidadNegocio3 = new UnidadAcademicaNegocio("Unidad3");
        
        unidadService.agregarUnidad(unidadNegocio);
        unidadService.agregarUnidad(unidadNegocio2);
        unidadService.agregarUnidad(unidadNegocio3);
        
    }
    
}
