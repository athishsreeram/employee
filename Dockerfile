FROM openjdk:8-jdk-alpine
COPY ./target/employee-0.0.1-SNAPSHOT.jar /usr/src/emp/
WORKDIR /usr/src/emp
EXPOSE 8080
CMD ["java", "-jar", "employee-0.0.1-SNAPSHOT.jar"]