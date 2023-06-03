Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
   #Given  open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    #And close the browser

  @smoke2
  Scenario: Valid Admin login
   #Given  open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And close the browser

  @scenarioOutline
  #Parameterization/Data Driven
  Scenario Outline: Login with multiple credentials using Scenario Outline
    #Given  open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    #And close the browser
  Examples:
    |  username   |    password       |
    |    admin    |   Hum@nhrm123     |
    |    Admin    |   Hum@nhrm123     |
    |    Jason    |   Hum@nhrm123     |

    @dataTable
    Scenario: Login with multiple credentials using data table
      When user enters usename and passwrod and verifies login
        |  username   |    password       |
        |    admin    |   Hum@nhrm123     |
        |    Admin    |   Hum@nhrm123     |
        |    Jason    |   Hum@nhrm123     |

