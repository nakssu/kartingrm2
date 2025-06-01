FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} tarifa-reserva.jar
ENTRYPOINT ["java","-jar","/tarifa-reserva.jar"]