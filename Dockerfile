# Build stage
FROM maven:3.8.4-openjdk-17 as builder

# Copy the project files to the container
COPY ./ /usr/src/myapp/
WORKDIR /usr/src/myapp/

# Compile and package the application
RUN mvn clean package

# Run stage
FROM openjdk:17-slim

# Copy the built JAR from the build stage to the run stage
COPY --from=builder /usr/src/myapp/target/myapp.jar /usr/app/myapp.jar

# Set the working directory for the container
WORKDIR /usr/app

# Command to run the application
CMD ["java", "-jar", "myapp.jar"]
