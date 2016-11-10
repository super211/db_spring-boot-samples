## Use JPA + Hibernate + MySQL in Spring Boot

See here for more informations: 
http://blog.netgloo.com/2014/10/06/spring-boot-data-access-with-jpa-hibernate-and-mysql/

### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/user/save?email=[email]&name=[name]`: create a new user with an 
      auto-generated id and email and name as passed values.
    * `/user/delete?id=[id]`: delete the user with the passed id.
    * `/user/get-by-email?email=[email]`: retrieve the id for the user with the
      passed email address.

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations for the
database connection.

#### Prerequisites

- Java 7
- Maven 3
- mysql-installer-community-5.7.16.0
	1) Install
	2) Set username/password: root/root
	3) Create a new schema(database) with MySQL Workbench: netgloo_blog

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.



#### Bug Fixing #####
* Unable to create a Configuration, because no Bean Validation provider could be found. Add a provider like Hibernate Validator (RI) to your classpath
  *Add:
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-validator</artifactId>
	    <version>5.2.4.Final</version>
	</dependency>

