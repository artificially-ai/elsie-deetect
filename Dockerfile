FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git curl

COPY build/libs/elsie-deetect-1.0-SNAPSHOT.jar /ekholabs/elsie-deetect.jar

WORKDIR ekholabs

ENV ELSIE_DEETECT_PORT=8080
ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
EXPOSE $ELSIE_DEETECT_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "elsie-deetectjar"]
