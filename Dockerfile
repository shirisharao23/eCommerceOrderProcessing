FROM adoptopenjdk/openjdk11:latest
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ARG JAR_FILE=target/ecommerce_order_processing_service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
COPY ./debug-entrypoint.sh .
ENTRYPOINT ["java","-jar","/app.jar"]
