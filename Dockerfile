FROM openjdk:8
ADD build/libs/Journal-0.0.1-SNAPSHOT.jar journal-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "journal-app.jar"]