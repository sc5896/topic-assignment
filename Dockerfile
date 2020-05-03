FROM openjdk:8-jdk-alpine
ADD **/*.jar /opt/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","*.jar"]