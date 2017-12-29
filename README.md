# Setup

1. download Eclipsed Jave EE distrubition from `http://www.eclipse.org/`
2. download lastest release of Spring libs from `http://repo.spring.io/release/org/springframework/spring/`
3. download tomcat from `http://tomcat.apache.org/`

- link local tomcat server in Eclipse at `server` tab
- add Spring libraries JAR to your project

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
- manually paste lastest Spring libraries to `WebContent/WEB-INF/lib`
- manually paste additional libraries to `WebContent/WEB-INF/lib`
  - commons-logging-1.2.jar
  - javax.servlet.jsp.jtl-1.2.1.jar
  - javax.servlet.jsp.jstl-api-1.2.1.jar
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


