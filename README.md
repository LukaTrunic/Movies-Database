# 🎬 Movie Management App – Full Stack Web Project

This is a full-stack movie management web application developed as a final university project. The system allows users to view, add, update, and delete movies and actors via a user-friendly interface. It is built using **Vue.js** on the frontend and **Spring Boot (Java)** on the backend, with a **MySQL database** schema.

## ⚙️ Technologies Used

### Frontend:
- Vue.js 3
- TypeScript
- Axios (for HTTP requests)
- Vite (build tool)

### Backend:
- Spring Boot (Java)
- Spring Data JPA
- RESTful APIs
- MySQL Connector
- Maven

### Database:
- MySQL / MariaDB
- ER modeling (3 diagrams provided)


## 📁 ER Diagrams

- `movie-database.png`: base movie table structure  
- `actor-database.png`: actor entity and relationships  
- `actor-movie-database.png`: many-to-many relationship between actors and movies


## 🚀 How to Run

### 1. Download files

### 2. Setup the Database
- Create a database using `movie-app-database.sql`
- Update DB credentials in `application.properties` (backend)

### 3. Run the Backend
```bash
cd back-end/movie-app
./mvnw spring-boot:run
```
- Backend runs at `http://localhost:8080`

### 4. Run the Frontend
```bash
cd front-end/vue-movie
npm install
npm run dev
```
- Frontend runs at `http://localhost:5173`


## 🔄 Features

- ✅ View list of all movies and actors
- ➕ Add new movies or actors
- ✏️ Edit existing movie/actor details
- ❌ Delete movies or actors
- 🔗 Many-to-many relationship between movies and actors
- 📡 REST API consumption with Axios


## 📘 Documentation

- Functional requirements and CRUD breakdown provided in `m2-documentation+frontend.docx`
- Code is organized and commented for clarity


## 📬 Author

Luka Trunić
