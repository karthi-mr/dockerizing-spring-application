# ----- Build Stage -----
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

COPY src ./src

RUN mvn -q -DskipTests clean package

# ----- Run time -----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/app

COPY --from=build app/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
