#!/bin/sh
set -ex

mvn clean package -DskipTests
az extension add --name spring-cloud
az configure --defaults group=Tjib
az configure --defaults spring-cloud=tjib
az spring-cloud app deploy -n gateway --jar-path ./target/Tjib-0.0.1-SNAPSHOT.jar
