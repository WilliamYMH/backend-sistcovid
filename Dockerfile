ARG BUILD_IMAGE=gradle:6.7.1-jdk8
ARG RUNTIME_IMAGE=openjdk:8-jdk-slim

FROM ${BUILD_IMAGE} as dependencies
ENV APP_HOME=/
WORKDIR $APP_HOME

COPY build.gradle settings.gradle $APP_HOME
ADD src $APP_HOME/src
RUN gradle build

FROM ${RUNTIME_IMAGE}
ENV ARTIFACT_NAME=*.jar

EXPOSE 8080

COPY --from=dependencies /build/libs/$ARTIFACT_NAME /app/test.jar
CMD ["java", "-jar", "/app/test.jar"]