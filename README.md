## Ejecutando los tests
Para ejecutar los tests utilizar el siguiente comando:
```json
mvn clean test -DsuiteXmlFile="LoginTestsLocal.xml"
```
Los valores que pueden ir en el parámetro `-DsuiteXmlFile` son `LoginTestsLocal.xml`, `LoginTestsGrid.xml` y `LoginTestsSauce.xml`.

El resultado de los tests se va guardar en la carpeta `target/surefire-reports`.