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


## Test

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

## Rest End Point Example

```
## This will give all the shoes whose brand is spark and canvas and price is greater than 2000 

http://localhost:8080/product?search=brand:spark;canvas,price>2000,category:shoes

# Get supploer list
http://localhost:8080/supplier

# Get supploer by supplier name
http://localhost:8080/supplier?search=name:MK

#Get spark shoes from supplier 1
http://localhost:8080/product?search=brand:spark,supplier.id:1


```


## Author

`Ankit Patwa`
