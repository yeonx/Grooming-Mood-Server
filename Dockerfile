FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/grooming_mood-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /grooming_mood.jar

ENTRYPOINT ["java","-jar","/grooming_mood.jar"]