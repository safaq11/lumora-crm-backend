# Stage 1: Build the application (Heavy lifting)
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application (Lightweight)
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy only the compiled JAR from the builder stage
COPY --from=builder /app/target/customer_lead_crm_backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# Use the dynamic port variable assigned by Render
CMD ["java", "-jar", "-Dserver.port=${PORT:8080}", "app.jar"]