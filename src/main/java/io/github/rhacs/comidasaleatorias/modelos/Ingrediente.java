package io.github.rhacs.comidasaleatorias.modelos;

/**
 * Representa un {@link Ingrediente} de una {@link Receta}
 */
public class Ingrediente {

    // Atributos
    // ----------------------------------------------------------------------------------------

    /**
     * El nombre del {@link Ingrediente}
     */
    private String nombre;

    /**
     * La cantidad del {@link Ingrediente} incluida la unidad de medida (100g, 100ml, 1 tbs, ...)
     */
    private String cantidad;

    // Constructores
    // ----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Ingrediente}
     */
    public Ingrediente() {

    }

    /**
     * Crea una nueva instancia del objeto {@link Ingrediente}
     * 
     * @param nombre   nombre
     * @param cantidad cantidad (incluida la unidad de medida)
     * @see #cantidad
     */
    public Ingrediente(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Getters
    // ----------------------------------------------------------------------------------------

    /**
     * @return nombre del {@link Ingrediente}
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return cantidad del {@link Ingrediente}
     * @see #cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    // Setters
    // ----------------------------------------------------------------------------------------

    /**
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param cantidad la cantidad a establecer
     * @see #cantidad
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    // Herencias (Object)
    // ----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("Ingrediente [nombre=%s, cantidad=%s]", nombre, cantidad);
    }

}
