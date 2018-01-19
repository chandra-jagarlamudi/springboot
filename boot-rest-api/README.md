## About
Demo project to build a Spring Boot REST API with unit tests, security with OAuth2, OAuth testing with Wiremock and Stress testing 
with JMeter

## Runnning this project
```
mvn spring-boot:run
```

## Example commands

Getting all people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/restapi/people
```

Posting new person to the API:
```
curl -H "Content-Type: application/json" -X POST -d '{"name":"Mark","age":54}' http://localhost:8080/restapi/people
```

Delete person based on ID:
```
curl -X DELETE http://localhost:8080/restapi/people/10003
```

Getting all party information with people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/restapi/parties
```

