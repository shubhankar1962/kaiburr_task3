FROM openjdk:17
ADD target/kaiburr-mongo-docker.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

