#!/bin/bash

# Docker Build Script for Books Spring Boot Application
# This script builds and runs the application with Docker Compose

set -e  # Exit on any error

echo "🐳 Docker Build Script for Books Application"
echo "============================================="

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker is not running. Please start Docker and try again."
    exit 1
fi

# Check if Docker Compose is available
if ! command -v docker-compose &> /dev/null && ! docker compose version &> /dev/null; then
    echo "❌ Docker Compose is not available. Please install Docker Compose and try again."
    exit 1
fi

# Function to use docker compose or docker-compose
docker_compose_cmd() {
    if command -v docker &> /dev/null && docker compose version &> /dev/null 2>&1; then
        docker compose "$@"
    elif command -v docker-compose &> /dev/null; then
        docker-compose "$@"
    else
        echo "❌ Neither 'docker compose' nor 'docker-compose' is available."
        exit 1
    fi
}

# Parse command line arguments
case "${1:-help}" in
    "build")
        echo "📦 Building Docker images..."
        docker_compose_cmd build --no-cache
        echo "✅ Build completed!"
        ;;

    "up")
        echo "🚀 Starting services..."
        docker_compose_cmd up -d
        echo "✅ Services started!"
        echo ""
        echo "📋 Service URLs:"
        echo "   🌐 Application:    http://localhost:8080"
        echo "   📊 Swagger UI:     http://localhost:8080/swagger-ui.html"
        echo "   🗄️  PHPMyAdmin:    http://localhost:8081"
        echo "   📈 Health Check:   http://localhost:8080/actuator/health"
        echo ""
        echo "🗄️  Database Connection:"
        echo "   Host:     localhost:3306"
        echo "   Database: booksDB"
        echo "   Username: yu71"
        echo "   Password: 53cret"
        ;;

    "down")
        echo "🛑 Stopping services..."
        docker_compose_cmd down
        echo "✅ Services stopped!"
        ;;

    "restart")
        echo "🔄 Restarting services..."
        docker_compose_cmd restart
        echo "✅ Services restarted!"
        ;;

    "logs")
        echo "📋 Showing logs..."
        docker_compose_cmd logs -f ${2:-}
        ;;

    "status")
        echo "📊 Service Status:"
        docker_compose_cmd ps
        ;;

    "clean")
        echo "🧹 Cleaning up..."
        docker_compose_cmd down -v --remove-orphans
        docker system prune -f
        echo "✅ Cleanup completed!"
        ;;

    "rebuild")
        echo "🔨 Rebuilding and restarting..."
        docker_compose_cmd down
        docker_compose_cmd build --no-cache
        docker_compose_cmd up -d
        echo "✅ Rebuild completed!"
        echo ""
        echo "📋 Service URLs:"
        echo "   🌐 Application:    http://localhost:8080"
        echo "   📊 Swagger UI:     http://localhost:8080/swagger-ui.html"
        echo "   🗄️  PHPMyAdmin:    http://localhost:8081"
        ;;

    "help"|*)
        echo "📚 Usage: $0 [COMMAND]"
        echo ""
        echo "Available commands:"
        echo "  build     - Build Docker images"
        echo "  up        - Start all services"
        echo "  down      - Stop all services"
        echo "  restart   - Restart all services"
        echo "  logs      - Show service logs (optional: service name)"
        echo "  status    - Show service status"
        echo "  clean     - Stop services and clean up"
        echo "  rebuild   - Rebuild images and restart services"
        echo "  help      - Show this help message"
        echo ""
        echo "Examples:"
        echo "  $0 up              # Start all services"
        echo "  $0 logs books-app  # Show app logs"
        echo "  $0 logs mysql      # Show MySQL logs"
        echo "  $0 rebuild         # Rebuild and restart"
        ;;
esac