package org.example;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nota {
    private String contenido;

    public void crearArchivo() {
        Path file = Paths.get("texto.txt");

        try {
            Files.createFile(file);
            System.out.println("Archivo creado correctamente.");
        } catch (FileAlreadyExistsException x) {
            System.err.format("El archivo '%s' ya existe.%n", file);
        } catch (IOException x) {
            System.err.format("Error al crear el archivo: %s%n", x);
        }
    }

    public void agregarContenido(String adicion) {
        this.contenido += adicion;
    }
}
