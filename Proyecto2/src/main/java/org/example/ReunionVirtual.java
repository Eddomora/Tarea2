package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPre, Duration duracionPre, String enlace) {
        super(fecha, horaPre, duracionPre, enlace);
        this.enlace = enlace;
        super.iniciar();
    }

    public String getEnlace(){
        return enlace;
    }

    public void finaliza(){
        super.finalizar();
        //super.calcularTiempoReal(); no se si esto se deba colocar aqui
        //super.obtenerPorcentajeAsistencias(); esto igual
    }
}
