# Usar la imagen oficial de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/cursoSpringBoot-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que tu aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
