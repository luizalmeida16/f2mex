# f2mex

This project is an API to fetch data from http://challenge.carjump.net/A at n seconds intervals, cache results using the
RLE compression strategy and allows clients to access the data at a given index.

## Installation
Clone this repository and run the following comand:

* mvn install

### Configure n seconds fetch data interval in application.yml
This file can be found in /src/main/resources/config
Change the value of interval parameter

### Run tests
* mvn test

### Start application
* mvn spring-boot:run

## Usage
After that make the requests to the following endpoints:

       Method         |                     Endpoint                
--------------------- | ------------------------------------------------- 
Get data by index     | GET http://localhost:8080/v1/data/fetched/{index}
Get data object       | GET http://localhost:8080/v1/data

## Requirements

* Java 8
* Maven



