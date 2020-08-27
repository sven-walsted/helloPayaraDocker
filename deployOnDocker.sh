#!/bin/sh
######################################################################               
# This script creates a deployment directory, copies the current
# application's build WAR file into the directory, and mounts that
# directory to the running Docker instance's Payara deployment
# directory.
#
# The Docker instance exposes ports 4848, 8080 to the localhost
######################################################################
rm -Rf ./DEPLOY
mkdir ./DEPLOY
cp ./target/Hello.war ./DEPLOY
docker stop helloPayara5 || true
docker rm   helloPayara5 || true
docker run --name helloPayara5 -v $PWD/DEPLOY:/opt/payara/deployments -p 4848:4848 -p 8080:8080 payara/server-full:5.193
