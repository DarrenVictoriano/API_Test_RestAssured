package test.sample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo3_GET_ResponseHeader {

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

        // Verify headers from response
        String contentType = res.header("Content-Type");
        System.out.println("Content-Type: " + contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding = res.header("Content-Encoding");
        System.out.println("Content-Encoding: " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");
    }


}
