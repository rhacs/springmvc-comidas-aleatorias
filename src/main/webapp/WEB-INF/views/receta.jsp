<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <!-- Metadatos -->
    <head>
        <!-- Codificación de caracteres -->
        <meta charset="UTF-8">

        <!-- Configuración de ancho y escala inicial para los dispositivos -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Título -->
        <title>Comidas Aleatorias</title>

        <!-- Hojas de Estilo -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css"
            integrity="sha512-oc9+XSs1H243/FRN9Rw62Fn8EtxjEYWHXRvjS43YtueEewbS6ObfXcJNyohjHqVKFPoXXUxwc+q1K7Dee6vv9g=="
            crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.css"
            integrity="sha512-H9jrZiiopUdsLpg94A333EfumgUBpO9MdbxStdeITo+KEIMaNfHNvwyjjDJb+ERPaRS6DpyRlKbvPUasNItRyw=="
            crossorigin="anonymous" />
    </head>
    <!-- /Metadatos -->

    <!-- Cuerpo -->
    <body>
        <!-- Barra de navegación -->
        <nav class="navbar navbar-expand-md navbar-light bg-light shadow-sm">
            <!-- Contenedor -->
            <div class="container">
                <!-- "Logotipo" -->
                <a class="navbar-brand" href="./">Comidas Aleatorias</a>

                <!-- Botón de despliegue de menú -->
	            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" aria-controls="menu" aria-expanded="false">
	                <span class="navbar-toggler-icon"></span>
	            </button>

	            <!-- Menú desplegable -->
	            <div class="collapse navbar-collapse" id="menu">
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item active">
	                       <button class="btn btn-primary" type="button" id="otra">Nueva Receta</button>
	                    </li>
	                </ul>
	            </div>
	            <!-- /Menú desplegable -->
            </div>
            <!-- /Contenedor -->
        </nav>
        <!-- /Barra de navegación -->

        <!-- Contenido principal -->
        <main class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 pt-5">
                        <div class="card">
                            <!-- Imagen de la Receta -->
                            <img src="${receta.imagen}" class="card-img-top" alt="${receta.nombre}">

                            <div class="card-body">
                                <h5 class="card-title">${receta.nombre}</h5>

                                <p class="card-text">
                                    <strong>Categoría</strong>: ${receta.categoria} <br />
                                    <strong>Origen</strong>: ${receta.origen} <br />
                                </p>

                                <core:if test="${receta.etiquetas.size() > 0}">
	                                <p class="card-text">
	                                    <core:forEach items="${receta.etiquetas}" var="etiqueta">
	                                        <span class="badge badge-pill badge-info">${etiqueta.nombre}</span>
	                                    </core:forEach>
	                                </p>
                                </core:if>

                                <p class="card-text">
                                    <a class="btn btn-primary w-100" data-fancybox href="${receta.video}">Ver Video</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-8 pt-5">
                        <h4 class="border-bottom pb-2">Ingredientes</h4>
                        <p>
                            <ul class="list-group">
                                <core:forEach items="${receta.ingredientes}" var="ingrediente">
                                    <li class="list-group-item">${ingrediente.nombre} ~ ${ingrediente.cantidad}</li>
                                </core:forEach>
                            </ul>
                        </p>

                        <h4 class="border-bottom mt-4 pb-2">Preparación</h4>
                        <p>${receta.instrucciones}</p>
                    </div>
                </div>
            </div>
        </main>
        <!-- /Contenido principal -->

        <!-- Dependencias JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
            integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"
            integrity="sha512-ubuT8Z88WxezgSqf3RLuNi5lmjstiJcyezx34yIU2gAHonIi27Na7atqzUZCOoY4CExaoFumzOsFQ2Ch+I/HCw=="
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.min.js"
            integrity="sha512-8qmis31OQi6hIRgvkht0s6mCOittjMa9GMqtK9hes5iEQBQE/Ca6yGE5FsW36vyipGoWQswBj/QBm2JR086Rkw=="
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js"
            integrity="sha512-uURl+ZXMBrF4AwGaWmEetzrd+J5/8NRkWAvJx5sbPSSuOb0bZLqf+tOzniObO00BjHa/dD7gub9oCGMLPQHtQA=="
            crossorigin="anonymous"></script>
        <!-- /Dependencias JavaScript -->

        <script type="text/javascript">
            // Esperar a que termine de cargar la página
            $(function() {
            	// Asignar acción al botón "Nueva Receta"
            	$('#menu').on('click', function() {
            		// Recargar la página desde el servidor
            		location.reload(true);
            	});
            });
        </script>
    </body>
    <!-- /Cuerpo -->
</html>
