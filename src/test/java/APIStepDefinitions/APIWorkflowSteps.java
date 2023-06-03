package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class APIWorkflowSteps {
    String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    RequestSpecification request;
    Response response;
    public static String employee_id;

    // request for create employee using regular payload
    @Given("a request is prepared to create and employee")
    public void a_request_is_prepared_to_create_and_employee() {
        request = given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE, APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayload());


    }

    //----------------------------------------------------
    // request for create employee using json payload
    @Given("a request is prepared to create and employee using jason payload")
    public void a_request_is_prepared_to_create_and_employee_using_jason_payload() {
        request = given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE, APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayloadJson());
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee us {int}")
    public void the_status_code_for_creating_an_employee_us(Integer int1) {
        response.prettyPrint();
        response.then().assertThat().statusCode(int1);

    }

    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String message, String value) {

        response.then().assertThat().body(message, equalTo(value));

    }

    @Then("the employee id {string} is stored as global variable to be used later in future requests")
    public void the_employee_id_is_stored_as_global_variable_to_be_used_later_in_future_requests(String string) {

        //storing the employee id in global variable
        employee_id = response.jsonPath().getString(string);
        System.out.println(employee_id);

    }
    //---------------------------------------------------------------------------

    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_the_created_employee() {
        request = given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE, APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).queryParam("employee_id", employee_id);
    }

    @When("a GET call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code of this employee is {int}")
    public void the_status_code_of_this_employee_is(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }

    @Then("the employee id we get from key {string} must match the globally stored employee id")
    public void the_employee_id_we_get_from_key_must_match_the_globally_stored_employee_id(String string) {
        String TemEmID = response.jsonPath().getString(string);
        Assert.assertEquals(employee_id, TemEmID);
    }

    @Then("retrieved data from {string} object matches the data from created employee")
    public void retrieved_data_from_object_matches_the_data_from_created_employee
            (String empObject, io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> expectedData=dataTable.asMaps();

        Map<String, String> actualData=response.body().jsonPath().get(empObject);

        for (Map<String, String> map:expectedData){
            Set<String> keys=map.keySet();

            for (String key:keys){

                String expectedValue=map.get(key);
                String actualValue=actualData.get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
        }
    }
    //---------------------------------------------------------------------------------------
   // create employee in dynamic way
    @Given("a request is prepared to create and employee in dynamic way {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void a_request_is_prepared_to_create_and_employee_in_dynamic_way(String firstName, String lastName, String middleName, String gender, String birthday, String status, String jobTitle) {
        request=given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE, APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayloadDynamic(firstName, lastName, middleName, gender, birthday, status, jobTitle));



    }

    //----------------------------------------------------
    //updating an employee

    @Given("a request is prepared to update an employee")
    public void a_request_is_prepared_to_update_an_employee() {
        request=given().header(APIConstants.HEADER_KEY_CONTENT_TYPE, APIConstants. HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).
                body(APIPayloadConstants.updateEmployeePayloadJson());

    }
    @When("a PUT call is made to update to update employee")
    public void a_put_call_is_made_to_update_to_update_employee() {
        response=request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code for updating an employee is {int}")
    public void the_status_code_for_updating_an_employee_is(Integer int1) {
        response.then().assertThat().statusCode(int1);

    }


}
