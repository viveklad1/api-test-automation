# api-test-automation

This Application we can use for REST API automation testing. We can run this application manually as well as we can set in scheduler. So in can run periodically and provide the result as well as send alert in case of any endpoint is down.
 
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run an application on your local machine. One way is to run the cucumber test case, just right click on feature file and select run option.

## Test Case Introduction
I have covered all the end point to test rest end point in BDD manner.  
```mvn
mvn test
```

## DockerFile 

[DockerFile url](https://github.com/viveklad1/pokemon-shakespeare-description/blob/develop/Dockerfile) for reference 

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.