# FROM openjdk

# WORKDIR /app

# COPY target/projetogrupoum-0.0.1-SNAPSHOT.jar /app/projetogrupoum.jar

# ENTRYPOINT [ "java", "-jar", "spring-app.jar" ]

FROM openjdk:17
LABEL maintainer="csantos.pereira@icloud.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} projetogrupoum-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev","-jar","projetogrupoum-0.0.1-SNAPSHOT.jar"]