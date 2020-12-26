FROM oracle/graalvm-ce:20.3.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/backend-poc
WORKDIR /home/app/backend-poc

RUN native-image --no-server -cp build/libs/backend-poc-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/backend-poc/backend-poc /app/backend-poc
ENTRYPOINT ["/app/backend-poc"]