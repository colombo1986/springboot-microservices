FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","springboot-docker-demo-0.0.1-SNAPSHOT.jar"]