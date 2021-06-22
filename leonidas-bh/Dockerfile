FROM maven:3.8.1-openjdk-11
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package

WORKDIR /tmp/
RUN cp /tmp/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080