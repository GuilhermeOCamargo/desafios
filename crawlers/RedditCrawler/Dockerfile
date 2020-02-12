FROM maven:3.6.3-jdk-11
LABEL maintainer="Guilherme Camargo <guilherme.ocamargo@gmail.com>"

COPY . .
RUN mvn clean install
WORKDIR target

ENTRYPOINT ["java", "-jar", "RedditTelegramBot-jar-with-dependencies.jar"]
