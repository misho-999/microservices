# microservices
REST project with microservices for learning purpose

# Introduction
The project contains the following microservices:
- registry-service
- api-gateway
- user-service
- car-service

# Service registry - Eureka server
http://localhost:8761/

# Star the project:
- Start every microservice
- Test with postman on  http://localhost:8080/* for example: 
- http://localhost:8080/cars/all 
- http://localhost:8080/users/all
- http://localhost:8082/users/car/2 => Service communication. !!!user-service call car-service!!!

# Useful links
https://www.youtube.com/watch?v=NpdG3lmKJ5g
https://www.youtube.com/watch?v=MrSECdSIaOg

# Create DOCKER image 
1. Create Dockerfile in root directory in the project. Content example:
   FROM openjdk:21
   LABEL maintainer="microservices"
   ADD target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-docker.jar
   ENTRYPOINT ["java", "-jar", "api-gateway-docker.jar"]
2. Create Docker image with following command:
docker build -t api-gateway-docker:latest .
3. Check the images:
   docker images
4. Run the image:
docker run -p 8090:8080 api-gateway-docker

https://www.youtube.com/watch?v=RVIbMuNs1aw&ab_channel=JavaGuides