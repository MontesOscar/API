package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;
import org.ti.apiincidencias.service.IReporteService;

@RestController
@RequestMapping("/R1")
public class ReporteRestController {
    @Autowired
    private IReporteService reporteService;
    @GetMapping("/Todos")
    public ResponseEntity<ReporteResponseRest> todosR(){
        ResponseEntity<ReporteResponseRest> response = reporteService.todosR();
        return response;
    }
    @PutMapping("/REliminar/{id}")
    public ResponseEntity<ReporteResponseRest> eliminar(@RequestBody Reporte reporte, @PathVariable  Long id){
        ResponseEntity<ReporteResponseRest> response= reporteService.eliminarR(reporte, id);
        return response;
    }
    @PutMapping("/RActualizar/{id}")
    public ResponseEntity<ReporteResponseRest> actualizar(@RequestBody Reporte reporte, @PathVariable  Long id){
        ResponseEntity<ReporteResponseRest> response= reporteService.actualizarR(reporte, id);
        return response;
    }
    @PutMapping("/RCrear")
    public ResponseEntity<ReporteResponseRest> crear(@RequestBody Reporte reporte){
        ResponseEntity<ReporteResponseRest>response= reporteService.crearR(reporte);
        return response;
    }
}
