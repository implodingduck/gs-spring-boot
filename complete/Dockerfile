FROM openjdk:20-jdk-slim-buster as BUILD

ARG SPRING_PROFILES_ACTIVE=default

RUN mkdir -p /usr/src/app
COPY .mvn/ /usr/src/app/.mvn
COPY mvnw /usr/src/app 
COPY pom.xml /usr/src/app 

WORKDIR /usr/src/app

#RUN mvn dependency:go-offline -B
RUN ./mvnw dependency:go-offline

COPY . /usr/src/app 

RUN ./mvnw clean install -DskipTests


FROM openjdk:20-jdk-slim-buster
EXPOSE 8080

COPY --from=BUILD /usr/src/app/target/*.jar /opt/target/app.jar

WORKDIR /opt/target

ENTRYPOINT ["java", "-jar", "app.jar"]