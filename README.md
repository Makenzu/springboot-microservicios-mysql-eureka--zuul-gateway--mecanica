# springboot-microservicios-mysql-eureka-zuul-mecanica

### Proyecto elaborado con Spring Tool Suite 4
- Esta compuesto por 6 microservicios:
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




 
