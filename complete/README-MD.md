# Project Title

Online Meeting Room Booking

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Step 1 the Maven installed on the system and set the classpath accordingly

Step 2: Extract the Zip file and paste it into the Eclipse workspace.

Step 3: Import the project folder into Eclipse as Existing Maven project.

File -> Import -> Existing Maven Projects -> Browse -> Select the folder gs-spring-boot -> Finish

It takes some time to import.

### Installing

Build Step 1 :

on the command prompt or on the eclipse you can start build by giving command
 mvn clean -Dmaven.test.skip=true install

 
 Step 2:
 Executing the application 
	$ mvn -q spring-boot:run
	
	OR
	
	Right click on Application.java in the eclipse and click Run As Application. 

	
## Documentation

for getting the apidocs

http://localhost:8080/BookingRooms/swagger-ui.html	

	

## Built With

* [SpringBoot](https://github.com/spring-projects/spring-boot) - The Spring Boot framework used
* [Maven](https://maven.apache.org/) - Dependency Management




