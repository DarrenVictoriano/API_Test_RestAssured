package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Array;

public class getCurrentTime {


    @Test
    public void getCurrentTimeVersion1() {

        String[] emptyArray = new String[5];

        // Specify base URI
        RestAssured.baseURI = EnvDefaults.getBaseURI();
        // whole URI http://restapi.demoqa.com/customer/register to make POST request

        // Request Objecct
        RequestSpecification httpRequest = RestAssured.given();

        // Request Parameters
        JSONObject requestParams = new JSONObject();
        JSONArray paramArray = new JSONArray(); // Empty JSON Array

        requestParams.put("method", "getCurrentTime");
        requestParams.put("id", 51);
        requestParams.put("params", paramArray);
        requestParams.put("version", "1.0");

        // Add Header Config
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("X-Auth-PSK", EnvDefaults.getAuthCode());

        // Add request params to request body
        httpRequest.body(requestParams.toJSONString());

        // send POST request
        Response response = httpRequest.request(Method.POST, "/system");

        // Verify response
        ResponseBody responseBody = response.body();
        System.out.println("Response Body: ");
        responseBody.prettyPrint();


        // check status code
        int statusCode = response.statusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode,  200);

    }
}
