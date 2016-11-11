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
    * http://localhost:8080/select/find : to test retrieve data by using @Query

### Build and run
* 更改Tomcat端口
	Run Configurtions : VM Arguments : -Dserver.port=8081
	mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=8081'
	或： set server.port as system property using command line option to jvm --server.port=8090 or add application.properties in /src/main/resources/ with server.port = 8081
	或：random port: server.port=0 (port info can be gotten with @Value("${local.server.port}"))
	REF: http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-change-the-http-port
	

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


#### Testing
* Unit Testing
	MockMvc in spring-test-***.RELEASE.jar,add the following dependency in pom.xml
		<dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-test</artifactId>
	        <scope>test</scope>
	    </dependency>

* 编写单元测试：
	REF1: 下面的链接中提供了Spring书写单元测试的一个模板：
		http://spring.io/guides/tutorials/bookmarks/ ( rest/src/test/java/bookmarks/BookmarkRestControllerTest.java)
	REF2: 下面链接解决了HAL+JSON的问题 (HAL=Hypertext<Hypermedia> Application Language)
		http://stackoverflow.com/questions/29261836/spring-data-rest-content-type (for: HAL + JSON)
* 编写单元测试的两个不同类：springjunit4classrunner + springrunner 
	SpringRunner(Since 4.3 + JUnit 4.12) is an alias for the SpringJUnit4ClassRunner，SpringJUnit4ClassRunner(since 2.5) is a custom extension of JUnit

#### Git Hub Branch Usage#####
1、配置上游项目地址。即将你 fork 的项目的地址给配置到自己的项目上。比如我 fork 了一个项目，原项目是 wabish/fork-demo.git，我的项目就是 cobish/fork-demo.git。使用以下命令来配置。
git remote add upstream https://github.com/netgloo/spring-boot-samples.git
git remote / git remote -v
	origin  https://github.com/super211/spring-boot-samples.git (fetch)
	origin  https://github.com/super211/spring-boot-samples.git (push)
	upstream        https://github.com/netgloo/spring-boot-samples.git (fetch)
	upstream        https://github.com/netgloo/spring-boot-samples.git (push)

然后可以查看一下配置状况，很好，上游项目的地址已经被加进来了。
git remote -v
origin  git@github.com:cobish/fork-demo.git (fetch)
origin  git@github.com:cobish/fork-demo.git (push)
upstream    https://github.com/wabish/fork-demo.git (fetch)
upstream    https://github.com/wabish/fork-demo.git (push)

2、建立分支
git checkout master  //切换回主干
git checkout -b super211 //新建分支并切换过去 = git branch super211//新建分支  + git checkout super211 //切换分支

3、查看分支
git branch --list

4、提交代码
git config user.email "lgp211.reg@gmail.com"
git push origin super211


5、合并分支
git merge super211    //合并分支super211到master

6、删掉分支
git branch -d super211

--2、获取上游项目更新。使用 fetch 命令更新，fetch 后会被存储在一个本地分支 upstream/master 上。
git fetch upstream

--3、合并到本地分支。切换到 master 分支，合并 upstream/master 分支。
git merge upstream/master

--4、提交推送。根据自己情况提交推送自己项目的代码。
git push origin master


#### Bug Fixing #####
* Unable to create a Configuration, because no Bean Validation provider could be found. Add a provider like Hibernate Validator (RI) to your classpath
  *Add:
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-validator</artifactId>
	    <version>5.2.4.Final</version>
	</dependency>

