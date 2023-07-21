# springboot-microservicios-mysql-eureka-zuul-mecanica

### Requisitos
- JDK (Java SE Development Kit)
  - Oracle 11 - <https://www.oracle.com/cl/java/technologies/javase/jdk11-archive-downloads.html>
  - Oracle 12 - <https://www.oracle.com/cl/java/technologies/javase/jdk12-archive-downloads.html>
  - OpenJDk 11 / 12 - <https://jdk.java.net/archive/>
- Spring Tools IDE (Eclipse)
  - Spring Tools 4 for Eclipse - <https://spring.io/tools>
- Maven (embedido en eclipse)
- Motor de Base de datos (MySql o MariaDB)
  - MySql - <https://dev.mysql.com/downloads/mysql/>
  - MariaDB - <https://mariadb.com/downloads/community/community-server/>
- Herramienta para probar API rest
  - Postman - <https://www.postman.com/downloads/>
### Eclipse Marketplace (Installed)
- Buildship Gradle Integration 3.0
- Eclipse m2e - Maven support in Eclipse IDE Latest
- Eclipse Marketplace Client 1.10.0
- EGit - Git Integration for Eclipse 6.0.0
- Java 20 Support for Eclipse 2023-03 (4.27)
- Spring Tools 4 (aka Spring Tool Suite 4) 4.19.0.RELEASE
- Wild Web Developer: HTML, CSS, JavaScript, TypeScript, Node.js, Angular, JSON, YAML (+Kubernetes), XML 0.13.1
### Preparar ambiente IDE Spring Tools 4 for Eclipse
- Descargar el proyecto springboot-microservicios-mysql-eureka-zuul-mecanica en ZIP
- Descomprimir el contenido en la carpeta workspace del IDE Spring Tools 4
- Abrir el IDE Spring Tools 4
- Acceder a File - Import Projects from File System or Archive
  - Click botón Directory
  - Buscar la carpeta workspace, seleccionar y hacer click en boton Seleccionar carpeta
    - Click en botón Deselect All
    - Seleccionar sólo las carpetas del proyecto springboot-microservicios-mysql-eureka-zuul-mecanica descomprimidas del ZIP
    - Click en botón Finish
### Cambios en proyectos (Project Explorer)
- microservicios-tecnicos
  - src/main/resources/application.properties
    - Cambiar en _**spring.datasource.password**_ la contraseña que registro para el usuario root en su instalación de MySQL 
- microservicios-vehiculos
  - src/main/resources/application.properties
    - Cambiar en _**spring.datasource.password**_ la contraseña que registro para el usuario root en su instalación de MySQL 
### Contenido
- Proyecto elaborado con Spring Tool Suite 4 compuesto por 6 microservicios:
#### commons-microservicios
```javascript
    - Java version: 12
    - Spring Booot Version: 2.7.13
    - Dependency:
      - spring-boot-starter-data-jpa
      - spring-boot-starter-web
      - spring-boot-devtools
      - spring-boot-starter-test
```
#### commons-tecnicos
```javascript
    - Java version: 12
    - Spring Booot Version: 2.7.13
    - Dependency:
      - spring-boot-starter-data-jpa
      - spring-boot-starter-test
```
#### microservicios-eureka
```javascript
    - Java version: 11
    - spring-cloud.version: 2021.0.8
    - Spring Booot Version: 2.7.13
    - Dependency:
      - jaxb-runtime
      - spring-cloud-starter-netflix-eureka-server
      - spring-boot-starter-test
    - dependencyManagement
      - spring-cloud-dependencies
    - plugins
      - spring-boot-maven-plugin
```
#### microservicios-tecnicos
```javascript
    - Java version: 12
    - spring-cloud.version: 2021.0.8
    - Spring Booot Version: 2.7.13
    - Dependency:
      - commons-tecnicos
      - commons-microservicios
      - spring-boot-starter-data-jpa
      - spring-boot-starter-web
      - spring-boot-devtools
      - mysql-connector-j
      - spring-boot-starter-test
      - spring-cloud-starter-netflix-eureka-client
    - plugins
      - spring-boot-maven-plugin
    - dependencyManagement
      - spring-cloud-dependencies
```
#### microservicios-vehiculos
```javascript
    - Java version: 12
    - spring-cloud.version: 2021.0.8
    - Spring Booot Version: 2.7.13
    - Dependency:
      - commons-tecnicos
      - commons-microservicios
      - spring-boot-starter-data-jpa
      - spring-boot-starter-web
      - spring-cloud-starter-netflix-eureka-client
      - spring-boot-devtools
      - mysql-connector-j
      - spring-boot-starter-test
    - dependencyManagement
      - spring-cloud-dependencies
    - plugins
      - spring-boot-maven-plugin
```
#### microservicios-zuul
```javascript
    - Java version: 12
    - spring-cloud.version: Hoxton.SR12
    - Spring Booot Version: 2.3.12.RELEASE
    - Dependency:
      - spring-boot-starter-web
      - spring-cloud-starter-netflix-eureka-client
      - spring-cloud-starter-netflix-zuul
      - spring-boot-devtools
      - spring-boot-starter-test
    - dependencyManagement
      - spring-cloud-dependencies
    - plugins
      - spring-boot-maven-plugin
```




 
