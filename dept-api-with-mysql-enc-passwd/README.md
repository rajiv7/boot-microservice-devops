# dept-api-with-mysql-enc-passwd
A simple springboot microservice with MySQL as database and password for database is encrypted in jdbc

# when using external configuration
java -Dspring.profiles.active=uat -jar target\dept-api-with-mysql-enc-passwd-1.0-SNAPSHOT.jar --spring.config.additional-location=file:///D:/git-repo/app-config.properties