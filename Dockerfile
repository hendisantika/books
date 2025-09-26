# Multi-stage Dockerfile for Spring Boot Kotlin Books Application
# Stage 1: Build the application
FROM gradle:8.7-jdk21 AS builder

# Set working directory
WORKDIR /app

# Copy gradle files
COPY build.gradle.kts gradle.properties ./
COPY gradle/ gradle/

# Copy source code
COPY src/ src/

# Build the application (excluding tests for faster build)
RUN gradle clean build -x test --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:25-jdk-slim AS runtime

# Install curl for health checks
RUN apt-get update && \
    apt-get install -y curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Create application user for security
RUN groupadd -r spring && useradd -r -g spring spring

# Set working directory
WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/build/libs/books-0.0.1-SNAPSHOT.jar app.jar

# Change ownership to application user
RUN chown -R spring:spring /app

# Switch to application user
USER spring

# Expose application port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

# Set JVM arguments for Java 25 compatibility and optimal container performance
ENV JAVA_OPTS="-Xmx512m -Xms256m \
    --enable-native-access=ALL-UNNAMED \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.util=ALL-UNNAMED \
    --add-opens=java.base/java.lang.invoke=ALL-UNNAMED \
    --add-opens=java.prefs/java.util.prefs=ALL-UNNAMED \
    --add-opens=java.base/java.nio.charset=ALL-UNNAMED \
    --add-opens=java.base/java.net=ALL-UNNAMED \
    --add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED"

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]