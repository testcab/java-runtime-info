FROM openjdk:8-jdk AS build

WORKDIR /src
COPY JavaRuntimeInfo.java /src
RUN javac JavaRuntimeInfo.java


FROM openjdk:8-jre
WORKDIR /app
COPY --from=build /src/JavaRuntimeInfo.class /app
CMD ["java", "JavaRuntimeInfo"]
