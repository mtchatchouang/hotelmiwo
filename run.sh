#!/bin/bash

mvn clean install

docker build -t centos -f Dockerfile-centos7 .
docker build -t openjdk:8 -f Dockerfile-openjdk8 .
docker build -t jboss/wildfly:10.0.0 -f Dockerfile-wildfly .

docker-compose build

docker-compose up