FROM openjdk:21-jdk
COPY ./target/*.jar app.jar
EXPOSE 8036
ENTRYPOINT ["java","-jar","/app.jar"]
