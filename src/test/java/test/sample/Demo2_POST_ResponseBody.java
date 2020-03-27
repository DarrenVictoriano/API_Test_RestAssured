package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2_POST_ResponseBody {

    @Test
    void RegistrationSuccessful() {

        // Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        // whole URI http://restapi.demoqa.com/customer/register to make POST request

        // Request Objecct
        RequestSpecification httpRequest = RestAssured.given();

        // Request Parameters
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "John");
        requestParams.put("LastName", "Wick");
        requestParams.put("UserName", "JohnWickss");
        requestParams.put("Password", "StrongAF");
        requestParams.put("Email", "John.Wickss@gmail.com");

        // Add Header Config
        httpRequest.header("Content-Type", "application/json");

        // Add request params to request body
        httpRequest.body(requestParams.toJSONString());

        // send POST request
        Response response = httpRequest.request(Method.POST, "/register");

        // Verify response
        String responseBody = response.body().asString();
        System.out.println("Request Body: " + responseBody);

        // check status code
        int statusCode = response.statusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode,  201);

        // Verify response body param
        String successCode = response.jsonPath().get("SuccessCode");
        String msg = response.jsonPath().get("Message");
        System.out.println("Success Code: " + successCode);
        System.out.println("Message: " + msg);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }

}
