FROM openjdk:21-jdk
COPY ./target/crmapi-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar ./app.jar