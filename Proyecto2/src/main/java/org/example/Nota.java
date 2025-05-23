package org.example;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Clase para manejar la creación y escritura de archivo de texto.
 */
public class Nota {
    private String contenido = "";

    public void crearArchivo() {
        Path file = Paths.get("Acta.txt");
        // Verifica si no hay errores al crear el archivo.
        try {
            Files.createFile(file);
            System.out.println("Archivo creado correctamente.");
        } catch (FileAlreadyExistsException x) {
            System.err.format("El archivo '%s' ya existe.%n", file);
        } catch (IOException x) {
            System.err.format("Error al crear el archivo: %s%n", x);
        }
    }
    /**
     * Agrega texto al contenido del archivo.
     * @param adicion Texto a agregar con un salto de linea
     */
    public void agregarContenido(String adicion) {
        this.contenido += adicion + "\n";
    }
    /**
     * Escribe el contenido acumulado en el archivo.
     * @throws RuntimeException si ocurre un error de IO
     */
    public void generarInforme() {
        Path file = Paths.get("Acta.txt");

        try {
            Files.writeString(file, contenido);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Contenido escrito correctamente.");
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String str){
        contenido = str;
    }
}
