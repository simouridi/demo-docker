FROM openjdk:11
MAINTAINER minty.com
WORKDIR /opt/app
VOLUME /tmp
ARG JAR_FILE=target/demo-docker.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["./wait-for-it.sh","mysqldb:3306" ,"java","-jar","app.jar"]
EXPOSE 8080