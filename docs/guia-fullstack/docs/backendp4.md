# Desarrollo del Backend API (II)

## Asegurar las rutas del API

Es importante proteger los endpoints de la api con el propósito de que no sean accesibles para cualquier usuario, principalmente, un usuario que no se haya autenticado en nuestra aplicación.

Hay varias formas de lograr esto. Nosotros utilizaremos un protocolo llamadno _Json Web Token (JWT)_, que es un método popular para proteger las aplicaciones web modernas. Los JWT permiten transmitir información de forma segura entre partes como un objeto JSON compacto, autónomo y firmado digitalmente.

JWT, por ser un protolo, se puede implementar en una amplia gama frameworks, de distintos tipos de lenguajes de programación.

Acá se puede encontrar más información sobre JWT: <https://jwt.io/>

Para la seguridad de un proyecto de spring (o spring boot) utilizaremos el proyecto/libreria Spring Security, del ecosistema Spring, y esto nos facilitará de manera sustancial, el trabajo que queremos hacer.

### Agregar la dependencia de Spring security al proyecto

#### Agregar las dependencia por medio de la Extensión de VSCode

Si instalamos la extensión _spring boot gradle plus_, vamos al buscador y escribimos los siguiente:

```gradle
> Add a dependency

```

Sale una ventana como se ve en la imagen:

![imagen](imagenes/imagen021.png "Imagen: Prueba de petición Delete clientes")

En la ventana que sale, escribimos "security" y seleccionamos la dependencia spring-boot-starter-security

#### Agregar la dependencia de forma manual

También podemos agregar la información de forma manual.

En el archivo build.gradle agregamos la siguiente línea en la sección de dependencias:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
```

#### Agregar la dependencia de JWT

para agregar la dependencia de JWT (una dependencia externa a Spring boot), agregamos la siguiente línea a la sección de dependencias del archivo build.gradle:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
```

### Configurar la seguridad en Spring boot

Creamos una clase de configuración de seguridad que extienda WebSecurityConfigurerAdapter. En esta clase, se configuran los parámetros de seguridad, incluidas las reglas de autenticación y autorización. Además, se excluyen los endpoint de inicio de sesión y token de la autenticación para permitir el acceso no autenticado.
