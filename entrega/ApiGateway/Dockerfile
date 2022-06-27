FROM openjdk:19-jdk-alpine3.15
WORKDIR /ApiGateway
EXPOSE 8080
COPY target/ApiGateway-0.0.1-SNAPSHOT.jar /ApiGateway/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]