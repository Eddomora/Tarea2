package org.example.Reunion;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPre, Duration duracionPre, Instant horaIni, Instant horaFin, String enlace) {
        super(fecha, horaPre, duracionPre, horaIni, horaFin, enlace);
        this.enlace = enlace;
    }
}
