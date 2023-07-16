FROM openjdk:17-alpine

COPY hackernewspi/build/libs/hackernewspi-0.0.1-SNAPSHOT.jar hackernewspi-0.0.1-SNAPSHOT.jar 

EXPOSE 8080

CMD ["java", "-jar", "hackernewspi-0.0.1-SNAPSHOT.jar"]