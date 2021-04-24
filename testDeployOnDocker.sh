#!/bin/sh
######################################################################               
# This script creates a deployment directory, copies the current
# application's build WAR file and Payara's configuration into that 
# directory, and mounts that directory to the running Docker 
# instance.
#
# Note: this Test-instance uses bundled H2 database.
#
# The Docker instance exposes ports 4848, 8080, and 8181 to the
# localhost.
######################################################################
# Environment setup
IMAGE_NAME=payara/server-full:5.193
INSTANCE_NAME=helloTest
PORTS="-p 4848:4848 -p 8080:8080 -p 8181:8181"
DOCKER_DIR=/tmp/DOCKER_HELLO
DEPLOY_DIR=$DOCKER_DIR/deployments
SCRIPTS_DIR=$DOCKER_DIR/scripts
# Commands
rm -Rf $DOCKER_DIR
mkdir -p $DEPLOY_DIR
mkdir -p $SCRIPTS_DIR
cp ./target/Hello.war          $DEPLOY_DIR
cp pwdfile.txt                 $SCRIPTS_DIR
cp preboot.txt                 $SCRIPTS_DIR
cp postboot.txt                $SCRIPTS_DIR
docker stop $INSTANCE_NAME || true
docker rm   $INSTANCE_NAME || true
docker run --name $INSTANCE_NAME --rm -d $PORTS -v $DEPLOY_DIR:/opt/payara/deployments -v $SCRIPTS_DIR:/tmp -e PREBOOT_COMMANDS=/tmp/preboot.txt -e POSTBOOT_COMMANDS=/tmp/postboot.txt $IMAGE_NAME

