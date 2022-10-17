FROM openjdk:11
MAINTAINER minty.com
WORKDIR /opt/app
VOLUME /tmp
ARG APP_NAME="demo-docker"
ARG APP_VERSION="0.0.2-SNAPSHOT"
ARG JAR_FILE=target/${APP_NAME}-${APP_VERSION}.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080