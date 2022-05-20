# Electricity Billing System #

__Objectives__


The main objective of the Electricity Billing System is to manage the details of electricity, bill, connections, store record, customer. It manages all the information about electricity, customer. The project is totally built at administrative end and thus only the administrator is guaranteed the access. The purpose of the project is to build an application program to reduce the manual work for managing the Electricity, Bill.


__Requirements__

---
For building and running the application you need:
* JDK 11
* PgAdmin4

__Running this application locally__

---
Firstly you should `create a database` from your PgAdmin4 and `set url, username and password to properties`. \
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `kz.iitu.itse1905.damir.rest_electricity_billing_system.RestElectricityBillingSystemApplication` class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:
`mvn spring-boot:run`

__Testing the application__

---
For testing an application you need: import postman collections to your postman from the `resources.postman_collections`. 
