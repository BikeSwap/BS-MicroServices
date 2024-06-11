FROM amazoncorretto:19.0.2-alpine3.18
WORKDIR /app

COPY target/bike-microservice-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bike-microservice-0.0.1-SNAPSHOT.jar"]