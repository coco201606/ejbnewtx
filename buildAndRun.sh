#!/bin/sh
mvn clean package && docker build -t sample/ejbnewtx .
docker rm -f ejbnewtx || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejbnewtx sample/ejbnewtx