package org.ti.apiincidencias.response;



public class ReporteResponseRest extends ResponseRest{
    private ReporteResponse response= new ReporteResponse();
    public ReporteResponse getResponseReporte() {
        return response;
    }
    public void setResponseReporte(ReporteResponse response) {
        this.response = response;
    }
}
