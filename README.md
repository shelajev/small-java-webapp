# small-java-webapp
This repository contains a small Java web application



## Running it

```
docker-machine start default


docker run --name xrebel-challenge-app -e POSTGRES_PASSWORD=changeme -d -p 5432:5432 postgres

# stop and remove the
# docker stop xrebel-challenge-app
# docker rm xrebel-challenge-app
