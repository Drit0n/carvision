# Usage
# docker build -t drit0n/djl-vehicle-classification .
# docker run --name djl-vehicle-classification -p 9000:8080 -d drit0n/djl-vehicle-classification
# docker push drit0n/djl-vehicle-classification

FROM openjdk:21-jdk-slim

# Copy File/s
WORKDIR /src
COPY models models

COPY src src
COPY .mvn .mvn
COPY pom.xml mvnw ./

# Install
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw
RUN ./mvnw -Dmaven.test.skip=true package

# Docker Run Command
EXPOSE 8080
CMD ["java", "-jar", "target/carvision-0.0.1-SNAPSHOT.jar"]