package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo6_GET_JsonPath {

    final static String BASE_URL = "http://restapi.demoqa.com/utilities/weather/city";

    @Test
    void getWeatherDetails() {

        // Specify base URI
        RestAssured.baseURI = BASE_URL;

        // Request object
        RequestSpecification req = RestAssured.given();

        // Send HTTP request GET
        Response res = req.request(Method.GET, "/Olongapo");

        // Get response as JSON
        JsonPath jsonPathBody = res.jsonPath();

        // Verify all node in response body
        System.out.println((String) jsonPathBody.get("City"));
        System.out.println((String) jsonPathBody.get("Humidity"));


    }


}
