package org.ti.apiincidencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ti.apiincidencias.model.Usuario;
import org.ti.apiincidencias.response.UsuarioResponseRest;
import org.ti.apiincidencias.service.IUsuarioService;

@RestController
@RequestMapping("/Admin")
public class UsuariosRestController{
    @Autowired
    private IUsuarioService service;
    //EL ADMINISTRADOR PODRA VER TODOS LOS USUARIOS
    @GetMapping("/Utodos")
    public ResponseEntity<UsuarioResponseRest> todos(){
        ResponseEntity<UsuarioResponseRest> response = service.todos();
        return response;
    }
    //EL ADMINISTRADOR PODRA ELIMINAR CUALQUIER USUARIO(DE MANERA LOGICA)
    @PutMapping("/UEliminar/{id}")
    public ResponseEntity<UsuarioResponseRest> eliminar(@RequestBody Usuario usuario, @PathVariable  Long id){
        ResponseEntity<UsuarioResponseRest>response= service.eliminarU(usuario, id);
        return response;
    }
    //EL ADMINISTRADOR PODRA CREAR CUALQUIER USUARIO
    @PostMapping("/UCrear")
    public ResponseEntity<UsuarioResponseRest> crear(@RequestBody Usuario usuario){
        ResponseEntity<UsuarioResponseRest>response= service.crearU(usuario);
        return response;
    }



}
