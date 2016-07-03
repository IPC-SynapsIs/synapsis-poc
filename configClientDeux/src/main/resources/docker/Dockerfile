
FROM java:8
MAINTAINER Mehdi Alaoui <mehdi.alaoui@capgemini.com>


ADD build/libs/*.jar /app/app.jar
ADD src/main/resources/docker/run.sh /app/

RUN chmod +x /app/app.jar
RUN chmod +x /app/run.sh

EXPOSE 8080


ENTRYPOINT ["bash","run.sh"]

WORKDIR /app