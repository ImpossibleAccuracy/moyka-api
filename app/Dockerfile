FROM gradle:jdk21

ENV BUILD_PATH=/usr/build

USER root
WORKDIR $BUILD_PATH

COPY gradle.properties .
COPY gradle/ gradle/

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY app/ app/

RUN gradle clean :app:buildFatJar

EXPOSE $PORT

ENTRYPOINT exec java -jar app/build/libs/app-all.jar