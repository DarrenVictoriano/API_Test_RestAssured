package test.sample;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo7_GET_Authorization {

    @Test
    public void AuthorizationTest() {

        // Base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

        // Authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");

        // set auth type to rest assured
        RestAssured.authentication = authScheme;

        // Request Object
        RequestSpecification httpRequest = RestAssured.given();

        // Send Get request
        Response response = httpRequest.request(Method.GET, "/");

        // Print response body
        System.out.println(response.getBody().asString());

        // status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
