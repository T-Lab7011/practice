FROM openjdk:17-slim

WORKDIR /app

COPY target/practice-0.0.1-SNAPSHOT.jar /app/practice.jar

ENTRYPOINT ["java", "-jar", "practice.jar"]