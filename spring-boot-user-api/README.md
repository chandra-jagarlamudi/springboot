# springboot
My Spring Boot User API example

Actuator
    http://localhost:8080/application

Versioning
    http://localhost:8080/v1/person
    http://localhost:8080/v2/person
    http://localhost:8080/person/param
        params=[version=1]
    http://localhost:8080/person/param
        params=[version=2]
    http://localhost:8080/person/header
        headers=[X-API-VERSION=1]
    http://localhost:8080/person/header
        headers=[X-API-VERSION=2]
    http://localhost:8080/person/produces
        produces=[application/vnd.company.app-v1+json]
    http://localhost:8080/person/produces
        produces=[application/vnd.company.app-v2+json]

Swagger
    http://localhost:8080/swagger-ui.html
    http://localhost:8080/v2/api-docs

H2-Console
    http://localhost:8080/h2-console