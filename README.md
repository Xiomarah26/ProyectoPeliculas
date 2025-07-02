# Proyecto CRUD - Gestión de Películas

Este proyecto fue desarrollado como parte de un desafío técnico para el cargo de Desarrollador-Soporte Junior.

## Tecnologías utilizadas

- Java (aplicación de consola)
- PostgreSQL (base de datos en Docker)
- JDBC (controlador de conexión)
- Git y GitHub

## Descripción

El sistema permite realizar operaciones de registro, consulta, actualización y eliminación sobre las siguientes entidades:

- Categorías de películas
- Títulos
- Películas (con información de disponibilidad y estado)
- Usuarios (información básica del cliente)

También se puede registrar si una película fue alquilada o vendida.

## Requisitos previos

- Tener PostgreSQL corriendo en Docker (puerto 5439)
- Base de datos `peliculasdb` creada
- Usuario: `admin`, Contraseña: `1234`
- Archivo JDBC `postgresql-42.7.7.jar` descargado y en la misma carpeta del proyecto

## Cómo ejecutar el proyecto

Desde la terminal:

1. Compilar el proyecto:

javac -cp .:postgresql-42.7.7.jar *.java

2. Ejecutar el archivo principal:

java -cp .:postgresql-42.7.7.jar Main

También puedes usar el archivo `run.sh` incluido para automatizar el proceso.

## Estructura del proyecto

- Conexion.java: Clase de conexión a la base de datos
- Categoria.java, Titulo.java, Pelicula.java, Usuario.java: Entidades del sistema
- CategoriaDAO.java, TituloDAO.java, etc.: Operaciones de base de datos (CRUD)
- MainCategoria.java, MainTitulo.java, etc.: Menús para cada módulo
- run.sh: Script que compila y ejecuta el sistema desde consola

## Autor

Xiomara Hernández 
Estudiante de Análisis y Desarrollo de Software - SENA

