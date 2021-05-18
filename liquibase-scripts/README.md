## Update database by sql-scripts by liquibase

mvn liquibase:update 
    -Ddb.user.password=user_password 
    -Ddb.user.name=user_name 
    -Ddb.url=jdbc:postgresql://localhost/db_name
