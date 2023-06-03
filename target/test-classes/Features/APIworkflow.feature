Feature: API workflow for HRMS

Background:
  Given a JWT is generated

  @api
  Scenario: create an employee using API call
    Given a request is prepared to create and employee
    When a POST call is made to create an employee
    Then the status code for creating an employee us 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as global variable to be used later in future requests

  @apijsonworkflow
  Scenario: create an employee using API call
    Given a request is prepared to create and employee using jason payload
    When a POST call is made to create an employee
    Then the status code for creating an employee us 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as global variable to be used later in future requests

  @apijsonworkflow
  Scenario: retrieve an employee using API call
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code of this employee is 200
    Then the employee id we get from key "employee.employee_id" must match the globally stored employee id
    Then retrieved data from "employee" object matches the data from created employee
    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
    |Ali          |kaka        |sa             |Male      |2000-04-21  |PartTime  |Manager      |

  @dynamic
  Scenario: create an employee using API call dynamic way
    Given  a request is prepared to create and employee in dynamic way "Ali", "kaka", "sa", "Male", "2000-04-21", "PartTime", "Manager"
    When a POST call is made to create an employee
    Then the status code for creating an employee us 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as global variable to be used later in future requests

  @updateemployee
  Scenario: updating the employee via API call
    Given a request is prepared to update an employee
    When a PUT call is made to update to update employee
    Then the status code for updating an employee is 200
