FROM openjdk:8-jdk-alpine
COPY target/web-crawler-0.0.1-SNAPSHOT.jar web-crawler-0.0.1.jar
ENTRYPOINT ["java","-jar","/web-crawler-0.0.1.jar", "--spring.profiles.active=prod"]