#!/bin/bash
docker stop azurespringapps
docker container rm azurespringapps
docker build -t azurespringapps .
docker run -p 8080:8080 -d --name azurespringapps azurespringapps

