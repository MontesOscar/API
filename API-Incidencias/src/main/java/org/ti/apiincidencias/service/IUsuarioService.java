package org.ti.apiincidencias.service;

import org.springframework.http.ResponseEntity;
import org.ti.apiincidencias.model.Usuario;
import org.ti.apiincidencias.response.UsuarioResponseRest;

public interface IUsuarioService {
    //ADMINISTRADOR--CONSULTA TODOS LOS USUARIOS
    public ResponseEntity<UsuarioResponseRest> todos();
    //ADMINISTRADOR--ELIMINAR CUALQUIER USUARIO
    public ResponseEntity<UsuarioResponseRest> eliminarU(Usuario usuario,Long id);
    //ADMINISTRADOR--CREA A LOS USUARIOS
    public ResponseEntity<UsuarioResponseRest> crearU(Usuario usuario);
    //USUARIO--EL USUARIO PODRA ACTUALIZAR SU PROPIO PERFIL(DATOS)
    //FALTAN DETALLES
    public ResponseEntity<UsuarioResponseRest> UActualizar(Usuario usuario, Long id);
    //INICIO DE SESION
    public ResponseEntity<UsuarioResponseRest> inicioSesion(Usuario usuario);




}
