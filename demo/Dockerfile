# Stage 1: Build the application JAR using Maven (requires Docker BuildKit)
# Use a Maven image that includes JDK 17 (or your required Java version)
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project definition file
COPY pom.xml .

# Download dependencies (this layer is cached unless pom.xml changes)
# RUN mvn dependency:go-offline
# Note: go-offline might be tricky sometimes, alternatively just copy source and build

# Copy the rest of the application source code
COPY src ./src

# Package the application, skipping tests for faster build
# Ensure your application builds correctly with 'mvn package' locally first
RUN mvn package -DskipTests


# Stage 2: Create the final lightweight image
# Use a slim OpenJDK base image matching your Java version
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Define an argument for the JAR file name (makes it easier to manage)
# The JAR file is typically found in the 'target' directory after building
# Adjust the JAR name if your artifactId/version in pom.xml results in a different name
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build stage
COPY --from=build /app/${JAR_FILE} application.jar

# Expose the port the application runs on (defined in application.properties, default 8080)
EXPOSE 8080

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "application.jar"]

# Optional: Add healthcheck if needed
# HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 CMD curl -f http://localhost:8080/actuator/health || exit 1
# (Requires spring-boot-starter-actuator dependency and enabling the health endpoint)
