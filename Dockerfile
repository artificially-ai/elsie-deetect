FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git curl

WORKDIR ekholabs

RUN git clone https://github.com/ekholabs/elsie-deetect
WORKDIR elsie-deetect
RUN ./gradlew clean build

ENV ELSIE_DEETECT_PORT=8080

EXPOSE $ELSIE_DEETECT_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "build/libs/elsie-deetect-1.0-SNAPSHOT.jar"]
