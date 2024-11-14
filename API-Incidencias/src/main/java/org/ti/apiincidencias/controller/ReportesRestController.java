package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;
import org.ti.apiincidencias.service.IReporteService;

@RestController
@RequestMapping("/Admin")
public class ReportesRestController {
    @Autowired
    private IReporteService reporteService;
    @PutMapping("/ActualizarEdo")
    public ResponseEntity<ReporteResponseRest> ActualizarEdo(Reporte reporte, Long id){
        ResponseEntity<ReporteResponseRest> response = reporteService.RactualizarEdo(reporte, id);
        return response;
    }
    @GetMapping("/Rtodos")
    public ResponseEntity<ReporteResponseRest> todos(){
        ResponseEntity<ReporteResponseRest> response = reporteService.todosR();
        return response;
    }
}
