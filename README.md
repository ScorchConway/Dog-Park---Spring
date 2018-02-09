Dog Park
Social web application that allows uesrs to check their dogs into/out of a dog park, and see other dogs that are checked in.

Requirements:
This project requires the build tool Maven which can be installed at apache.maven.org.
The pom.xml file in the root folder controls which Spring modules are added to the project.
Those Spring modules should be downloaded automatically if you build the project in Eclipse (I imagine it would work the same with the Intellij IDE, but I have no experience with it). 
This project requires Spring Boot, which requires Java 6 or higher.

This project uses MySql for its database. Check out the following link to get started with MySql:
https://dev.mysql.com/doc/mysql-getting-started/en/
Create your local database with its name, username, and password all set to "dog-park". Spring will create the necessary tables.
The app is configured to run on port 8889, but you can change this in src/main/resources/application.properties.
