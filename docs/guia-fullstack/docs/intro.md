# Introducción

Con esta guia se pretende orientar en el proceso de crear una aplicación backend para un
proyecto específico: Un negocio de renta de autos.
La idea de este proyecto es poder hacer el backend API de un proyecto basado en Arquitectura de tres capas.
Para la capa de persistencia se utilizará una base de datos relacional: [MySQL](https://www.mysql.com/products/community/).
Para el backend Esta será la primera parte: El backend, utilizaremos el framework [Spring Boot](https://spring.io/projects/spring-boot).
Finalmente se creará un aplicación Frontend para la interfaz de usuario, con [ReactJS](https://react.dev/).
Para cada uno de los componentes de la Arquitectura del sistema, se tratará de crear un contenedor (docker). De esta forma,
será más fácil el proceso de despliegue de estos componentes.

## Organización Recomendada del proyecto

Hay muchas opciones para poder organizar el sistema. Una de las más sencillas es crear una estructura similar a la siguiente:<br/>
<br/>
--proyecto<br/>
----proyecto-db \# _Acá va la configuración de base de datos o los archivos que necesite de base de datos el proyecto completo_ .<br/>
----proyecto-be \# _En esta carpeta va nuestro proyecto de Backend_ <br/>
----proyecto-fe \# _En esta carpeta va el Frontend_ <br/>
<br/>

## Herramientas a utilizar

Las herramientas a utilizar por cada compomente del proyecto se muestran en la siguiente tabla:

| **Componente** | **Herramienta**                                              | **Descripción**                                                                                                          |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| Base de datos  | [Mysql](https://www.mysql.com/products/community/)           | Es el motor de base de datos que se utilizara.                                                                           |
|                | [MySQL Workbench](https://www.mysql.com/products/workbench/) | Herramienta que nos servirá para gestionar la base de datos (Crear objetos, crear modelos, insertar datos manuales, etc) |
| Backend        | [Spring](https://spring.io)                                  | Framework que se utilizará para el desarrollo del Backend                                                                |
|                | [Postman](https://www.postman.com/)                          | Herramienta para pruebas de API REST                                                                                     |
| Frontend       | [ReactJS](https://react.dev/)                                | Framework para el desarrollo de la interfaz de usuario                                                                   |

A nivel general utilizaremos las siguientes herramientas:

| **Herramienta**                                      | **Descripción**                                      |
| ---------------------------------------------------- | ---------------------------------------------------- |
| [Visual Studio Code](https://code.visualstudio.com/) | Para codificar los componentes de backend y frontend |
| [IntelliJ](https://www.jetbrains.com/es-es/idea/)    | Igual que la anterior                                |
| [Docker](https://www.docker.com/)                    | Lo utilizaremos para empaquetar nuestros componentes |
