Spring boot application to access and list GIT repository issues for a given organization

Spring Boot 2.00
Spring Data JPA
Flyway
Basic In-memory Security
HTTP and HTTPs profiles
HTTP to HTTPs redirection

We can run the application in two modes HTTP and HTTPs to run the application in secure/HTTPS mode use the spring active profile http (-Dspring.profiles.active=https)

Further with some code changes you can start the application with 2 connectors HTTP and HTTPS and forward all your HTTP(8080) requests to HTTPS(8443) port.

URL's
http://localhost:8080/dashboard

http://localhost:8080/admin

http://localhost:8080/events/{projectName}

https://localhost:8443/dashboard

https://localhost:8443/admin

https://localhost:8443/events/{projectName}


