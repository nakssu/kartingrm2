FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} registro-comprobantes.jar
ENTRYPOINT ["java","-jar","/registro-comprobantes.jar"]