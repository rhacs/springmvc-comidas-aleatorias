package io.github.rhacs.comidasaleatorias.controladores;

import static org.hamcrest.CoreMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.github.rhacs.comidasaleatorias.modelos.Receta;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
class HomeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext wac) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void homeShouldReturnViewHome() throws Exception {
        mockMvc
                // Realizar petición GET a la página
                .perform(get("/"))
                // Esperar que el estado de la respuesta sea HttpStatus.OK (200)
                .andExpect(status().isOk())
                // Esperar que la vista devuelta por el controlador se llame "receta"
                .andExpect(view().name("receta"))
                // Esperar que el modelo contenga un atributo "receta"
                .andExpect(model().attributeExists("receta"))
                // Esperar que el atributo "receta" del modelo sea un objeto Receta
                .andExpect(model().attribute("receta", isA(Receta.class)))
                // Imprimir proceso por consola
                .andDo(print());
    }

}
