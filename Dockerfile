FROM openjdk:17.0.1

WORKDIR /app

COPY target/CICD-BackendLink-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "CICD-BackendLink-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]