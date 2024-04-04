- mvn clean install
- mvn exec:java
  java -cp "target/classes/;target/dependency/*" edu.arep.search.MathService

- docker build --tag dockerparcial .
- docker images
Local
- docker run -d -p 34000:46000 --name parcialcontainer dockerparcial
  docker run -d -p 34001:46000 --name parcialcontainer2 dockerparcial
  docker run -d -p 34002:46000 --name parcialcontainer3 dockerparcial
- docker ps
- http://localhost:34000/hello

Docker Hub
- docker tag dockerparcial andreaduran/parcialarep
- docker login
- docker push andreaduran/parcialarep:latest
- docker pull andreaduran/parcialarep


EC2
- ec2-54-89-96-155.compute-1.amazonaws.com
- ssh -i dockerprimerweb.pem ec2-user@ec2-54-159-108-218.compute-1.amazonaws.com
- docker pull andreaduran/parcialarep
- docker run -d -p 38000:46000 --name parcialcontainer andreaduran/parcialarep
- http://ec2-54-159-108-218.compute-1.amazonaws.com:38000/hello

# AREP - Parcial 2

## Descripción



## Comenzando

Las siguientes instrucciones le permitirán obtener una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y prueba.

### Requisitos

- [Git](https://www.youtube.com/watch?v=4xqVv2lTo40/) - Control de versiones
- [Maven](https://www.youtube.com/watch?v=1QfiyR_PWxU) - Gestor de dependencias
- [Java 17](https://www.youtube.com/watch?v=BG2OSaxWX4E) - Lenguaje de programación

### Instalación

Para hacer una copia local del proyecto, debemos abrir nuestra terminal, dirigirnos al directorio donde estará el proyecto y usar el siguiente comando

```bash
git clone https://github.com/andreaduranvivas/AREP-Parcial2
```

Nos dirigimos al directorio creado con

```bash
cd AREP-Parcial2
```


## Ejecutando la aplicación

Para ejecutar la aplicación, primero debemos compilar el proyecto con el siguiente comando `mvn clean install`
. Esto nos permitirá limpiar las construcciones previas de otras versiones y luego compilará el proyecto.

Para ejecutar el proyecto se debe ejecutar el siguiente comando:

Abrimos una terminal y ejecutamos el siguiente comando:
```
mvn exec:java
  java -cp "target/classes/;target/dependency/*" edu.arep.search.MathService
```

Para visualizar la aplicación, escogemos algún navegador e ingresamos la URL http://localhost:34000/ en la barra de direcciones. Allí encontraremos

A continuación se presenta un video demostrando el funcionamiento de la aplicación, haciendo uso de una instancia de EC2 en AWS.
En este caso, lo único que cambiamos es la URL, ya que ya no sería localhost, sino el DNS de la IPv4 pública de nuestra VM.
Cabe recordar que se deben agregar las reglas de entrada a la instancia para poder ejecutar la aplicación, se deben abrir el puerto 4567.

[![Video Prototipo](multimedia/)](https://youtu.be/AINZ3AHpHRU)


## Pruebas

Se realizaron pruebas unitarias y pruebas de integración.
Las unitarias se pueden ejecutar al correr este comando`mvn test`

## Documentación

Para visualizar la documentación del proyecto solo debes correr el siguiente comando desde el directorio raiz del proyecto

```bash
mvn javadoc:javadoc
```

Y en la siguiente ruta encontrarás el archivo index.html en donde si lo abres desde el navegador podras ver toda la documentación

```
./target/site/apidocs
```

## Arquitectura de la aplicación

La arquitectura del prototipo consta de los siguientes componentes:


A continuación se ve el diagrama de la arquitectura

![image](multimedia/arquitectura.png)

## Autores

- **Andrea Durán** - [Usuario en GitHub](https://github.com/andreaduranvivas)

## Construido con

* Spark Framework - Java/Kotlin web framework
* Maven - Dependency Management
* Java - Programming Language
* JavaScript - Programming Language
* CSS - Stylesheet Language
* HTML - HyperText Markup Language


## Versiones

![AREP PARCIAL_2](https://img.shields.io/badge/AREP_PARCIAL_2-v1.0.0-blue)

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.
