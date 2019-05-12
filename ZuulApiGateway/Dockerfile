#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY target/${JAR_FILE} gateway-server.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-server.jar"]

#
#FROM java:8-jdk-alpine
#
#COPY ./target/ZuulApiGateway-0.0.1-SNAPSHOT.jar /usr/app/
#
#WORKDIR /usr/app
#
#RUN sh -c 'touch ZuulApiGateway-0.0.1-SNAPSHOT.jar'
#
#ENTRYPOINT ["java","-jar","ZuulApiGateway-0.0.1-SNAPSHOT.jar"]


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

WORKDIR $APP_LOCATION/Spring-Microservices-Project/ZuulApiGateway

RUN mvn dependency:go-offline
RUN mvn package

ENTRYPOINT java -jar $APP_LOCATION/Spring-Microservices-Project/ZuulApiGateway/target/ZuulApiGateway-0.0.1-SNAPSHOT.jar