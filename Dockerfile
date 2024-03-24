FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY products-warehouse-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "/app/products-warehouse-0.0.1-SNAPSHOT.jar"]