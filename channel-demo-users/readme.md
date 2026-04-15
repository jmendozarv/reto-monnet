# Users API 🚀

API desarrollada en **Java 17 + Spring Boot** que:

* Consume datos desde `https://jsonplaceholder.typicode.com/users`
* Guarda la información en **H2 (en memoria)**
* Expone un endpoint REST `/users`
* Protege el acceso con **JWT**
* Incluye **Actuator**, **Swagger/OpenAPI** y **Docker**

---

## 🛠️ Tecnologías

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Spring Security + JWT
* Spring Boot Actuator
* OpenAPI / Swagger
* Maven
* Docker

---

## 🚀 Cómo usarlo

### 🔹 1. Clonar el proyecto

```bash
git clone <url-del-repositorio>
cd users-api
```

---

### 🔹 2. Ejecutar con Maven

```bash
mvn spring-boot:run
```

La aplicación se iniciará en:

```
http://localhost:8080
```

---

### 🔹 3. Obtener token JWT

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
        "username": "admin",
        "password": "admin123"
      }'
```

Respuesta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

### 🔹 4. Consumir endpoint protegido

```bash
curl http://localhost:8080/users \
  -H "Authorization: Bearer TU_TOKEN"
```

---

### 🔹 5. Endpoints disponibles

| Endpoint               | Descripción                     |
| ---------------------- | ------------------------------- |
| `POST /auth/login`     | Genera JWT                      |
| `GET /users`           | Lista usuarios (requiere token) |
| `GET /actuator/health` | Estado de la app                |
| `GET /actuator/info`   | Información de la app           |

---

### 🔹 6. Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🐳 Ejecutar con Docker

### 🔹 Construir imagen

```bash
docker build -t users-api .
```

### 🔹 Ejecutar contenedor

```bash
docker run -p 808X:8080 users-api
```

---

## 🗄️ Base de datos H2

Consola disponible en:

```
http://localhost:808X/h2-console
```

Datos de conexión:

```
JDBC URL: jdbc:h2:mem:usersdb
User: sa
Password: (vacío)
```

---

## ⚙️ Carga de datos

Los datos se cargan automáticamente al iniciar la aplicación mediante:

```
DataLoaderService (CommandLineRunner)
```

Este servicio consume la API externa y guarda los datos en H2.

---

## 🧪 Tests

Ejecutar tests:

```bash
mvn test
```

Incluye:

* Test de servicio (`UserServiceTest`)
* Test de controlador (`UserControllerTest`)

---

## 🔐 Seguridad

* Autenticación basada en **JWT**
* Header requerido:

```
Authorization: Bearer <token>
```

---

## 📦 Estructura del proyecto

```
com.example.users
├── config
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
```

---
