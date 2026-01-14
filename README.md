# Práctica MongoDB Presidentes

Este proyecto es una API REST desarrollada en Java con el framework Spring Boot. Su principal función es gestionar una base de datos de países y sus respectivos presidentes, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre estas dos entidades. La aplicación utiliza MongoDB como base de datos NoSQL para la persistencia de datos.

## Autor

- **José Cámara Depablos**

## Características Principales

-   **API RESTful:** Expone endpoints para interactuar con los recursos de `Paises` y `Presidentes`.
-   **Base de Datos NoSQL:** Integración con MongoDB para un almacenamiento de datos flexible y escalable.
-   **Servicios y Repositorios:** Arquitectura por capas que separa la lógica de negocio (servicios) del acceso a datos (repositorios).
-   **Generación de IDs secuenciales:** Incluye una clase `Secuencia` para generar identificadores numéricos únicos para las entidades, simulando el comportamiento de secuencias de bases de datos relacionales en MongoDB.
-   **Documentación de API con OpenAPI (Swagger):** Configuración para generar automáticamente una interfaz de usuario Swagger que permite visualizar y probar los endpoints de la API de forma interactiva.

## Estructura del Proyecto

El código fuente se organiza en los siguientes paquetes principales:

-   `config`: Contiene las clases de configuración de Spring, como la conexión a MongoDB (`MongoConfig`) y la configuración de OpenAPI/Swagger (`OpenApiConfig`).
-   `controller`: Define los controladores REST (`RestPais`, `RestPresidente`) que manejan las peticiones HTTP y exponen los endpoints de la API.
-   `model`: Contiene las clases de entidad (`Pais`, `Presidente`) que mapean los documentos de las colecciones de MongoDB.
-   `repository`: Incluye las interfaces de Spring Data MongoDB (`PaisRepository`, `PresidenteRepository`) para el acceso y la manipulación de los datos.
-   `service`: Alberga la lógica de negocio (`PaisService`, `PresidenteService`) que orquesta las operaciones y se comunica con los repositorios.

## Tecnologías Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Data MongoDB**
-   **Maven** (Gestor de dependencias)
-   **MongoDB** (Base de datos)
-   **Springdoc OpenAPI (Swagger UI)** (Documentación de API)

## Requisitos Previos

-   JDK 17 o superior.
-   Maven 3.6 o superior.
-   Una instancia de MongoDB en ejecución.

## Ejecución del Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd Practica_MongoDB_Presidentes_2
    ```

2.  **Configurar la base de datos:**
    Abre el fichero `src/main/resources/application.properties` y asegúrate de que la cadena de conexión a tu base de datos MongoDB es correcta.
    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/nombre_de_tu_bd
    ```

3.  **Compilar y ejecutar la aplicación:**
    Puedes ejecutar la aplicación utilizando el plugin de Maven para Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará por defecto en el puerto `8080`.

## Uso de la API

Una vez que la aplicación está en ejecución, puedes explorar y probar los endpoints de la API a través de la interfaz de Swagger UI. Abre tu navegador y visita:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Desde esta interfaz podrás:
-   Ver todos los endpoints disponibles para `paises` y `presidentes`.
-   Enviar peticiones `GET`, `POST`, `PUT`, `DELETE`.
-   Ver los modelos de datos y los códigos de respuesta.

### Archivos de Datos

El proyecto incluye los archivos `pais.json` y `presidente.json` (y sus variantes `pais2.json`, `presidente2.json`), que contienen datos de ejemplo. Estos pueden ser utilizados para poblar la base de datos manualmente a través de un cliente de MongoDB o mediante scripts de importación.
