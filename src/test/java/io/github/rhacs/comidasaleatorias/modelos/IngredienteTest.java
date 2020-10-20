package io.github.rhacs.comidasaleatorias.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredienteTest {

    private Ingrediente ingrediente;
    private String nombre;
    private String cantidad;

    @BeforeEach
    void setUp() throws Exception {
        nombre = "Ingrediente";
        cantidad = "100g";
        ingrediente = new Ingrediente(nombre, cantidad);
    }

    @Test
    void getNombreShouldReturnNombre() {
        assertEquals(nombre, ingrediente.getNombre());
    }

    @Test
    void getCantidadShouldReturnCantidad() {
        assertEquals(cantidad, ingrediente.getCantidad());
    }

    @Test
    void setNombreShouldChangeNombre() {
        String nombre = "Otro ingrediente";
        ingrediente.setNombre(nombre);

        assertEquals(nombre, ingrediente.getNombre());
    }

    @Test
    void SetCantidadShouldChangeCantidad() {
        String cantidad = "200g";
        ingrediente.setCantidad(cantidad);

        assertEquals(cantidad, ingrediente.getCantidad());
    }

}
