FROM openjdk:8-jre-alpine
COPY ./target/weather-app-0.0.1-SNAPSHOT.jar /usr/src/weather-app/
WORKDIR /usr/src/weather-app
EXPOSE 8080
CMD ["java", "-jar", "weather-app-0.0.1-SNAPSHOT.jar"]
