# Spring-Cloud-GCP-Microservices-Starter
This template will help you get started using micro-services built on top of Spring in Spring Cloud GCP along with logging capabilities using GCP cloud trace.

Preferred JDK version >= 1.8
Steps to use Spring Boot microservices using Spring Cloud GCP (for more clarity please refer the images below):

Step 1: Go to Spring Initializer website i.e. https://start.spring.io/. Choose the 
configurations and dependencies according to the project requirements.



Step 2: Make sure you have chosen “GCP Support” as one the dependencies in your 
Project.


Step 3: Generate, download(will be downloaded automatically), extract (if necessary, 
depends on the IDE), open the project in your favorite IDE.

Step 4: Add the cloud spanner dependency in the pom.xml file under the project folder.
<dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>spring-cloud-gcp-starter-data-spanner</artifactId>
</dependency>



Step 5: Add the following dependency under dependencyManagement(inside pom.xml)(if it is not present 
there already):

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-gcp-starter-trace</artifactId>
<version>3.2.1</version>
</dependency>




Step 6: Add the cloud spanner friendly Spring notations. In application.properties file under resources, 
you can add spanner instance id and database. Use prebuilt @RepositoryRestResource to mimic the 
behaviour of REST APIs. Your application.properties file should look like this:

spring.cloud.gcp.spanner.instance-id=sample
spring.cloud.gcp.spanner.database=demo

Step 7: Your main java file should look like this:


part-1



part-2

Step 8: Run your Spring boot application.


Setting up logging using Spring Cloud GCP:

Note: Make sure you have completed all the previous steps.

Step 1: Add the following dependency into the pom.xml under 
dependencyManagement:
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-gcp-starter-logging -->
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-gcp-starter-logging</artifactId>
<version>1.0.0.M3</version>
</dependency>

Step 2: Add the following piece of code into {Project 
Name}>src>resources>logback-spring.xml :

<configuration>
<include resource="org/springframework/boot/logging/logback/defaults.xml" />
<include resource="org/springframework/boot/logging/logback/console-appender.xml" />

<springProfile name="logging-json">
<include resource="org/springframework/cloud/gcp/logging/logback-json-appender.xml"/>
<root level="INFO">
<appender-ref ref="CONSOLE_JSON"/>
</root>
</springProfile>
<springProfile name="logging-api">
<include resource="org/springframework/cloud/gcp/logging/logback-appender.xml"/>
<root level="INFO">
<appender-ref ref="STACKDRIVER"/>
</root>
</springProfile>
<springProfile name="logging-console | default">
<root level="INFO">
<appender-ref ref="CONSOLE"/>
</root>
</springProfile>
</configuration>

Step 3: Log into your GCP account and you should see the logs coming into cloud 
stack-trace.


![bloggcprunningapp](https://user-images.githubusercontent.com/84703155/167071468-b23478cd-5ad4-4bb2-8253-0705d03bc4a0.png)
![bloggcpdependencies1](https://user-images.githubusercontent.com/84703155/167071494-6ef0ac56-df54-409d-91f8-c3a17afb453b.png)
![bloggcpdependicies2](https://user-images.githubusercontent.com/84703155/167071511-c1a14ac1-55b0-43d0-a616-181899524c39.png)
![bloggcpmaincode1](https://user-images.githubusercontent.com/84703155/167071522-ce42cb7d-fb01-4f9f-b01d-7ec01c8d5b3b.png)
![bloggcpmaincode2](https://user-images.githubusercontent.com/84703155/167071545-7dfc011e-90cb-4265-b0e2-b77b6f5880bb.png)


Make sure stackdriver is installed (if not please refer the image below)
![Screenshot from 2022-05-05 22-25-31](https://user-images.githubusercontent.com/84703155/167071574-5ee2db5c-0511-41b0-8291-d3a1fe1a34e4.png)

for logging visit this page [cloud storage> monitoring in your GCP Console] (this is sample page and you will see this page if the stackdriver is not installed or logging has not been setup yet, result will be different in your case)
![Screenshot from 2022-05-05 22-25-51](https://user-images.githubusercontent.com/84703155/167071582-7017b3dd-0f79-47c6-ac17-e224cad78cad.png)
