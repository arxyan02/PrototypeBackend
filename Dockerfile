FROM openjdk:17
WORKDIR /app
COPY ./target/prototypebackend.jar /app
EXPOSE 8080
CMD ["java", "-jar", "prototypebackend.jar"]