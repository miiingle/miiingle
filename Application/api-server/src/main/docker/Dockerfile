FROM gcr.io/google_appengine/openjdk
VOLUME /tmp
ADD api-server-0.0.1-SNAPSHOT.jar app.jar
CMD [ "java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]