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
   /* @GetMapping("/Todos")
    public ResponseEntity<ReporteResponseRest> RtodosU(@RequestBody Reporte reporte){
        ResponseEntity<ReporteResponseRest> response = reporteService.TodosU(reporte);
        return response;
    }*/

    //EL USUARIO PODRA ACTUALIZAR EL REPORTE QUE EL HA CREADO
   /* @PutMapping("/RActualizar/{id}")
    public ResponseEntity<ReporteResponseRest> actualizar(@RequestBody Reporte reporte, @PathVariable Long id) {
        ResponseEntity<ReporteResponseRest> response = reporteService.actualizarR(reporte, id);
        return response;
    }*/
    //EL USUARIO PODRA CRAR LOS REPORTES
    @PutMapping("/RCrear")
    public ResponseEntity<ReporteResponseRest> crear(@RequestBody Reporte reporte){
        ResponseEntity<ReporteResponseRest>response= reporteService.crearR(reporte);
        return response;
    }
}
