FROM openjdk:11
ARG JAR_FILE=jee-api-1.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]