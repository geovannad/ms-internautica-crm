FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
COPY --from=build /target/Ms-internautica-crm-0.0.1-SNAPSHOT.jar Ms-internautica-crm.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Ms-internautica-crm.jar"]
