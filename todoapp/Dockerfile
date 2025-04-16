# ใช้ OpenJDK เป็น Base Image
FROM eclipse-temurin:17-jdk-jammy

# สร้าง Working Directory
WORKDIR /app

# คัดลอกไฟล์ build และ dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

# คัดลอกซอร์สโค้ด
COPY src ./src

# Build JAR File
RUN ./mvnw clean package -DskipTests

# Run Spring Boot App
CMD ["java", "-jar", "target/TodoappApplication.jar"]