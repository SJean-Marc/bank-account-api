# Bank account kata

## Description
Deposit and Withdrawal
Account statement (date, amount, balance)
Statement printing

##  Acceptance Criteria
- A client can make a deposit and a withdrawal
- Account statement should be printed with date, amount and balance

## Run the application 
mvn spring-boot:run

## Access to the swagger (in order to test the API)
http://localhost:8080/swagger-ui/index.html

## Run the test
mvn test

## Improvements
- Integration test with h2 database are running in the test phase.
Only for the purpuse of the test, in later versions another phase should be created to run the integration tests.
- The API is not secured, it should be secured with JWT or another security mechanism.
## Roles and Users not included in this version
As not define in the requirements, the roles and users are not included in this version of the API.
The API is supposed to be used by a single user with full access to all the resources.

