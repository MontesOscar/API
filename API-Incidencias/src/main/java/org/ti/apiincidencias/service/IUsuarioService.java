package org.ti.apiincidencias.service;

import org.springframework.http.ResponseEntity;
import org.ti.apiincidencias.model.Usuario;
import org.ti.apiincidencias.response.UsuarioResponseRest;

public interface IUsuarioService {
    public ResponseEntity<UsuarioResponseRest> todos();
    public ResponseEntity<UsuarioResponseRest> eliminarU(Usuario usuario,Long id);
    public ResponseEntity<UsuarioResponseRest> crearU(Usuario usuario);
    public ResponseEntity<UsuarioResponseRest> actualizarU(Usuario usuario, Long id);




}
