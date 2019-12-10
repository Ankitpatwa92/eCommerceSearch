## eCommerceSearch ##

## Version ##
`0.0.1`

## Summary ##
This project provide sample serach feature for all products availble in inventory based on their price category and supplier name etc.

## Getting Started
* [Prerequisite] (#markdown-header-prerequisite)
* [Configuration] (#markdown-header-configuration)
* [Build] (#markdown-header-build)
* [Deploy] (#markdown-header-deploy)
* [Run] (#markdown-header-run)

## Prerequisite
* Git
* jdk 1.8
* Mavean 


## Configuration

---------------------------------------------------------------------------------------------------------------------------------
   Key
---------------------------------------------------------------------------------------------------------------------------------
spring.datasource.url                                    jdbc:h2:mem:sapient
spring.datasource.driverClassName                        org.h2.Driver        
spring.datasource.username=ecom
spring.datasource.password=das8Qfsfd9ak!UK8
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


# temporary data storage
#spring.datasource.url = jdbc:h2:mem:sapient
 
# temporary data storage
#spring.datasource.url = jdbc:h2:file:/data/sample
#spring.datasource.url = jdbc:h2:file:C:/data/sample


# Enabling H2 Console
spring.h2.console.enabled=true
 
# Custom H2 Console URL
spring.h2.console.path=/h2


# Whether to enable trace output.
spring.h2.console.settings.trace=true
 
# Whether to enable remote access.
spring.h2.console.settings.web-allow-others=true


spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
