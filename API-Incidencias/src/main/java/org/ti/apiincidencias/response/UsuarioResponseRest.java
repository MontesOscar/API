package org.ti.apiincidencias.response;



public class UsuarioResponseRest extends ResponseRest{
 private UsuarioResponse response = new UsuarioResponse();
 public UsuarioResponse getResponseUsuario() {
     return response;
 }
 public void setResponseUsuario(UsuarioResponse response) {
     this.response = response;
 }
}
