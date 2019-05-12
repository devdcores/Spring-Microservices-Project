FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN apk update && apk add bash && apk add git && apk add maven
RUN mkdir /usr/Project
RUN cd /usr/Project && ls

RUN cd /usr/Project && git clone https://github.com/devdcores/Spring-Microservices-Project.git
RUN cd /usr/Project/Spring-Microservices-Project/Address && mvn package && cd /usr/Project/Spring-Microservices-Project/Address/target && ls

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/address-app.jar"]
