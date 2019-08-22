### How to run

```bash
mvn install && mvn compile exec:java -Dexec.mainClass="com.javainuse.MainApp"
```

### Issue
You will see the following error:

```bash
org.apache.camel.FailedToCreateRouteException: Failed to create route route1 at: >>> To[http://ip.jsontest.com] <<< in route: Route(route1)[[From[file:experiments/?noop=true&fileName=in.... because of Failed to resolve endpoint: http://ip.jsontest.com due to: No component found with scheme: http
  at org.apache.camel.model.RouteDefinition.addRoutes(RouteDefinition.java:910)
  at org.apache.camel.model.RouteDefinition.addRoutes(RouteDefinition.java:175)
  at org.apache.camel.impl.DefaultCamelContext.startRoute(DefaultCamelContext.java:778)
  at org.apache.camel.impl.DefaultCamelContext.startRouteDefinitions(DefaultCamelContext.java:2041)
  at org.apache.camel.impl.DefaultCamelContext.doStartCamel(DefaultCamelContext.java:1791)
  at org.apache.camel.impl.DefaultCamelContext.doStart(DefaultCamelContext.java:1665)
  at org.apache.camel.support.ServiceSupport.start(ServiceSupport.java:61)
  at org.apache.camel.impl.DefaultCamelContext.start(DefaultCamelContext.java:1633)
  at com.javainuse.MainApp.main(MainApp.java:16)
  at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
  at java.lang.reflect.Method.invoke(Method.java:498)
  at org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:282)
  at java.lang.Thread.run(Thread.java:748)
Caused by: org.apache.camel.ResolveEndpointFailedException: Failed to resolve endpoint: http://ip.jsontest.com due to: No component found with scheme: http
  at org.apache.camel.impl.DefaultCamelContext.getEndpoint(DefaultCamelContext.java:538)
  at org.apache.camel.util.CamelContextHelper.getMandatoryEndpoint(CamelContextHelper.java:71)
  at org.apache.camel.model.RouteDefinition.resolveEndpoint(RouteDefinition.java:190)
  at org.apache.camel.impl.DefaultRouteContext.resolveEndpoint(DefaultRouteContext.java:106)
  at org.apache.camel.impl.DefaultRouteContext.resolveEndpoint(DefaultRouteContext.java:112)
  at org.apache.camel.model.SendDefinition.resolveEndpoint(SendDefinition.java:61)
  at org.apache.camel.model.SendDefinition.createProcessor(SendDefinition.java:55)
  at org.apache.camel.model.ProcessorDefinition.makeProcessor(ProcessorDefinition.java:499)
  at org.apache.camel.model.ProcessorDefinition.addRoutes(ProcessorDefinition.java:212)
  at org.apache.camel.model.RouteDefinition.addRoutes(RouteDefinition.java:907)
```
