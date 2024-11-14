package org.ti.apiincidencias.response;

import org.ti.apiincidencias.model.Usuario;

import java.util.List;

public class UsuarioResponse {
    private List<Usuario> usuario;
    public List<Usuario> getUsuario(){
        return usuario;
    }
    public void setUsuario(List<Usuario> usuario){
        this.usuario = usuario;
    }
}
