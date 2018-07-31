# Setup

1. download Eclipsed Jave EE distrubition from `http://www.eclipse.org/`
2. download Java SE JDK `http://www.oracle.com/technetwork/java/javase/overview/index.html`
3. download lastest release of Spring libs from `http://repo.spring.io/release/org/springframework/spring/`
4. download tomcat from `http://tomcat.apache.org/`

- link local tomcat server in Eclipse at `server` tab
- Eclipse - Window - Perspective - Open Perspective - Java
- add Spring libraries JAR to your project
  - Copy Spring /libs/xxx.jar to project /lib folder
  - Project Properties - Java Build Path - Libraries - Add JARs - add all of them

# spring-demo-1

1.[Basic JAVA app](https://github.com/kimochg/spring-starter/commit/13a77f1ec6ae1ea72b3ca55f005ab94a82a12d22)

2.[Basic Spring app](https://github.com/kimochg/spring-starter/commit/9274ead07d7a547055f8198bb8865d8369495cc7)
  - config in `applicationContext.xml`
  - remember import springframework JARs b/c ClassPathXmlApplicationContext is essentail here

3.[Dependency Injection - Constructor Injection](https://github.com/kimochg/spring-starter/commit/27b815378c1c192cdfc176cbded2377d45367738)
  - update service bean in `applicationContext.xml`
  - setup constructor injection in `applicationContext.xml`

4.[Dependency Injection - Setter Injection](https://github.com/kimochg/spring-starter/commit/548824fe49278071dde0824fe71eb7d28ed445d5)
  - setup setter injection in `applicationContext.xml`
  - convention: invoke set + property name(capital case) method

5.[Dependency Injection - Literal Value Injection](https://github.com/kimochg/spring-starter/commit/f1199e21dc38bad09988ced7b1ec2b1ab13cc605)
  - setup literal value injection in `applicationContext.xml`
  - value attribute in property tag will be injected when invoking set + property name method

6.[Literal Value Injection in Another Properties File](https://github.com/kimochg/spring-starter/commit/99af760c83ff0ec1cb03fd3e8bdb3bea524e195c)
  - make literal values maintainable in one single file

7.[Bean Scope](https://github.com/kimochg/spring-starter/commit/a36c7958c562a557d5ef39dd020fab8d7570ffe9)
  - default bean scope is singleton, i.e. application container always returns same instance. - **stateless object**
  - set `scope="prototype"` in `beanScope-applicaitonContext.xml` file, thus different instances returned. - **stateful object**

8.[Bean Lifecycle Methods](https://github.com/kimochg/spring-starter/commit/b74ca4607cde26124d614b3882459c480077152d)
  - Convention:
    - The methods should be public void
    - The methods should be no-arg, meaning they shouldn't accept any method arguments
  - Life Cycle:
    1. Container started
    2. Bean instantiated
    3. Dependencies Injected
    4. Internal Spring Processing
    5. **Your Custom Init Method**
    6. Bean Is Already For Use
    7. Container Is Shut Down
    8. **Your Custom Destroy Method**
    9. STOP
  - Cavet:

  >  Spring does not manage the complete lifecycle of a `prototype` bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance. Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.
    ---
    This also applies to both XML configuration and Annotation-based configuration.

# spring-demo-anotations

- Spring libraries
- javax.annotation-api-1.3.1.jar
- applicationContext.xml

copy from last demo or search internet

1.[Annotation - Explicit Component Name](https://github.com/kimochg/spring-starter/commit/0f1cdc2629c410d71eb0053d86b04ae059e98927)
  - annotation minimizes the config than xml files
  - setup `context-component-scan` in `applicationContext.xml`
  - @Component annotataion in business code

2.[Annotation - Default Component Name](https://github.com/kimochg/spring-starter/commit/de8bd7d356a1e20cc0e65469ea096ec323ab840c)
  - default bean id is class name in camel case

3.[Annotation - Constructor Injection](https://github.com/kimochg/spring-starter/commit/6047e483a44b8f9c2037f1b3b9313c2e663b0534)
  - Spring will automatically scan our package since we've set up in `applicationContext.xml`
  - `@Component` the Service class
  - `@Autowired` the constructor

4.[Annotation - Setter Injection](https://github.com/kimochg/spring-starter/commit/8958b72b5acfb175fc7c6d568069573755e8e17d)
  - `@Autowired` a setter method inside

5.[Annotation - Method Injection](https://github.com/kimochg/spring-starter/commit/9ad718433ff033ec5369c4796fb002b6769ad6bb)
  - every method can be annotated by `@Autowired` to inject dependency

6.[Annotation - Field Injection](https://github.com/kimochg/spring-starter/commit/feb0a73c199b4edce1d93208e991cdff943d5cb1)
  - apply directly to a field
  - no need setter method for the field

7.[Annotation - Qualifier](https://github.com/kimochg/spring-starter/commit/f8fc5710cb1c33e72f35e3c48d3fcda21dd2c954)
  - multiple Services implement same Interface
  - decide which one to inject via `Qualifier`
  - Cavet:

> the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.
> RESTFortuneService --> RESTFortuneService
> Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name. Here's a screenshot of the documentation for the key method.
> [Java Beans Introspector](https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize-java.lang.String-)

8.[Annotation - Literal Value Injection](https://github.com/kimochg/spring-starter/commit/10b96fdc6796b186742b1ada14c72042aba19aec)
  - set up `context:property-placeholder` in `applicationContext.xml`
  - `@Value(${})`

9.[Annotation - Bean Scope - Singleton](https://github.com/kimochg/spring-starter/commit/c7bf795ac687d3776cb36e8050bab3cf261446f7)
  - default bean scope is singleton
  - same as `@Scope("singleton")`

10.[Annotation - Bean Scope - Prototype](https://github.com/kimochg/spring-starter/commit/66d902cb3f6f73b689c00c8bc534fdb644800c54)
  - Spring Container returns different beans

11.[Annotation - Bean Life Cycle Methods](https://github.com/kimochg/spring-starter/commit/a4f821926efecfd7d07ba34d2bea7904a79a5cdb)
  - `@PostConstruct` as init-method
  - `@PreDestroy` as destroy-method
  - remember prototype bean won't invoke destroy-method, b/c bean doesn't record prototype beans
  - javax.annotation in not default included in JAVA 9

  > NOTICE if got errors when using `@PostConstruct` and `@PreDestroy`
  > Java >= 9, javax.annotation has been removed from its default classpath.
  > Download the [javax.annotation-api-1.2.jar](http://central.maven.org/maven2/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar) and add it to your project as for the Spring jar files

12.[Java Source Code Configuration](https://github.com/kimochg/spring-starter/commit/f06630dc7e7d5fb435591e86fde6ef8b6c654a38)
  - Create a Java Class and annotate as `@Configuration`
  - Add component scanning support: `@ComponentScan` (optional)
  - Read Spring Java configuration class
  - Retrieve bean from Spring container

13.[Java Code Config - Inner Defined Bean](https://github.com/kimochg/spring-starter/commit/667c8bb3de81e98595924d1f620e0f23b6ec99dc)
  - define bean inside the Java code configuration

14.[Java Code Config - Load Properties](https://github.com/kimochg/spring-starter/commit/dc31e4d6f6da31cf6b01e93440902223ba724fea)
  - Create Properties File
  - Load Properties File in Spring Config
  - Reference values from Properties File

# spring-mvc-demo

1.[Set up](https://github.com/kimochg/spring-starter/commit/7fea4208ee435acb59ff9d3a91e3ecca8435a023)
- New - Dynamic Web Project
- manually paste lastest [Spring libraries](http://repo.spring.io/release/org/springframework/spring/) to `WebContent/WEB-INF/lib`
- manually paste additional libraries to `WebContent/WEB-INF/lib`
  - commons-logging-1.2.jar
  - [javax.servlet.jsp.jtl-1.2.1.jar](http://central.maven.org/maven2/org/glassfish/web/javax.servlet.jsp.jstl/1.2.1/javax.servlet.jsp.jstl-1.2.1.jar)
  - [javax.servlet.jsp.jstl-api-1.2.1.jar](http://central.maven.org/maven2/javax/servlet/jsp/jstl/javax.servlet.jsp.jstl-api/1.2.1/javax.servlet.jsp.jstl-api-1.2.1.jar)
  - add `javax.servlet.http.HttpServlet` by Project Properties - Java Build Path - Libraries - Add Library... - Server Runtime - Tomcat
- xml configuration files in `WebContent/WEB-INF`
  - spring-mvc-demo-servlet.xml
  - web.xml

configure the Spring Dispatcher Servlet using all Java Code (no xml):
https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-container-config

2.[Spring MVC - Controller & View](https://github.com/kimochg/spring-starter/commit/c99e88afc64270e5f6036ad8c3a55dffb7e535a2)
  - annotate class with `@Controller`
  - `@Controller` inherits from `@Component` ... supports scanning(according to base-package setting)
  - `@Requestmapping("/")` maps a path to a method name
  - the method should return view name which will be assembled with prefix suffix in config
  - finnaly, `Run as Server`

> How to Clean Server Cache:
> stop the tomcat in Server tab, right click the server and select `Clean...`, right click the server again and select `Clean Tomcat Work Directory...`

> How to Clean Eclipse Cache:
> select the top-level menu option, Project -> Clean ..., be sure your project is selected and click OK, restart Eclipse

3.[Spring MVC - Handle Form Data](https://github.com/kimochg/spring-starter/commit/5e9844882046cbf9dfb6a657a75188ff91d87cbe)
  - a tag as hyperlink
  - HTML form action
  - get param from query string

4.[Spring MVC - Add Attribute to Model](https://github.com/kimochg/spring-starter/commit/2c57a39c28ad7bc3933d507fc11472ce471a31b6)
  - `model.addAttribute("foo", obj/string/...)` in controller method
  - `${foo}` in view jsp file

## Bouns:

- [config assets resource in Spring](https://gist.github.com/darbyluv2code/9a09543a226baeedc04b9a5037ca52ec)
- Deploy app to Tomcat as a Web Application Archive(WAR) file
  1. stop tomcat in Eclipse
  2. Right Click project, and select Export > WAR file
  3. input a file name, 'myapp.war' for example
  4. start tomcat outside of Eclipse
  5. move the new WAR file to /path/install/tomcat/webapps/
  6. visit `http://localhost:8080/myapp`

5.[Spring MVC - Annotation RequestParam](https://github.com/kimochg/spring-starter/commit/47c8048621b0a3c7b172fd32a4967a8da88013ca)
  - `@RequestParam("foo") String bar` parse the `foo` value in queryString and evalute it to `bar`

6.[Spring MVC - Annotation Request Parent Mapping](https://github.com/kimochg/spring-starter/commit/53c5e4e24162a6aea71cc7554166d65d7558920d)
  - Annotate the Controller with `@RequestMapping` gives a route scope, resolving ambiguous mapping

7.[Spring MVC - Form Tag](https://github.com/kimochg/spring-starter/commit/af2d7b3fe7a853864dabdf4be1f18b0f3158652e)
  - [Official Doc](https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/spring-form-tld.html#spring-form.tld.form)
  - visit `localhost:8080/spring-mvc-demo/student/showForm`

8.[Spring MVC - Form Select Tag](https://github.com/kimochg/spring-starter/commit/7e63f2c08b0f54b8e631fbae5898ed3d59a0989f)
  - hard code options in JSP

9.[Spring MVC - Form Options Tag](https://github.com/kimochg/spring-starter/commit/ea12b56f3275d0aea674f46fefb8108405157732)
  - read data from model layer
  - use it in view layer

10.[Spring MVC - Literal Value Injection](https://github.com/kimochg/spring-starter/commit/60693b457ecfb7bd238b18939b7660461c08560d)
  - set up `context.xml` header
  - `util:properties`

11.[Spring MVC - Form Radiobutton Tag](https://github.com/kimochg/spring-starter/commit/adccddb6015e15283efd6b47b55e246d7b5399c4)

12.[Spring MVC - Form Checkbox Tag](https://github.com/kimochg/spring-starter/commit/7f95f75717f5af67788e7ae66a3b9390362cac19)


## Spring MVC - Form Validation

set up our development environment
  - download hibernate-validation JAR from `http://hibernate.org/validator/releases/6.0/`
  - copy dist/xxx.jar and dist/lib/required/xxx.jar to /WEB-INF/lib

1.[required field](https://github.com/kimochg/spring-starter/commit/512ac0434fd6340231f8fe84bf8963736cfa28e7)
  - Add validation rule to Customer Class
  - Display error messages on HTML form
  - Perform validation in the Controller class
  - Update confirmation page

1.1.[Pre-processing with @InitBinder](https://github.com/kimochg/spring-starter/commit/93f21137ab05e679cedb4579ded0eaca3c3646c7)
  - treat the input only contains whitespaces as invalid

2.[validate number range: min, max](https://github.com/kimochg/spring-starter/commit/85f3c03a5d0f6ea14df0787f5f04d3007aad46f6)

3.[validate using regular expression](https://github.com/kimochg/spring-starter/commit/bf59223363e990140419d7b0ec5ff1d3edcf0727)

4.[validate number as required](https://github.com/kimochg/spring-starter/commit/31137c7a342695bb13ddcae1256f03437d19a749)
  - Convertion Type Issue Int -> String
  - Use `Integer` Type instead of `Int`

5.[handle string input for interger field](https://github.com/kimochg/spring-starter/commit/7511bb680f7a670fdcc6cb07753a726b5807d6e9)
 - Override error code with `messages.properties` file

6.[custom validation](https://github.com/kimochg/spring-starter/commit/256da9bd8bb622a07637692b245f059ee0fa5ece)
  - new package `com.luv2code.springdemo.validation`
  - new annotation `CourseCode`
    - Contraint
    - Target
    - Retention
  - new `CourseCodeConstraintValidator` implements `ConstraintValidator`

# hibernate-tutorial

## Set Up Development Environment

1. [MySQL](https://dev.mysql.com/downloads/mysql/)

  install (remember the temporary password)

```bash
export PATH=$PATH:/usr/local/mysql/bin
sudo /usr/local/mysql/support-files/mysql.server start
mysql -u root -p (input the temporary password)
set password = password('123456');
```

2. Database Table

run the following sql scripts

- /scripts/01-create-user.sql
- /scripts/02-student-tracker.sql

3. [Hibernate ORM](http://hibernate.org/orm/)

copy /lib/required/xxx.jar to /hibernate-tutorial/lib

4. [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

- download platform independent zip file
- copy /mysql-connector-java-x.y.z.jar to /hibernate-tutorial/lib

5. Add JARs

For Java >=9, download the following jar files, since java.xml.bind has been removed

- [javax.activation-1.2.0.jar](http://search.maven.org/remotecontent?filepath=com/sun/activation/javax.activation/1.2.0/javax.activation-1.2.0.jar)
- [jaxb-api-2.3.0.jar](http://search.maven.org/remotecontent?filepath=javax/xml/bind/jaxb-api/2.3.0/jaxb-api-2.3.0.jar)
- [jaxb-core-2.3.0.jar](http://search.maven.org/remotecontent?filepath=com/sun/xml/bind/jaxb-core/2.3.0/jaxb-core-2.3.0.jar)
- [jaxb-impl-2.3.0.jar](http://search.maven.org/remotecontent?filepath=com/sun/xml/bind/jaxb-impl/2.3.0/jaxb-impl-2.3.0.jar)

Project Properties - Java Build Path - Libraries - Add JARs

## [Hibernate Configuration with Annotations](https://github.com/kimochg/spring-starter/commit/8d9c9bf02b330aee4d0287f306013201b3c12bab)

1. Add hibernate configuration file
  - src/hibernate.cfg.xml
2. Annotate Java class
  - @Entity
  - @Table(name="tbl")
  - @Id
  - @Column(name="column")
3. Develop Java code to perform database operations
  - SessionFactory
  - [Read Object via Hibernate](https://github.com/kimochg/spring-starter/commit/12b233311e9b5a286ba4483b577dd6749679c8ab)
  - [Query Object via Hibernate](https://github.com/kimochg/spring-starter/commit/3d4be1b78fbe40a5cbbee8938c2e06ee75dfc4fb)
  - [Update Object via Hibernate](https://github.com/kimochg/spring-starter/commit/51679c05b6fc2c58c89c9524ccb2ea4c1efd4daf)


