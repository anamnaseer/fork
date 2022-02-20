## Concepts Included

* Page Object pattern
* Common web page interaction methods
* Externalised test configuration
* Commonly used test utility classes

## Tools

* Gradle
* JUnit
* Selenium Webdriver
* allure reporting
* Rest Assured


## Usage

To run selenium test, navigate to directory and run:

`gradle test --tests "com.example.fork.MainPageTest" allureReport`

##### Note: There's a hard wait added on selenium test to solve the captcha manually, while running the script when captcha appears please solve it manually

To run API test, navigate to directory and run:

`gradle test --tests "com.example.fork.ApiTest" `

## Reporting

Reports can be found at `\fork\build\reports\allure-report` directories after each run.

