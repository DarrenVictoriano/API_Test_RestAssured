package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo5_GET_ResponseBodyContains {

    final static String BASE_URL = "http://restapi.demoqa.com/utilities/weather/city";

    @Test
    void getWeatherDetails() {

        // Specify base URI
        RestAssured.baseURI = BASE_URL;

        // Request object
        RequestSpecification req = RestAssured.given();

        // Send HTTP request GET
        Response res = req.request(Method.GET, "/Olongapo");

        // Print response in console window
        String responseBody = res.getBody().asString();
        System.out.println("Response body: " + responseBody);

        // Verify response body
        Assert.assertTrue(responseBody.contains("Olongapo"),
                "Expecting body contains 'Olongapo', actual response is "
                        + res.jsonPath().getString("City"));

    }


}
