#!/bin/sh
docker build . -t net.miiingle/backend-poc:latest
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 net.miiingle/backend-poc:latest"