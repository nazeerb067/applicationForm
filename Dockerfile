# Use an official OpenJDK image as a base
FROM openjdk:17-jdk-slim


# Set the working directory
WORKDIR /App

# Copy the JAR file into the container
COPY target/springboot-docker.jar  /App/springboot-docker.jar

# Expose port 8080 for external access
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]



