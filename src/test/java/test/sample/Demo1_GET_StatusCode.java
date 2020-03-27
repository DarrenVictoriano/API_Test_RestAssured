package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1_GET_StatusCode {

    final static String BASE_URL = "http://restapi.demoqa.com/utilities/weather";

    @Test
    void getWeatherDetails() {

        // Specify base URI
        RestAssured.baseURI = BASE_URL + "/city";

        // Request object
        RequestSpecification req = RestAssured.given();

        // Send HTTP request GET
        Response res = req.request(Method.GET, "/Hyderabad");

        // Print response in console window
        String responseBody = res.getBody().asString();
        System.out.println("Response body: " + responseBody);

        // Status code validation
        int statusCode = res.getStatusCode();
        System.out.println("Status Code: "+ statusCode);
        Assert.assertEquals(statusCode, 200);

        // status line verification
        String statusLine = res.getStatusLine();
        System.out.println("Status Line: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }


}
