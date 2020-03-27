package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo4_GET_AllResponseHeaders {

    final static String BASE_URL = "https://maps.googleapis.com";

    @Test
    void getGoogleMapTest() {

        // Specify base URI
        RestAssured.baseURI = BASE_URL;

        // Request object
        RequestSpecification req = RestAssured.given();

        // Send HTTP request GET
        Response res = req.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        // Print response in console window
        String responseBody = res.getBody().asString();
        System.out.println("Response body: " + responseBody);

        // Verify all headers
        Headers allHeaders = res.headers();
        System.out.println("-------------- All Headers printed -----------");
        for (Header header: allHeaders) {
            System.out.println(header.getName() + " : " + header.getValue());
        }

    }


}
