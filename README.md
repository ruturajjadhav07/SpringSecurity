# Spring-Boot Security
This project is a full-stack application using **Spring Boot** (backend) and **React.js** (frontend) with authentication and token-based security.

## 🛠️ Technologies Used
### Backend:
- Spring Boot
- Spring Security (JWT Authentication)
- MySQL (or H2 Database)
- JPA (Hibernate)
- Lombok

### Frontend:
- React.js
- React Router
- Axios
- Bootstrap

## 🚀 How to Run the Project

### 🔹 Backend (Spring Boot)
1. **Clone the repository:**
   ```sh
   git clone https://github.com/ruturajjadhav07/SpringSecurity.git
   cd SpringSecurity
   ```
2. **Configure the Database** (Update `application.properties` if needed):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
3. **Build and Run the Spring Boot Application:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will be running on `http://localhost:8080`

### 🔹 Frontend (React.js)
1. **Navigate to the frontend directory:**
   ```sh
   cd frontend  # (Ensure you are in the correct directory)
   ```
2. **Install dependencies:**
   ```sh
   npm install
   ```
3. **Start the React application:**
   ```sh
   npm start
   ```
   The frontend will be running on `http://localhost:5173`

## 🔐 Authentication & Security
- JWT (JSON Web Token) is used for authentication.
- User needs to log in to access protected routes.
- Token expires after 1 minute, requiring re-login.

## 📄 API Endpoints
| Method | Endpoint       | Description              |
|--------|--------------|--------------------------|
| POST   | `/register`  | Register a new user      |
| POST   | `/login`     | Authenticate user & get JWT token |
| GET    | `/users`     | Get user details (Requires Authentication) |


# Some Concepts from codes
## 1. Authentication and Authorization
- **Authentication** is the process of verifying the identity of a user (e.g., login with username and password).
- **Authorization** determines what resources a user has access to after authentication (e.g., role-based access control).

## 2. CSRF (Cross-Site Request Forgery)
- CSRF is an attack where a user is tricked into performing an unwanted action on a website where they are authenticated.
- Spring Security provides CSRF protection by generating a unique token for each user session.

## 3. Configuration Class, `@Configuration`, and `@EnableWebSecurity`
- **Configuration Class**: A Java class that defines security settings.
- **`@Configuration`**: An annotation that marks a class as a configuration file in Spring.
- **`@EnableWebSecurity`**: Enables Spring Security and allows customization of security settings.

## 4. `UserDetailsService` and `InMemoryUserDetailsManager`
- **`UserDetailsService`**: An interface for loading user details from a database or memory.
- **`InMemoryUserDetailsManager`**: An in-memory implementation of `UserDetailsService` for testing purposes.

## 5. `UserDetails` and `User`
- **`UserDetails`**: An interface representing user-specific security details (e.g., username, password, roles).
- **`User`**: A default implementation of `UserDetails` provided by Spring Security.

## 6. `AuthenticationProvider` and `DaoAuthenticationProvider`
- **`AuthenticationProvider`**: An interface responsible for authenticating user credentials.
- **`DaoAuthenticationProvider`**: A Spring-provided implementation that retrieves user details from `UserDetailsService` and verifies credentials.

## 7. `loadUserByUsername`
- A method in `UserDetailsService` used to fetch user details based on the username.

## 8. `BCryptPasswordEncoder`
- A password hashing utility that provides secure encoding using the BCrypt hashing algorithm.

## 9. JWT (JSON Web Token)
- A compact, self-contained token used for securely transmitting information.
- Consists of three parts:
  - **Header**: Contains token metadata (e.g., algorithm type).
  - **Payload**: Contains user-related claims (e.g., username, roles, expiration time).
  - **Signature**: A cryptographic signature to verify token integrity.

## 10. `AuthenticationManager`
- An interface responsible for handling authentication requests and delegating them to `AuthenticationProvider`.

## 11. `UsernamePasswordAuthenticationToken`
- A Spring Security class used to store authentication details (e.g., username, password, roles).

## 12. `KeyGenerator`
- A Java utility used to generate cryptographic keys (e.g., for JWT signing).

## 13. `SecretKey`
- A secret key used for encryption and decryption, typically used in HMAC-based JWT signing.

## 14. `OncePerRequestFilter`
- A Spring Security filter that ensures a request is processed only once per request cycle.

## 15. `ApplicationContext`
- A Spring container that manages application beans and dependencies.

## 16. `SecurityContextHolder`
- A Spring Security class that holds the authentication details of the current user.

## 17. `WebAuthenticationDetailsSource`
- A class used to build authentication details (e.g., IP address, session ID) during authentication.

--- 
### For more documentation, refer to the official Spring Boot documentation:
[Spring Boot Security Documentation](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)

