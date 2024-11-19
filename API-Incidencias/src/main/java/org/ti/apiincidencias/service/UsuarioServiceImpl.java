package org.ti.apiincidencias.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ti.apiincidencias.model.Usuario;
import org.ti.apiincidencias.model.dao.UsuarioDao;
import org.ti.apiincidencias.response.UsuarioResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Autowired
    private UsuarioDao usuarioDao;

    //ADMINISTRADOR--SE CONSULTA TODOS LOS USUARIOS EXISTENTES
    @Transactional(readOnly = true)
    public ResponseEntity<UsuarioResponseRest> todos() {
        UsuarioResponseRest response = new UsuarioResponseRest();
        try {
            List<Usuario> usuarios = (List<Usuario>) usuarioDao.findAll();
            log.info("INICIO DEL METODO PARA BUSCAR A TODOS LOS USUARIOS");
            response.getResponseUsuario().setUsuario(usuarios);
            response.setMetadata("CORRECTO", "1", "SE ENVIO RESPUESTA");
        } catch (Exception e) {
            log.info("ERROR AL BUSCAR LOS USUARIOS");
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //ADMINISTRADOR--ELIMINA CUALQUIER USUARIO
    @Override
    @Transactional
    public ResponseEntity<UsuarioResponseRest> eliminarU(Usuario usuario, Long id) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        List<Usuario> list = new ArrayList<>();

        try {
            Optional<Usuario> buscado = usuarioDao.findById(id);
            if (buscado.isPresent()) {
                buscado.get().setEstado(usuario.getEstado());
                Usuario actualizado = usuarioDao.save(buscado.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseUsuario().setUsuario(list);
                    response.setMetadata("CORRECTO", "1", "SE ELIMINO LOGICAMENTE");
                } else {
                    response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                    return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                log.info("USUARIO NO ENCONTRADO");
                response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR DE ELIMINACION");
            log.info("ERROR AL ELIMINAR EL USUARIO");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //ADMINISTRADOR--PUEDE CREAR CUALQUIER USUARIO
    @Override
    @Transactional
    public ResponseEntity<UsuarioResponseRest> crearU(Usuario usuario) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        List<Usuario> list = new ArrayList<>();
        try {
            log.info("INICIO DEL METODO PARA CRERA UN USUARIO NUEVO");
            Usuario guardar = usuarioDao.save(usuario);
            if (guardar != null) {
                log.info("SE VALIDA QUE NO ESTA VACIO");
                list.add(guardar);
                response.getResponseUsuario().setUsuario(list);
                response.setMetadata("BIEN", "1", "USUARIO CREADO");
            } else {
                log.info("SE VALIDA QUE ESTA VACIO");
                response.setMetadata("ERROR", "-1", "ERROR AL CREAR EL USUARIO");
                return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            log.info("ERROR CREAR USUARIO");
            response.setMetadata("ERROR", "-1", "ERROR DE RESPUESTA");
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
    }

    //USUARIO--EL USUARIO PODRA ACTUALIZAR SU PROPIO PERFIL(DATOS)
    @Override
    @Transactional
    public ResponseEntity<UsuarioResponseRest> actualizarU(Usuario usuario, Long id) {
        UsuarioResponseRest response = new UsuarioResponseRest();
        List<Usuario> list = new ArrayList<>();
        try {
            Optional<Usuario> Buscada = usuarioDao.findById(id);
            if (Buscada.isPresent()) {
                Buscada.get().setEstado(usuario.getEstado());
                Usuario actualizado = usuarioDao.save(Buscada.get());
                if (actualizado != null) {
                    list.add(actualizado);
                    response.getResponseUsuario().setUsuario(list);
                    response.setMetadata("BIEN", "1", "ESTADO DEL USUARIO ACTUALIZADO");
                } else {
                    response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL ESTADO DEL USUARIO");
                    return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);
                }
            } else {
                log.info("NO EXISTE EL USUARIO");
                response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL ESTADO DEL USUARIO");
                return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("ERROR", "-1", "ERROR AL ACTUALIZAR EL ESTADO DEL USUARIO");
            log.info("ERROR AL ACTUALIZAR");
            return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
