FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} dcto-frecuente.jar
ENTRYPOINT ["java","-jar","/dcto-frecuente.jar"]