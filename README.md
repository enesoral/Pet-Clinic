# Spring Pet Clinic Sample Application [![Build Status](https://circleci.com/gh/enesoral/Pet-Clinic.svg?style=svg)](https://circleci.com/gh/enesoral/Pet-Clinic)

## Use cases of the Pet Clinic application 

* View a list of veterinarians and their specialties
* View information pertaining to a pet owner
* Update the information pertaining to a pet owner
* Add a new pet owner to the system
* View information pertaining to a pet
* Update the information pertaining to a pet
* Add a new pet to the system
* View information pertaining to a pet's visitation history
* Add information pertaining to a visit to the pet's visitation history


## Running petclinic locally
Pet Clinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/enesoral/Pet-Clinic
cd Pet-Clinic
./mvnw package
java -jar petclinicweb/target/*.jar
```

You can then access petclinic here: http://localhost:8080/

<img width="1042" alt="petclinic-screenshot1" src="https://user-images.githubusercontent.com/53643180/77225547-1aa20380-6b81-11ea-8b19-3a00801e6096.png">

<img width="1042" alt="petclinic-screenshot2" src="https://user-images.githubusercontent.com/53643180/77225585-71a7d880-6b81-11ea-88ea-fa845b526bf5.png">

## Working with Pet Clinic in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* Your preferred IDE.

## Database configuration

In its default configuration, Pet Clinic uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is automatically exposed at `http://localhost:8080/h2-console`
and it is possible to inspect the content of the database using the `jdbc:h2:mem:testdb` url.
 
You can take a look at [here](https://spring.io/guides/gs/accessing-data-mysql/) for MySql connection.

## In case you find a bug/suggested improvement for Pet Clinic
The [issue tracker](https://github.com/enesoral/Pet-Clinic/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

