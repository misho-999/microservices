#Define base docker image
FROM openjdk:21
LABEL maintainer="microservices"
ADD target/user-api-0.0.1-SNAPSHOT.jar user-api-docker.jar
ENTRYPOINT ["java", "-jar", "user-api-docker.jar"]

#docker build -t user-api-docker:latest .
# docker run -p 8090:8080 user-api-docker