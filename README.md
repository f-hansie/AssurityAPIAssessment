## Project:
Assurity_api_assessment [Get request = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false]

# Acceptance Criteria:
Name = "Carbon credits"
CanRelist = true
The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"



## Installation or Tools needed to execute the test:
-> rest assured ver 4.3.3 or latest
-> java jdk version 11
-> maven apache 3.7.0
-> IntelliJ IDE

## Usage:

- > clone the project from https://github.com/f-hansie/AssurityAPIAssessment.git
- > the test class to execute is located on this path: **src/test/java/TestRunner/CucumberRunnerTest.java**
- > To run the test, please run the command on command line : [mvn clean install] 
- > Once the test has finished, expand the target folder and expand the cucumber-report-html sub folder then right click on overview-feature.html and open with chrome browser or any browser of your choice to view a detailed html report for all the steps that passed.


