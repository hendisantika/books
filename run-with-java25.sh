#!/bin/bash

# Launcher script for running the Books application with Java 25
# This script works around Gradle plugin compatibility issues with Java 25

echo "🚀 Starting Books Application with Java 25..."

# Build with Java 21 (for Gradle compatibility)
echo "📦 Building application..."
export JAVA_HOME=/Users/hendisantika/Library/Java/JavaVirtualMachines/corretto-21.0.8/Contents/Home
./gradlew build --no-daemon -x test

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"

    # Run with Java 25
    echo "🔧 Launching with Java 25..."
    unset JAVA_HOME  # Use system default (Java 25)

    java -jar \
        --enable-native-access=ALL-UNNAMED \
        --add-opens=java.base/java.lang=ALL-UNNAMED \
        --add-opens=java.base/java.util=ALL-UNNAMED \
        build/libs/books-0.0.1-SNAPSHOT.jar \
        --spring.profiles.active=dev \
        --server.port=8083
else
    echo "❌ Build failed!"
    exit 1
fi