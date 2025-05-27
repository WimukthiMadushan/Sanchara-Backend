## Following is the code for rebuilding the project within the image

#FROM maven:3.9.9-eclipse-temurin-21 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn package -DskipTests -X
#
#FROM openjdk:21-jdk-slim
#WORKDIR /app
#ARG JAR_FILE=target/*.jar
#COPY --from=build /app/${JAR_FILE} application.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "application.jar"]

## Follwing is the build code for using the jar image in the debugging env

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY pom.xml .
COPY . .
CMD ["java", "-jar", "target/UserManagmentService-0.0.1-SNAPSHOT.jar"]
