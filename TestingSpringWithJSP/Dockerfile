# Use OpenJDK as base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/springboot-jsp-app.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
