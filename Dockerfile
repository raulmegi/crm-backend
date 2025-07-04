# ----------------------------------------------------------------
# Etapa 1: Compilación con Maven + JDK 21
# ----------------------------------------------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos sólo el pom para aprovechar la cache de capas de Docker
COPY pom.xml .

# Copiamos el código fuente
COPY src ./src

# Empaquetamos el .jar (sin tests para agilizar)
RUN mvn clean package -DskipTests

# ----------------------------------------------------------------
# Etapa 2: Imagen final con sólo JDK
# ----------------------------------------------------------------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copiamos el .jar generado en la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto que usa Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando por defecto al arrancar el contenedor
ENTRYPOINT ["java","-jar","app.jar"]
