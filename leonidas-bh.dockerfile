FROM maven:3.8.1-openjdk-11-slim
COPY pom.xml /tmp/
COPY leonidas-common/pom.xml /tmp/common/
COPY leonidas-common/src /tmp/common/src/
WORKDIR /tmp/common/
RUN mvn clean package

COPY leonidas-bh/pom.xml /tmp/bh/
COPY leonidas-bh/src /tmp/bh/src/
WORKDIR /tmp/bh/
RUN mvn clean package -Dleonidas.common.path=/tmp/common/target/leonidas-common-0.0.1-SNAPSHOT.jar

FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.6_10
WORKDIR /tmp/
COPY --from=0 /tmp/bh/target/leonidas-bh-0.0.1-SNAPSHOT-spring-boot.jar /tmp/bh/app.jar
WORKDIR /tmp/bh/
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080