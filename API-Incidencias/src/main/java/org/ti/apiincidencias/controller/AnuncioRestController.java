package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Anuncios;
import org.ti.apiincidencias.model.Reporte;
import org.ti.apiincidencias.response.AnuncioResponseRest;
import org.ti.apiincidencias.response.ReporteResponseRest;
import org.ti.apiincidencias.service.IAnuncioService;
import org.ti.apiincidencias.service.IReporteService;

@RestController
@RequestMapping("/Admin")
public class AnuncioRestController {
    @Autowired
    private IAnuncioService anuncioService;
    //EL ADMINISTRADOR PODRA CONSULTAR TODOS LOS ANUNCIOS
    @GetMapping("/TodosA")
    public ResponseEntity<AnuncioResponseRest> Atodos(){
        ResponseEntity<AnuncioResponseRest> response = anuncioService.todosA();
        return response;
    }
    //EL ADMINISTRADOR PODRA ACTUALIZAR CUALQUIER REPORTE
    @PutMapping("/ActualizarA")
    public ResponseEntity<AnuncioResponseRest> actualizar(@RequestBody Anuncios anuncio, @PathVariable Long id) {
        ResponseEntity<AnuncioResponseRest> response = anuncioService.eliminarA(anuncio, id);
        return response;
    }
}
