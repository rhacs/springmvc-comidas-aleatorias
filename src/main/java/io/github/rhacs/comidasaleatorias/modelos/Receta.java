package io.github.rhacs.comidasaleatorias.modelos;

import java.util.HashSet;
import java.util.Set;

public class Receta {

    // Atributos
    // ----------------------------------------------------------------------------------------

    /**
     * Nombre de la {@link Receta}
     */
    private String nombre;

    /**
     * Categoría de la {@link Receta}
     */
    private String categoría;

    /**
     * País de origen de la {@link Receta}
     */
    private String origen;

    /**
     * Instrucciones de preparación de la {@link Receta}
     */
    private String instrucciones;

    /**
     * Imagen de la {@link Receta}
     */
    private String imagen;

    /**
     * Video de preparación de la {@link Receta}
     */
    private String video;

    /**
     * De dónde se obtuvo la {@link Receta}
     */
    private String fuente;

    /**
     * Listado de {@link Etiqueta}s de la {@link Receta}
     */
    private Set<Etiqueta> etiquetas;

    /**
     * Listado de {@link Ingrediente}s de la {@link Receta}
     */
    private Set<Ingrediente> ingredientes;

    // Constructores
    // ----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Receta}
     */
    public Receta() {
        this.etiquetas = new HashSet<>();
        this.ingredientes = new HashSet<>();
    }

    // Métodos
    // ----------------------------------------------------------------------------------------

    /**
     * Agrega una nueva {@link Etiqueta} al listado
     * 
     * @param nombre nombre de la {@link Etiqueta}
     */
    public void agregarEtiqueta(String nombre) {
        etiquetas.add(new Etiqueta(nombre));
    }

    /**
     * Agrega un nuevo {@link Ingrediente} al listado
     * 
     * @param nombre   nombre del {@link Ingrediente}
     * @param cantidad cantidad, incluida la unidad de medida
     * @see Ingrediente#cantidad
     */
    public void agregarIngrediente(String nombre, String cantidad) {
        ingredientes.add(new Ingrediente(nombre, cantidad));
    }

    // Getters
    // ----------------------------------------------------------------------------------------

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la categoría
     */
    public String getCategoría() {
        return categoría;
    }

    /**
     * @return el país de origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @return las intrucciones de preparación
     */
    public String getInstrucciones() {
        return instrucciones;
    }

    /**
     * @return la imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @return el video de preparación
     */
    public String getVideo() {
        return video;
    }

    /**
     * @return la fuente de dónde se obtuvo la {@link Receta}
     */
    public String getFuente() {
        return fuente;
    }

    /**
     * @return el listado de {@link Etiqueta}s
     */
    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    /**
     * @return el listado de {@link Ingrediente}s
     */
    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
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
     * @param categoría la categoría a establecer
     */
    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    /**
     * @param origen el país de origen a establecer
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @param instrucciones las instrucciones de preparación a establecer
     */
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    /**
     * @param imagen la imagen a establecer
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @param video el video a establecer
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * @param fuente la fuente a establecer
     */
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    /**
     * @param etiquetas el listado de {@link Etiqueta}s a establecer
     */
    public void setEtiquetas(Set<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @param ingredientes el listado de {@link Ingrediente}s a establecer
     */
    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    // Herencias (Object)
    // ----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format(
                "Receta [nombre=%s, categoría=%s, origen=%s, instrucciones=%s, imagen=%s, video=%s, fuente=%s, etiquetas=%s, ingredientes=%s]",
                nombre, categoría, origen, instrucciones, imagen, video, fuente, etiquetas, ingredientes);
    }

}
