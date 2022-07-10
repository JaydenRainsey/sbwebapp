FROM openjdk:8
EXPOSE 8080
ADD target/demoservice.jar app.jar
ENTRYPOINT [ "java" , "-jar" , "/app.jar"]