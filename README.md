# Selenium Grid Cloud Base Code

Proyecto de automatización de pruebas con Selenium y TestNG.

## Iniciando

Siga las siguientes instrucciones para iniciar el desarrollo de este proyecto.

### Pre-requisitos

* Instalar Java JDK11 o mayor.
* Instalar Maven última versión.
* Mantener actualizado los drivers de los navegadores que se encuentran en la carpeta `src/main/resources` para ejecuciones en local. 

### Ejecución de los tests

Para ejecutar los tests utilizar el siguiente comando:
```json
mvn clean test -DsuiteXmlFile="LoginTestsLocal.xml"
```
Los valores que pueden ir en el parámetro `-DsuiteXmlFile` son `LoginTestsLocal.xml`, `LoginTestsGrid.xml` y `LoginTestsSauce.xml`.

El resultado de los tests se va guardar en la carpeta `target/surefire-reports`.