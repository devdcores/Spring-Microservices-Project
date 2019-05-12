#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY target/${JAR_FILE} eureka-app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-app.jar"]

FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk update && \
    apk add bash && \
    apk add --no-cache git && \
    apk add maven

ENV APP_LOCATION=/usr/src/app

RUN mkdir -p $APP_LOCATION
WORKDIR $APP_LOCATION

RUN git clone https://github.com/devdcores/Spring-Microservices-Project.git

WORKDIR $APP_LOCATION/Spring-Microservices-Project/EurekaServer

RUN mvn dependency:go-offline
RUN mvn package

ENTRYPOINT java -jar $APP_LOCATION/Spring-Microservices-Project/EurekaServer/target/EurekaServer-0.0.1-SNAPSHOT.jar