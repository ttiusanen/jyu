FROM openjdk:11-jre-slim

# Create app directory
RUN mkdir -p /app

# Copy application jar to App directory
COPY target/issuetracker-1.0-SNAPSHOT.jar /app/issuetracker-1.0-SNAPSHOT.jar

# Create temp dir
RUN mkdir -p /temp

# Run app as root
USER root

# Expose port 8080
EXPOSE 8080

CMD java -jar -XX:+ExitOnOutOfMemoryError /app/issuetracker-1.0-SNAPSHOT.jar