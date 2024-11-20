package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.ReporteResponseRest;
import org.ti.apiincidencias.service.IReporteService;
//ESTAS SON LAS ACCIONES QUE PODRA REALIZAR EL USUARIO NORMAL
@RestController
@RequestMapping("/Usuario")
public class ReporteRestController {
    @Autowired
    private IReporteService reporteService;
    //EL USUARIO PODRA VER TODOS LOS REPORTES QUE EL HA CREADO
    @GetMapping("/Todos/{id}")
    public ResponseEntity<ReporteResponseRest> RtodosU(@PathVariable Long id){
        ResponseEntity<ReporteResponseRest> response = reporteService.TodosU(id);
        return response;
    }

    //EL USUARIO PODRA ACTUALIZAR EL REPORTE QUE EL HA CREADO
    @PutMapping("/RActualizar/{idR}/{idU}")
    public ResponseEntity<ReporteResponseRest> actualizar(
            @RequestBody Reporte reporte, @PathVariable Long idR, @PathVariable Long idU) {
        ResponseEntity<ReporteResponseRest> response = reporteService.UactualizarR(reporte, idR, idU);
        return response;
    }
    //EL USUARIO PODRA ACTUALIZAR EL REPORTE QUE EL HA CREADO
    @PutMapping("/REliminar/{idR}/{idU}")
    public ResponseEntity<ReporteResponseRest> eliminar(@RequestBody Reporte reporte, @PathVariable Long idR, @PathVariable Long idU) {
        ResponseEntity<ReporteResponseRest> response = reporteService.UeliminarR(reporte, idR, idU);
        return response;
    }

    //EL USUARIO PODRA CRAR LOS REPORTES
    @PutMapping("/RCrear")
    public ResponseEntity<ReporteResponseRest> crear(@RequestBody Reporte reporte){
        ResponseEntity<ReporteResponseRest>response= reporteService.crearR(reporte);
        return response;
    }
}
