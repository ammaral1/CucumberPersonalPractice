package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedAPI {
    String BaseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxODMwNzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIyNjI3OSwidXNlcklkIjoiNTM2NyJ9.CDAvqhyEoWs2uXXl2AdKuWFMoMnFpl8E_c9a6EVsqws";
    static String employee_id;
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification prepareRequest= given().header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        //hitting the endpoint
        Response response= prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //verify the response for status code
        response.then().assertThat().statusCode(200);
        String tempEmpID=response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id,tempEmpID);
    }
    @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "  \"emp_firstname\": \"Mo\",\n" +
                "  \"emp_lastname\": \"Al\",\n" +
                "  \"emp_middle_name\": \"a\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-05-13\",\n" +
                "  \"emp_status\": \"fulltime\",\n" +
                "  \"emp_job_title\": \"Labour\"\n" +
                "}");

        //hitting the endpoint/send the request
        Response response=prepareRequest.when().post("/createEmployee.php");
        //verifying the assertion/get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from response
        employee_id= response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.prettyPrint();

        //verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Mo"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Al"));
        System.out.println("My test is pass");
}
        @Test
        public void eGetJobTitle(){

        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token);

        Response response=prepareRequest.when().get("/jobTitle.php");

        response.then().assertThat().statusCode(200);

        response.prettyPrint();

}
        @Test
        public void fGetEmployeeStatus(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token);

        Response response=prepareRequest.when().get("/employeementStatus.php");

        response.then().assertThat().statusCode(200);
        response.prettyPrint();
}
        @Test
        public void cUpdateEmployee(){
        RequestSpecification prepareRequest=given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("  {\n" +
                        "        \"employee_id\": \""+employee_id+"\",\n" +
                        "        \"emp_firstname\": \"Miami\",\n" +
                        "        \"emp_middle_name\": \"abc\",\n" +
                        "        \"emp_lastname\": \"yes\",\n" +
                        "        \"emp_gender\": \"M\",\n" +
                        "        \"emp_birthday\": \"2000-05-16\",\n" +
                        "        \"emp_job_title\": \"Labour\",\n" +
                        "        \"emp_status\": \"fulltime\"\n" +
                        "    }");
        Response response=prepareRequest.when().put("/updateEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }
        @Test
        public void dGetUpdatedEmployee(){
        RequestSpecification prepareRequest=given().
                header("Content_type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        Response response=prepareRequest.when().get("/getOneEmployee.php");
            response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}
