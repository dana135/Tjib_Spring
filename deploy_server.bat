
call mvnw clean package -DskipTests
call az extension add --name spring-cloud
call az configure --defaults "group=Tjib"
call az configure --defaults spring-cloud=tjib
call az spring-cloud app deploy -n gateway --jar-path ./target/Tjib-0.0.1-SNAPSHOT.jar
pause