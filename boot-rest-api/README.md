## About
Demo project to build a Spring Boot REST API with unit tests, security with OAuth2, OAuth testing with Wiremock and Stress testing 
with JMeter

## Runnning this project
```
mvn spring-boot:run
```

## Example commands
See the top level services
curl http://localhost:8080/restapi/

  "_links" : {
    "people" : {
      "href" : "http://localhost:8080/restapi/people{?page,size,sort}",
      "templated" : true
    },
    "party" : {
      "href" : "http://localhost:8080/restapi/parties{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/restapi/profile"
    }
  }
}
```

Getting all people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/restapi/people

Find all the custom queries
curl http://localhost:8080/restapi/people/search
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/restapi/people/search/findByName?name=Chandra
```

Posting new person through the API:
```
curl -H "Content-Type: application/json" -X POST -d '{"name":"Mark","age":54}' http://localhost:8080/restapi/people
	-i ensures you can see the response message including the headers. The URI of the newly created Person is shown
	-X POST signals this a POST used to create a new entry
	-H "Content-Type:application/json" sets the content type so the application knows the payload contains a JSON object
	-d '{"name":"Mark","age":54}' is the data being sent.
```

Edit a person through the API:
```
curl -H "Content-Type:application/json" -X PUT -d '{"name":"Mark","age":18}' http://localhost:8080/restapi/people/10003
curl -H "Content-Type:application/json" -X PATCH -d '{"age":54}' http://localhost:8080/restapi/people/10003
	PUT replaces an entire record. Fields not supplied will be replaced with null. PATCH can be used to update a subset of items.
```

Delete person based on ID:
```
curl -X DELETE http://localhost:8080/restapi/people/10003
```

Getting all party information with people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/restapi/parties
```