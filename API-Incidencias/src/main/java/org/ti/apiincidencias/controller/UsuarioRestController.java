package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Usuario;
import org.ti.apiincidencias.response.UsuarioResponseRest;
import org.ti.apiincidencias.service.IUsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioRestController{
    @Autowired
    private IUsuarioService service;
    //LOS USUARIOS PODRA ACTUALIZAR SUS DATOS LOS USUARIOS
    @PutMapping("/UActualizar/{id}")
    public ResponseEntity<UsuarioResponseRest> actualizar(@RequestBody Usuario usuario, @PathVariable  Long id){
        ResponseEntity<UsuarioResponseRest>response= service.actualizarU(usuario,id);
        return response;
    }



}
