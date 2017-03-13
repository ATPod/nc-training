# nc-training
nc training

Before start working check that following tools are present on your environment:
- Java version "1.8" http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Maven https://maven.apache.org/download.cgi
- Git https://git-scm.com/downloads or https://git-for-windows.github.io/

1. Clone the repository:
 >git clone https://github.com/ATPod/nc-training.git

2. Change directory to nc-training directory:
 >cd nc-training

3. To start your/new maven module use the following command:
mvn archetype:generate -DgroupId=by.training.nc.dev5 -DartifactId=YourPrefix-Module-Name -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

To avoid name collision use your initial prefix for instance the prefix for Ivan Petrov is IP

4. To add you module for version tracking use the command:
  >git add YourPrefix-Module-Name

  Don't forget that only source code should be put into repository versioning

5. To commit your changes in local repository use:
  >git commit -m "initial Commit of YourPrefix-Module-Name"

6. To share your changes to remote repository:
  >git push origin master


To name you package please see Java Package Naming:
http://www.oracle.com/technetwork/java/codeconventions-135099.html

Set up database.

1. Install MySql server https://dev.mysql.com/downloads/installer/
2. After the setup run MySQL Workbench
3. From \nc-training\DAO\sql open init_db.sql and execute the script
   It creates employees db
4. Now you can run App and see list of all employee from the db