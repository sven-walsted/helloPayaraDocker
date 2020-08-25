#!/bin/sh
docker stop helloPayara5 || true
docker rm   helloPayara5 || true
docker run --name helloPayara5 -v ~/eclipse-workspace/Hello/target:/opt/payara/deployments -p 4848:4848 -p 8080:8080 payara/server-full:5.193