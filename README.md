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


9.[Annotation - Explicit Component Name](https://github.com/kimochg/spring-starter/commit/0f1cdc2629c410d71eb0053d86b04ae059e98927)
  - annotation minimizes the config than xml files
  - setup `context-component-scan` in `applicationContext.xml`
  - @Component annotataion in business code

10.[Annotation - Default Component Name](https://github.com/kimochg/spring-starter/commit/de8bd7d356a1e20cc0e65469ea096ec323ab840c)
  - default bean id is class name in camel case

11.[Annotation - Constructor Injection](https://github.com/kimochg/spring-starter/commit/6047e483a44b8f9c2037f1b3b9313c2e663b0534)
  - Spring will automatically scan our package since we've set up in `applicationContext.xml`
  - `@Component` the Service class
  - `@Autowired` the constructor

12.[Annotation - Setter Injection](https://github.com/kimochg/spring-starter/commit/8958b72b5acfb175fc7c6d568069573755e8e17d)
  - `@Autowired` a setter method inside

13.[Annotation - Method Injection](https://github.com/kimochg/spring-starter/commit/9ad718433ff033ec5369c4796fb002b6769ad6bb)
  - every method can be annotated by `@Autowired` to inject dependency

