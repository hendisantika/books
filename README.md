# Spring Boot Kotlin Books Application

A comprehensive Books CRUD application built with Spring Boot and Kotlin, featuring modern web technologies and database
management.

## 🚀 Features

- **CRUD Operations**: Complete Create, Read, Update, Delete functionality for books
- **Spring Security**: Authentication and authorization system
- **REST API**: RESTful web services with comprehensive endpoints
- **Database Support**: H2 (development) and MySQL (production) databases
- **API Documentation**: Interactive Swagger UI for API exploration
- **Database Console**: H2 console for database management and testing
- **Thymeleaf Templates**: Server-side rendering with modern UI
- **JPA/Hibernate**: Advanced ORM with entity relationships
- **Multi-profile Support**: Development and production configurations
- **Java 25 Compatible**: Optimized to run on the latest Java LTS

## 🛠 Technology Stack

- **Language**: Kotlin
- **Framework**: Spring Boot 3.5.6
- **Build Tool**: Gradle (Kotlin DSL)
- **Database**: H2 (dev), MySQL (prod)
- **ORM**: JPA/Hibernate 6.6
- **Security**: Spring Security 6
- **Template Engine**: Thymeleaf
- **Documentation**: SpringDoc OpenAPI 3 (Swagger)
- **Java Version**: Compatible with JDK 21-25

## 📋 Prerequisites

- **Java**: JDK 21 or higher (tested with JDK 25)
- **Git**: For cloning the repository
- **MySQL**: Optional, for production profile

## 🚀 Quick Start

### Option 1: Run with Java 25 (Recommended)

Use the provided launcher script that handles JDK 25 compatibility:

```bash
./run-with-java25.sh
```

This script will:

- Build the project with JDK 21 (for Gradle compatibility)
- Run the application with JDK 25
- Configure necessary JVM arguments for Java 25 compatibility
- Start the application on port 8083

### Option 2: Standard Gradle Run

For development with JDK 21:

```bash
# Using Gradle wrapper
./gradlew bootRun --args='--spring.profiles.active=dev --server.port=8081'

# Or traditional command
gradle clean bootRun
```

### Option 3: Build and Run JAR

```bash
# Build the project
./gradlew build -x test

# Run with custom JVM arguments (for Java 25)
java -jar \
    --enable-native-access=ALL-UNNAMED \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.base/java.util=ALL-UNNAMED \
    build/libs/books-0.0.1-SNAPSHOT.jar \
    --spring.profiles.active=dev \
    --server.port=8083
```

## 🌐 Accessing the Application

Once started, the application provides several endpoints:

| Service              | URL                                   | Description                            |
|----------------------|---------------------------------------|----------------------------------------|
| **Main Application** | http://localhost:8083                 | Web interface with Thymeleaf templates |
| **REST API**         | http://localhost:8083/api             | RESTful web services                   |
| **Swagger UI**       | http://localhost:8083/swagger-ui.html | Interactive API documentation          |
| **API Docs**         | http://localhost:8083/v3/api-docs     | OpenAPI 3.0 specification              |
| **H2 Console**       | http://localhost:8083/h2-console      | Database management interface          |

### H2 Database Connection Details

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: _(empty)_

## 📁 Project Structure

```
books/
├── src/
│   ├── main/
│   │   ├── kotlin/com/hendisantika/books/
│   │   │   ├── config/           # Configuration classes
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── domain/          # Entity classes
│   │   │   ├── form/            # Form DTOs
│   │   │   ├── repository/      # Data access layer
│   │   │   └── service/         # Business logic
│   │   └── resources/
│   │       ├── application.yml  # Main configuration
│   │       ├── application-dev.yml # Development profile
│   │       ├── templates/       # Thymeleaf templates
│   │       └── db/migration/    # Database migrations
│   └── test/                    # Test classes
├── gradle/                      # Gradle wrapper
├── build.gradle.kts            # Build configuration
├── gradle.properties           # Gradle properties with Java 25 support
└── run-with-java25.sh         # Java 25 launcher script
```

## ⚙️ Configuration Profiles

### Development Profile (`dev`)

- **Database**: H2 in-memory database
- **Port**: 8083 (configurable)
- **H2 Console**: Enabled
- **SQL Logging**: Enabled
- **Flyway**: Disabled (uses Hibernate auto-DDL)

### Production Profile (`default`)

- **Database**: MySQL
- **Connection**: Requires MySQL server setup
- **Flyway**: Enabled for database migrations
- **Security**: Enhanced settings

## 🛡️ Security Features

- **Authentication**: Form-based login system
- **Authorization**: Role-based access control
- **Password Encoding**: BCrypt hashing
- **CSRF Protection**: Enabled for web forms
- **Session Management**: Secure session handling

## 📊 Database Schema

The application manages the following entities:

- **Books**: Main entity with title, subtitle, descriptions
- **Authors**: Book authors with many-to-many relationship
- **Publishers**: Publishing companies
- **Categories**: Book categorization system
- **Users**: Authentication and authorization
- **Roles**: User role management

## 🔧 Java 25 Compatibility

This application has been optimized to run on Java 25 with the following considerations:

### Build Configuration

- **Compile Target**: Java 21 (for maximum compatibility)
- **Runtime**: Java 25 supported
- **JVM Arguments**: Configured for restricted method access

### Known Limitations

- **Gradle Plugins**: Current Spring Boot and Kotlin Gradle plugins have compatibility issues with Java 25 during build
- **Workaround**: Build with JDK 21, run with JDK 25

### JVM Arguments for Java 25

The following JVM arguments are required for Java 25:

```
--enable-native-access=ALL-UNNAMED
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
```

## 🧪 Testing

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "BooksApplicationTests"

# Generate test report
./gradlew test jacocoTestReport
```

## 🚀 Deployment

### Docker Deployment (Future Enhancement)

```dockerfile
FROM openjdk:25-jdk-slim
COPY build/libs/books-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "--enable-native-access=ALL-UNNAMED", "--add-opens=java.base/java.lang=ALL-UNNAMED", "-jar", "/app.jar"]
```

### JAR Deployment

```bash
# Build production JAR
./gradlew build -x test

# Run in production
java -jar build/libs/books-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

## 📈 Performance Optimization

- **Connection Pooling**: HikariCP for optimal database performance
- **JPA Optimizations**: Lazy loading and query optimization
- **Caching**: Hibernate second-level cache disabled for development
- **JVM Tuning**: Optimized for Java 25 runtime

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🐛 Troubleshooting

### Common Issues

1. **Port Already in Use**
   ```bash
   # Check what's using the port
   lsof -i :8083
   # Kill the process or use a different port
   ```

2. **Java Version Issues**
   ```bash
   # Check Java version
   java -version
   # Ensure JAVA_HOME is set correctly
   echo $JAVA_HOME
   ```

3. **Gradle Build Fails with Java 25**
    - Use the provided `run-with-java25.sh` script
    - Or build with JDK 21 and run with JDK 25

### Support

For issues and questions:

- Create an issue in the GitHub repository
- Check existing documentation and issues first
- Provide detailed error logs and system information

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Spring Security Reference](https://spring.io/projects/spring-security)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)

---

**Made with ❤️ using Spring Boot, Kotlin, and Java 25**