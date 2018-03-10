# Polling H2 DB

This project is inspired by [the article](https://examples.javacodegeeks.com/enterprise-java/spring/integration/spring-integration-database-polling-example/)

On startup schema is created and the table is populated:
```
2018-03-09 15:46:03.186  INFO 4908 --- [           main] o.s.j.d.e.EmbeddedDatabaseFactory        : Starting embedded database: url='jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false', username='sa'
2018-03-09 15:46:03.265  INFO 4908 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from URL [file:/C:/Users/senya/source/spring-tinkering/db-polling/target/classes/schema.sql]
2018-03-09 15:46:03.272  INFO 4908 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executed SQL script from URL [file:/C:/Users/senya/source/spring-tinkering/db-polling/target/classes/schema.sql] in 7 ms.
2018-03-09 15:46:03.273  INFO 4908 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from URL [file:/C:/Users/senya/source/spring-tinkering/db-polling/target/classes/data.sql]
2018-03-09 15:46:03.297  INFO 4908 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executed SQL script from URL [file:/C:/Users/senya/source/spring-tinkering/db-polling/target/classes/data.sql] in 24 ms.
```
To access H2 console via the web, point your browser to: (http://localhost:8080/h2-console/)
![](https://github.com/excelsiorsoft/spring-tinkering/blob/master/db-polling/h2-console.PNG)

Important: JDBC URL string should correspond to what's seen in the above logs via internal Spring Boot configuration: 

**jdbc:h2:mem:testdb**

Querying the table returns: 
![](https://github.com/excelsiorsoft/spring-tinkering/blob/master/db-polling/query.PNG)

For an *OLD* way of configuring Spring Integration in Spring Boot, see [DbpollerApplication.java](https://github.com/excelsiorsoft/spring-tinkering/blob/master/db-polling/src/main/java/com/example/DbpollerApplication.java)

*NEW* way of doing it, see  [DBSimplepollerApplication.java](https://github.com/excelsiorsoft/spring-tinkering/blob/master/db-polling/src/main/java/com/example/DBSimplepollerApplication.java)


