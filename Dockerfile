# Use an official OpenJDK 17 runtime as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/clinicalapi-0.0.1-SNAPSHOT.jar /app/clinicalapi-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/clinicalapi-0.0.1-SNAPSHOT.jar"]