# Use a base image with JDK 17
FROM openjdk:17-jdk-slim
# Set the working directory
WORKDIR /app
# Default to "build"
ARG PROFILE=build
#Set SB active profile
ENV SPRING_PROFILES_ACTIVE=${PROFILE}
# Copy the packaged application jar file into the container
COPY /build/libs/dancing-queen-api-0.0.1-SNAPSHOT.jar app.jar
# Expose the port your app runs on
EXPOSE 8080
# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]