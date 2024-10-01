#Define base docker image
FROM openjdk:21
LABEL maintainer="microservices"
ADD target/registry-0.0.1-SNAPSHOT.jar registry-docker.jar
ENTRYPOINT ["java", "-jar", "registry-docker.jar"]

#docker build -t registry-docker:latest .
