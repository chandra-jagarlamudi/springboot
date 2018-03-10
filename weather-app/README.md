# Spring Boot Weather App Dockerized

Sample project in the learning process to dockerize a Spring Boot application using a single `Dockerfile` or combining it with `docker-compose`.

Have Docker installed, configured and running on your local machine

## Running the app with Docker

Make sure you generate first the `.jar` file by running:

`mvn clean package`

1. Execute using DockerFile

    - 'docker build -t weather-app-docker-file .' (This command build the docker image)
    
    - 'docker run -p 8080:8080 weather-app-docker-file' (By using the -p flag we’re telling docker to expose the container’s port 8080 (on the right of the colon) on the host’s port 8080 (on the left, our machine). We can access from our machine to localhost:8080 (browser or command line) and see the weather page, this time coming from the Docker container)

2. Execute using Docker Compose

    - 'docker-compose up' (This command builds the docker image and runs the conatiner based on the docker-compose.yml file)
    
    - 'docker-compose ps' (This command shows the running container and the port on which its running, We can access from our machine to localhost:<port> (browser or command line) and see the weather page, this time coming from the Docker container)
    
    - Subsequent executions of docker-compose up won’t require building the image
    
    - However, you can rebuild the image whenever you want, by using:
        
        'docker-compose build', which will build all the services but not run them.
        
        'docker-compose up --build', which will build all the services and then run them.