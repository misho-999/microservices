#Define base docker image
FROM openjdk:21
LABEL maintainer="microservices"
ADD target/car-api-0.0.1-SNAPSHOT.jar car-api-docker.jar
ENTRYPOINT ["java", "-jar", "car-api-docker.jar"]

# docker build -t car-api-docker:latest .
# docker run -p 8090:8080 car-api-docker