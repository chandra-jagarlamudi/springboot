## About
Demo project to build a Spring Boot REST API with unit tests, security with OAuth2, OAuth testing with Wiremock and Stress testing 
with JMeter

## Runnning this project
```
mvn spring-boot:run
```

## Security enabled with OAuth2
Get Access and Refresh token
```
curl -X POST --user 'restapi:s3cr3t' -d 'grant_type=password&username=chandra@ragas.com&password=password' http://localhost:8080/restapi/oauth/token

Use the Access token with below URL to get all people from the API:
curl -i -H "Accept: application/json" -H "Authorization: Bearer fb2dae5b-acf7-4ae4-9df4-38bd1b5a54ae" -X GET http://localhost:8080/restapi/people
```

Posting new person to the API:
```
curl -H "Content-Type: application/json" -H "Authorization: Bearer fb2dae5b-acf7-4ae4-9df4-38bd1b5a54ae" -X POST -d '{"name":"Mark","age":54}' http://localhost:8080/restapi/people
```

Delete person based on ID:
```
curl -H "Authorization: Bearer fb2dae5b-acf7-4ae4-9df4-38bd1b5a54ae" -X DELETE http://localhost:8080/restapi/people/10003
```

Getting all party information with people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer fb2dae5b-acf7-4ae4-9df4-38bd1b5a54ae" -X GET http://localhost:8080/restapi/parties
```