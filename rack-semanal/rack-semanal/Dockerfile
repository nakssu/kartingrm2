FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} rack-semanal.jar
ENTRYPOINT ["java","-jar","/rack-semanal.jar"]