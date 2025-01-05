# Reddit UI tests
Coding language = `Java 11`

Build tool = `Maven`

This is a `Cucumber BDD` framework.

## Run all tests either with:
`mvn test -Dcucumber.options="--tags @regression"`

## or:
` ./run_chrome_tests.sh` after making the script executable with `chmod +x run_chrome_tests.sh`


## To run a particular test scenario:
Tag the scenario with @<tag name> and run:

`mvn test -Dcucumber.options="--tags @<tag name>"`

## To view HTML Test reports:
Go to:

`target/default-html-reports/index.html`