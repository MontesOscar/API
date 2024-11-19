package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;
import org.ti.apiincidencias.service.IReporteService;
//ESTAS SON LAS ACCIONES QUE PODRA REALIZAR EL USUARIO ADMINISTRADOR
@RestController
@RequestMapping("/Admin")
public class ReportesRestController {
    //PODRA ACTUALIZAR EL "ESTADO" DE CUALQUIER REPORTE
    @Autowired
    private IReporteService reporteService;
    @PutMapping("/ActualizarEdo/{id}")
    public ResponseEntity<ReporteResponseRest> ActualizarEdo(@RequestBody Reporte reporte,@PathVariable Long id){
        ResponseEntity<ReporteResponseRest> response = reporteService.actualizarR(reporte, id);
        return response;
    }
    //PODRA VER TODOS LOS REPORTES QUE EXISTEN
    @GetMapping("/Rtodos")
    public ResponseEntity<ReporteResponseRest> todosR(){
        ResponseEntity<ReporteResponseRest> response = reporteService.todosR();
        return response;
    }
    //EL ADMINISTRADOR PODRA VER TODOS LOS REPORTES DEPENDIENDO DEL ESTADO DE LOS REPORTES
    @GetMapping("/Etodos")
    public ResponseEntity<ReporteResponseRest> todosE(@RequestBody Reporte reporte){
        ResponseEntity<ReporteResponseRest> response = reporteService.todosE(reporte);
        return response;
    }
    //
    //EL ADMINISTRADOR PODRA ELIMINAR CUALQUIER REPORTE
    @PutMapping("/REliminar/{id}")
    public ResponseEntity<ReporteResponseRest> eliminar(@RequestBody Reporte reporte, @PathVariable  Long id){
        ResponseEntity<ReporteResponseRest> response= reporteService.eliminarR(reporte, id);
        return response;
    }
}
