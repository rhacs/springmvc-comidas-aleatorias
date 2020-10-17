package io.github.rhacs.comidasaleatorias.modelos;

/**
 * Representa una {@link Etiqueta} (tag, categoría, ...) de la {@link Receta}
 */
public class Etiqueta {

    // Atributos
    // ----------------------------------------------------------------------------------------

    /**
     * Nombre de la {@link Etiqueta}
     */
    private String nombre;

    // Constructores
    // ----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Etiqueta}
     */
    public Etiqueta() {

    }

    /**
     * Crea una nueva instancia del objeto {@link Etiqueta}
     * 
     * @param nombre nombre de la etiqueta
     */
    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    // ----------------------------------------------------------------------------------------

    /**
     * @return el nombre de la {@link Etiqueta}
     */
    public String getNombre() {
        return nombre;
    }

    // Setters
    // ----------------------------------------------------------------------------------------

    /**
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Herencias (Object)
    // ----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("Etiqueta [nombre=%s]", nombre);
    }

}
