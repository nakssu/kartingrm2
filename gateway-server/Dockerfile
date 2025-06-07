FROM maven:3.9-eclipse-temurin-17 AS builder
RUN apt-get update && apt-get install -y curl


WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN mvn dependency:go-offline -B

COPY src src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

RUN addgroup -g 1000 spring && \
    adduser -u 1000 -G spring -s /bin/sh -D spring

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

USER spring:spring

#EXPOSE 8090

ENTRYPOINT ["java", \
    "-jar", \
    "app.jar"]