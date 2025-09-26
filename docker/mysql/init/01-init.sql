-- MySQL Initialization Script for Books Application
-- This script sets up the database with proper permissions and initial data

-- Ensure the database exists
CREATE
DATABASE IF NOT EXISTS booksDB;
USE
booksDB;

-- Grant all privileges to the application user
GRANT ALL PRIVILEGES ON booksDB.* TO
'yu71'@'%';
FLUSH
PRIVILEGES;

-- Create initial admin user for the application (password: admin123)
-- This will be created by the application using Flyway migrations