## eCommerceSearch ##

## Version ##
`0.0.1`

## Summary ##
This project provide sample serach feature for all products availble in inventory based on their price category and supplier name etc.

## Getting Started
* [Prerequisite] 
* [Configuration] 
* [Test]
* [Build] 
* [Run] 

## Prerequisite
* Git
* jdk 1.8
* Mavean 


## Configuration


|   Key                                        |                      Value                              |
|----------------------------------------------|---------------------------------------------------------|
| spring.datasource.url                        |                     jdbc:h2:mem:sapient                 |
| spring.datasource.driverClassName            |                    org.h2.Driver                        |
| spring.datasource.username=                  |                     ecom                                |           
| spring.datasource.password                   |                    das8Qfsfd9ak!UK8                     |
| spring.jpa.database-platform                 |                    org.hibernate.dialect.H2Dialect      |
| #spring.datasource.url                       |                    jdbc:h2:mem:sapient                  |
| #spring.datasource.url                       |                    jdbc:h2:file:/data/sample            |
| #spring.datasource.url                       |                    jdbc:h2:file:C:/data/sample          |
| spring.h2.console.enabled                    |                    true                                 |
| spring.h2.console.path                       |                    /h2                                  |
| spring.h2.console.settings.trace             |                    true                                 |
| spring.h2.console.settings.web-allow-others  |              true                                       |
| spring.jpa.show-sql                          |             false                                       |
| spring.jpa.properties.hibernate.format_sql   |            false                                        |


##

```
mvn test
```

## Build

```
mvn clean pacakge
```

## Run

```
java -jar ecommerceSearch.jar
```

##Author

`Ankit Patwa`
