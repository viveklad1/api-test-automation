package com.api.test.automation.framework.steps;

import com.api.test.automation.framework.utilities.APIConstant;
import com.api.test.automation.framework.utilities.RestAssuredUtil;
import com.api.test.automation.framework.model.Student;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentAPIStepDefinition {
    public static ResponseOptions<Response> response;
    @Given("^I perform \"([^\"]*)\" operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String method, String url) throws Throwable {
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, null ).executeWithPathParams(null);
    }
    @Given("^I perform \"([^\"]*)\" operation for \"([^\"]*)\" with id query param \"([^\"]*)\"$")
    public void iPerformGETOperationWithIdParam(String method, String url, String id) throws Throwable {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("id",id);
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, null ).executeWithQueryParams(queryParam);
    }
    @Given("^I perform \"([^\"]*)\" operation for \"([^\"]*)\" with class query param \"([^\"]*)\"$")
    public void iPerformGETOperationWithClassParam(String method, String url, String division) throws Throwable {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("class",division);
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, null ).executeWithQueryParams(queryParam);
    }
    @Given("^I perform \"([^\"]*)\" operation using path param for \"([^\"]*)\"$")
    public void iPerformDELETEOperationWithPathParam(String method, String url, DataTable table) throws Throwable {
        Map<String, String> pathParam = new HashMap<>();
        List<List<String>> list = table.raw();
        pathParam.put(list.get(0).get(0),list.get(1).get(0));
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, null ).executeWithPathParams(pathParam);
    }

    @Given("^I perform \"([^\"]*)\" operation to create Student using \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationWithBody(String method, String url, DataTable table) throws Throwable {
        List<Student> data = table.asList(Student.class);
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, null ).executeWithPathParamsAndBody(null, data.get(0));
    }

    @Given("^I perform \"([^\"]*)\" operation for \"([^\"]*)\" with token \"([^\"]*)\"$")
    public void iPerformGETOperationWithToken(String method, String url, String token) throws Throwable {
        response = new RestAssuredUtil(APIConstant.STUDENT_API_BASE_URL,url, method, token ).executeWithPathParams(null);
    }
    @Then("^I should see the total \"([^\"]*)\" records with details below$")
    public void iShouldSeeTheStudentsAs(int totalRecords, DataTable table) throws Throwable {
        Student[] students = response.getBody().as(Student[].class);
        Assert.assertEquals(totalRecords, students.length);
        List<Student> data = table.asList(Student.class);
        for(int i=0; i<data.size();i++) {
            Assert.assertTrue(students[i].checkLogicalEquals(data.get(i)));
        }
    }
    @Then("^I should see the student details as below$")
    public void iShouldSeeTheStudentDetailsAs(DataTable table) throws Throwable {
        Student student = response.getBody().as(Student.class);
        List<Student> data = table.asList(Student.class);
        Assert.assertTrue(student.checkLogicalEquals(data.get(0)));
        Assert.assertEquals(HttpStatus.SC_OK,response.statusCode());
    }
    @Then("^I should see \"([^\"]*)\" as response status$")
    public void iShouldSeeTheResponseStatusAs(int responseStatus) throws Throwable {
        Assert.assertEquals(responseStatus, response.statusCode());
    }

}
