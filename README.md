
Description
-------------------
Priject is to upload a transaction list in CSV file and return relative balance of a particular account up on user request

Output 
-------------------

To Upload CSV File - call http://localhost:8102/uploadCSV and load csv in location mentioned in applicaiton.property file
variable -csv.location

Call URL -http://localhost:8102/balance/ACC334455/20-10-20182012:00:00/20-10-2018%2019:00:00
to get relative balance and number of transaction for account ACC334455 and dates between 20-10-20182012:00:00 and
20-10-2018%2019:00:00

Result -  Balance is -25.0 Number of transaction 1


How To Run Application
-----------------------
Application is built using Spring boot and deployed as a service using internal tomcat server.
Artifact is an executable jar and it can be run by directly executing jar file using java -jar

Technologies Used
-----------------------
Springboot - for Spring Framework
Java 8 - built in java and  used java8 features For handling collections

Web Layer
------------------
REST APIs are used using spring controllers to receive data from UI/ Currently UI is not built, so it can be accessed through Browsers/CURL/POSTMAN server
This layer communicates with service layer for business logic/repository access.

Service Layer
------------------
  Gets requests from controller layer and interacts with business layers to get relative balance .
  It selects Business strategy to be executed for uploading CSV files
Buisness Layer
----------------
Business Layer implements all business logic to handle relative balance and transactions.

Design pattern 
----------------
Used Singleton pattern for creating objects while uploading CSV file. Only one instance will be maintained of this application and subsequent uploads will change existing object.

Testing
---------------
Junit test cases are incorporated .

Scenario : Upload File - workflow
------------------------

User selects http://localhost:8102/uploadCSV in browser, and it calls controller class
Controller calls service layer.
Service layer selects CSV Reader from util and location of CSV file will be mentioned in application.properties
Service layer will select business strategy by mapping relevant model to CSV
Third party vendor Opencsv will generate bean objects using the strategy
All transaction bean objects will be stored ina a singleton object called Transaction manager

Scenario: Get relative balabnce and umber of transactions
------------------------------

user selects http://localhost:8102/balance/ACC334455/20-10-20182012:00:00/20-10-2018%2019:00:00
to get relative balance and number of transaction for account ACC334455 and dates between 20-10-20182012:00:00 and
20-10-2018%2019:00:00 and it calls controller class
Controller calls service layer.
Service layer will call business log calculator by passing relevant arguements.
and result will be returned to controller




