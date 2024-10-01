#Define base docker image
FROM openjdk:21
LABEL maintainer="microservices"
ADD target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-docker.jar
ENTRYPOINT ["java", "-jar", "api-gateway-docker.jar"]



# docker build -t api-gateway-docker:latest .
# docker run -p 8090:8080 api-gateway-docker
