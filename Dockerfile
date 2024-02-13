FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY out/*.jar server.jar
ENTRYPOINT ["java","-jar","/server.jar"]
EXPOSE 4001