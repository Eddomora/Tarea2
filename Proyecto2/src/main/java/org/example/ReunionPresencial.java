package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPre, Duration duracionPre, String sala) {
        super(fecha, horaPre, duracionPre, sala);
        this.sala = sala;
        super.iniciar();
    }

    public String getSala(){
        return sala;
    }

    public void finaliza(){
        super.finalizar();
        //super.calcularTiempoReal(); no se si esto se deba colocar aqui
    }
}
