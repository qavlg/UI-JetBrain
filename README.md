# UI automation test-cases for the [JetBrains' website](https://www.jetbrains.com/)
## Manual test-cases are stored [HERE](https://docs.google.com/spreadsheets/d/1cGUj2p6rsdgDBQo1g80onMn9GOgmo-8SEa8Jk7QUp7g/edit?usp=sharing)

These test-cases checks the ...
There are twenty tests in this project.

The project uses 11 Java version.

In order to run the ALL tests is necessary input a command into the terminal:
- **./mvnw clean test**  OR **mvn clean test**

In order to run one of the test's class(such tests for the pages as the Main page, the RegistrationForm page etc.) is necessary input a command into the terminal:
- **./mvnw clean test -Dtest=<Input the name of the test's class>**

  For instance: **./mvnw clean test -Dtest=RegistrationFromTest**

In order to run Allure is necessary input a command into the terminal:
- **./mvnw allure:serve** OR **mvn allure:serve**
  
