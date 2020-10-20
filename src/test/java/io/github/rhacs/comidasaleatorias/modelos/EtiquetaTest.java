package io.github.rhacs.comidasaleatorias.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EtiquetaTest {

    private Etiqueta etiqueta;
    private String nombre;

    @BeforeEach
    void setUp() throws Exception {
        nombre = "Etiqueta de prueba";
        etiqueta = new Etiqueta(nombre);
    }

    @Test
    void getNombreShouldReturnNombre() {
        assertEquals(nombre, etiqueta.getNombre());
    }

    @Test
    void setNombreShouldChangeNombre() {
        String nombre = "Otra etiqueta";
        etiqueta.setNombre(nombre);

        assertEquals(nombre, etiqueta.getNombre());
    }

}
