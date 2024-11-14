package org.ti.apiincidencias.response;

import org.ti.apiincidencias.model.Reporte;

import java.util.List;

public class ReporteResponse {
    private List<Reporte> reporte;
    public List<Reporte> getReporte() {
        return reporte;
    }
    public void setReporte(List<Reporte> reporte) {
        this.reporte = reporte;
    }
}
