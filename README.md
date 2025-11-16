# RestfulApi – Employee & Document Management (Spring Boot)

A simple dummy Spring Boot REST API for managing employees and their documents.
Built for learning, testing, and small-scale demos.

⭐ What this project does

This service provides:

  CRUD operations for Employee
  
  Uploading, retrieving & deleting Document files for each employee Stores:
  
  file bytes,file name / type / size,timestamp
  
  Uses Spring Data JPA to persist data in the database

Suitable for practice projects, demos, and learning REST + JPA

⚠️ Note: For real production use, storing large files directly in the database isn’t ideal — object storage like AWS S3 or similar is recommended.

🛠 Tech Stack

  Java 17
  
  Spring Boot
  
  Spring Web
  
  Spring Data JPA (Hibernate)
  
  PostgreSQL (Cloud DB from Aiven)

Maven

🗄 Database Configuration

Cloud PostgreSQL from Aiven is used.
To keep credentials safe, the project uses environment variables:

spring.datasource.url=${DB_URL:}
spring.datasource.username=${DB_USER:}
spring.datasource.password=${DB_PASSWORD:}


Before running the app, set values in your terminal:

Linux / macOS
export DB_URL="jdbc:postgresql://<host>:<port>/<db>?sslmode=require"
export DB_USER="avnadmin"
export DB_PASSWORD="<your-password>"

Windows PowerShell
$env:DB_URL="jdbc:postgresql://<host>:<port>/<db>?sslmode=require"
$env:DB_USER="avnadmin"
$env:DB_PASSWORD="<your-password>"

▶️ Running the Project
mvn clean package
mvn spring-boot:run


App will start on:

http://localhost:8080

📌 API Overview
Employees

GET /api/employees — List all employees

GET /api/employees/{id} — Get employee by ID

POST /api/employees — Create employee

PUT /api/employees/{id} — Update employee

DELETE /api/employees/{id} — Delete employee

Documents

POST /api/documents/upload/{employeeId} — Upload document for an employee

GET /api/documents/{id} — Get document metadata + file bytes

DELETE /api/documents/{id} — Delete document

📄 Note

This is a dummy practice project, not intended for production.
Used to learn:

REST APIs

File upload handling

JPA relationships (One-to-Many, Many-to-One)

Cloud DB connection with Aiven

🧑‍💻 Author

Sky-000007 (Shailendra Kumar)
GitHub: https://github.com/Sky-000007
