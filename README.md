# helloPayaraDocker

**Overview**

Starter Java EE 8 application on Payara and Docker

**Payara Docker Hub Documentation**

https://hub.docker.com/r/payara/server-full

Summary

 - Payara Admin Console
    - http://localhost:4848 
    - username/pwd: admin/admin
 - Hello app
    - http://localhost:8080/Hello/
    - https://localhost:8181/Hello/

# Build

`mvn clean package`

# RUN

`deployOnDocker.sh`

# RESTful API

`curl -XPOST -H "Content-type: application/json" -d "{\"className\":\"Actinopterygii\",\"orderName\":\"Salmoniformes\",\"familyName\":\"Salmoninae\",\"genusName\":\"Hucho\",\"speciesName\":\"taimen\",\"commonName\":\"Siberian taimen\"}" http://localhost:8080/Hello/resources/fish`

`curl -i -XGET http://localhost:8080/Hello/resources/fish/`

`curl -i -XGET http://localhost:8080/Hello/resources/fish/1`

`curl -XPUT -H "Content-type: application/json" -d "{\"className\":\"Actinopterygii\",\"orderName\":\"Salmoniformes\",\"familyName\":\"Salmoninae\",\"genusName\":\"Hucho\",\"speciesName\":\"taimen\",\"commonName\":\"Awesome Siberian taimen\"}" http://localhost:8080/Hello/resources/fish/1`

`curl -i -XDELETE http://localhost:8080/Hello/resources/fish/1`
