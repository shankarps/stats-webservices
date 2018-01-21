[![Build Status](https://travis-ci.org/shankarps/stats-webservices.svg?branch=master)](https://travis-ci.org/shankarps/stats-webservices)

# Statistics webservice

This is a REST based webservice to calculate statistical functions for input values.

## Getting Started

Install Git, Java 8, Maven and any IDE of your choice (Eclipse, IntelliJ, etc)

### Prerequisites

Git, Java 8, Maven should be installed.


### Installing

Check out the source code

```
$git clone https://github.com/shankarps/stats-webservices.git
```

Compile and run the project

```
$mvn clean install spring-boot:run
```
Test the service with a browser or REST client

```
$wget http://localhost:8080/statistics/v1/calculate?values=1,2,3,4,5,6.1,33

```

## Running the tests

TODO


## Deployment

This webservice is ready to use.
This webservice is deployed in the Pivotal Cloud Foundry for usage.

Public URL - http://stats.web-util.com/v1/calculate?values=1,2,3,4,5,6.1,33

## Built With

* [Spring Boot] - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management



## Authors

* **Shankar P** - *Initial work* - [(https://github.com/shankarps)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Inspired by https://github.com/springframeworkguru
* Inspired by Josh Long 
* and many others

