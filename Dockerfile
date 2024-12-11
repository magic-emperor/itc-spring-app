FROM maven:3.8.3-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/ITC-Product-APP-0.0.1-SNAPSHOT.jar ITC-Product-APP.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ITC-Product-APP.jar"]
