FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar learn-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/learn-0.0.1-SNAPSHOT"]