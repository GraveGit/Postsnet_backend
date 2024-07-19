FROM openjdk:17-jdk-slim
COPY ./src/main/java/org/postsnet /tmp
WORKDIR /tmp
ENTRYPOINT ["java","postsnet"]