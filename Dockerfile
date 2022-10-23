#FROM eclipse-temurin:17-jdk-alpine
#
#VOLUME /tmp
#
#ARG JAR_FILE
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/grooming_mood-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /grooming_mood.jar
ENTRYPOINT ["java","-jar","/grooming_mood.jar"]