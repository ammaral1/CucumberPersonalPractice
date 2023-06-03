package APIMuassom;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIExample {

    String BaseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyNjcwNTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTMxMDI1MSwidXNlcklkIjoiNTM2NyJ9.-35MS6Lqb2p2eIA6IFByLj77PpJ-d6YtRzukksVp_co";
    @Test
    public void createAnEmployee(){
       RequestSpecification preparedRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "  \"emp_firstname\": \"Mo\",\n" +
                "  \"emp_lastname\": \"Al\",\n" +
                "  \"emp_middle_name\": \"a\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-05-13\",\n" +
                "  \"emp_status\": \"fulltime\",\n" +
                "  \"emp_job_title\": \"Labour\"\n" +
                "}");

       Response response= preparedRequest.when().post("/createEmployee.php");

       response.prettyPrint();

       response.then().assertThat().statusCode(201);

       String actualValue=response.jsonPath().getString("Message");
        System.out.println(actualValue);

        Assert.assertEquals("Employee Created",actualValue);

        //verify that emp_job_title is "Labour"

        String actualValue2=response.jsonPath().getString("Employee.emp_job_title");
        System.out.println(actualValue2);

        String expected2="Labour";

        //1st and easier option for verification

       Assert.assertEquals(expected2,actualValue2);

        //2nd option verification

        response.then().assertThat().body("Employee.emp_job_title", equalTo("Labour"));





    }
}
