FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG DEPENDENCY=target/apptest-0.0.1-SNAPSHOT.jar
ADD ${DEPENDENCY} apptest.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/apptest.jar"]