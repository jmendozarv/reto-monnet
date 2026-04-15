# =========================
# Etapa 1: Build
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiar pom y descargar dependencias primero (mejora cache)
COPY pom.xml .
RUN mvn -B -q -e -DskipTests dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar proyecto
RUN mvn clean package -DskipTests

# =========================
# Etapa 2: Run
# =========================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar el jar generado
COPY --from=builder /app/target/*.jar app.jar

# Puerto de Spring Boot
EXPOSE 8080

# Ejecutar aplicación
ENTRYPOINT ["java","-jar","/app/app.jar"]