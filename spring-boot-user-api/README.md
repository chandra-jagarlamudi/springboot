# springboot
My Spring Boot User API example

GET Users
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/users

GET User with a ID
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/users/{id}
	
GET a User's post
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/users/{id}/posts
	
POST a User
	curl -H "Content-Type: application/json" -X POST -d '{"name":"Mark","age":54}' http://localhost:8080/users
	
POST a User's post
	curl -H "Content-Type: application/json" -X POST -d '{"name":"Mark","age":54}' http://localhost:8080/users/{id}/posts

DELETE a User
	curl -X DELETE http://localhost:8080/users/10003

Actuator
    http://localhost:8080/application

Versioning
	http://localhost:8080/v1/person
		curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/v1/person
    
	http://localhost:8080/v2/person
		curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/v2/person
    
	http://localhost:8080/person/param
		params=[version=1]
	http://localhost:8080/person/param
		params=[version=2]
		
	http://localhost:8080/person/header
		headers=[X-API-VERSION=1]
		curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "X-API-VERSION:1" -X GET http://localhost:8080/person/header
        
	http://localhost:8080/person/header
		headers=[X-API-VERSION=2]
		curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "X-API-VERSION:2" -X GET http://localhost:8080/person/header
        
	http://localhost:8080/person/produces
		produces=[application/vnd.company.app-v1+json]
		curl -i -H "Accept: application/vnd.company.app-v1+json" -H "Content-Type: application/json" -X GET http://localhost:8080/person/produces
        
	http://localhost:8080/person/produces
        produces=[application/vnd.company.app-v2+json]
        curl -i -H "Accept: application/vnd.company.app-v2+json" -H "Content-Type: application/json" -X GET http://localhost:8080/person/produces

Swagger
    http://localhost:8080/swagger-ui.html
    http://localhost:8080/v2/api-docs

H2-Console
    http://localhost:8080/h2-console