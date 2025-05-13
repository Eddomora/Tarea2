package org.example;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPre, Duration duracionPre, Instant horaIni, Instant horaFin, String sala) {
        super(fecha, horaPre, duracionPre, horaIni, horaFin, sala);
        this.sala = sala;
    }
}
