FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# เพิ่มบรรทัดนี้เพื่อให้ permission execute
RUN chmod +x mvnw

RUN ./mvnw dependency:resolve

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/your-app.jar"]
