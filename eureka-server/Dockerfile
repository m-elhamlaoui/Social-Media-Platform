FROM openjdk:21-jdk as BUILD
COPY ./.mvn ./.mvn
COPY ./mvnw ./mvnw
COPY ./pom.xml ./pom.xml
RUN ./mvnw dependency:go-offline -B
COPY ./src ./src
RUN ./mvnw package spring-boot:repackage -DskipTests

FROM openjdk:21-jdk
COPY --from=BUILD target/*.jar app.jar
EXPOSE 8036
ENTRYPOINT ["java","-jar","/app.jar"]
