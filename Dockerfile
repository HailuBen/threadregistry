# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx400m", "-Xss512k", "-XX:TieredStopAtLevel=1", "-Dserver.port=${PORT}", "-jar", "app.jar"]