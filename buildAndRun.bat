@echo off
call mvn clean package
call docker build -t sample/ejbnewtx .
call docker rm -f ejbnewtx
call docker run -d -p 9080:9080 -p 9443:9443 --name ejbnewtx sample/ejbnewtx