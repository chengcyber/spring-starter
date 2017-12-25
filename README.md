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

