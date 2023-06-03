Feature: Add Employee

  @testcase2
  Scenario: Adding a new Employee
    #Given  open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee option
    And user enters firstname and middlename and lastname
    #And user clicks on save button
    #And close the browser

  @scenarioOutlineAddingMultipleEmployees
  Scenario Outline: Adding multiple employee
        #Given  open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee option
    And user enters "<firstname>" and "<middlename>" and "<lastname>"
    #And user clicks on save button
    #And close the browser
  Examples:
    |firstname |middlename |lastname |
    |firstname2|middlename2|lastname2|
    |firstname3|middlename3|lastname3|
    |firstname4|middlename4|lastname4|
    |firstname5|middlename5|lastname5|
    |firstname6|middlename6|lastname6|




