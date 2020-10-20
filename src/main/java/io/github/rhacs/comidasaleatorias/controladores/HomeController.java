package io.github.rhacs.comidasaleatorias.controladores;

import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.rhacs.comidasaleatorias.modelos.Receta;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Constantes
    // ----------------------------------------------------------------------------------------

    /**
     * Objeto {@link Logger} que contiene los métodos de depuración
     */
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    /**
     * URL de la API que contiene la información de las recetas
     */
    private static final String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";

    // Métodos
    // ----------------------------------------------------------------------------------------

    /**
     * Efectúa una consulta a la API para obtener una {@link Receta} aleatoria
     * 
     * @return un objeto {@link Receta} que contiene la información obtenida, {@code null} en cualquier
     *         otro caso
     */
    private Receta obtenerRecetaAleatoria() {
        try {
            // Realizar petición a la API y capturar respuesta
            JsonNode jsonNode = new ObjectMapper().readTree(new URL(API_URL));
            jsonNode = jsonNode.get("meals").get(0);

            // Inicializar receta
            Receta receta = new Receta();

            // Obtener etiquetas
            JsonNode etiquetas = jsonNode.get("strTags");

            // Verificar existencia de etiquetas
            if (!etiquetas.isNull() && !etiquetas.asText().isEmpty()) {
                // Verificar que haya más de una etiqueta
                if (etiquetas.asText().contains(",")) {
                    // Separar valores
                    String[] listaEtiquetas = etiquetas.asText().split(",");

                    // Por cada etiqueta
                    for (String e : listaEtiquetas) {
                        receta.agregarEtiqueta(e);
                    }
                } else {
                    // Como es una única etiqueta, agregar directamente a la receta
                    receta.agregarEtiqueta(etiquetas.asText());
                }
            }

            // Obtener ingredientes y cantidades
            for (int i = 1; i < 21; i++) {
                String ingrediente = "strIngredient" + i;
                String cantidad = "strMeasure" + i;

                // Verificar que el ingrediente no esté vacío o sea nulo
                if (jsonNode.get(ingrediente) != null && !jsonNode.get(ingrediente).asText().isEmpty()) {
                    // Agregar ingrediente a la receta
                    receta.agregarIngrediente(jsonNode.get(ingrediente).asText(), jsonNode.get(cantidad).asText());
                } else {
                    // Salir del bucle
                    break;
                }
            }

            // Obtener valores faltantes
            receta.setNombre(jsonNode.get("strMeal").asText());
            receta.setCategoria(jsonNode.get("strCategory").asText());
            receta.setOrigen(jsonNode.get("strArea").asText());
            receta.setInstrucciones(jsonNode.get("strInstructions").asText().replaceAll("(\r\n|\n\r|\r|\n)", "<br />"));
            receta.setImagen(jsonNode.get("strMealThumb").asText());
            receta.setVideo(jsonNode.get("strYoutube").asText());
            receta.setFuente(jsonNode.get("strSource").asText());

            // Devolver objeto creado
            return receta;
        } catch (IOException e) {
            // Depurar error
            logger.error(e.getMessage());

            // Devolver nulo
            return null;
        }
    }

    // Solicitudes GET
    // ----------------------------------------------------------------------------------------

    /**
     * Muestra una receta aleatoria
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista a mostrar
     */
    @GetMapping
    public String home(Model modelo) {
        // Agregar receta al modelo
        modelo.addAttribute("receta", obtenerRecetaAleatoria());

        // Devolver nombre de la vista a mostrar
        return "receta";
    }

}
