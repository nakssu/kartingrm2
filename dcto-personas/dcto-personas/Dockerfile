FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} dcto-personas.jar
ENTRYPOINT ["java","-jar","/dcto-personas.jar"]