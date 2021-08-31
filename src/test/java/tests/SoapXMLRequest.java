package tests;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class SoapXMLRequest {

    @Test
    public void validateSoanXML(){
        baseURI = "http://www.dneonline.com";

        given()
            .contentType("text/xml")
            .accept(ContentType.XML)
            .body();
    }
}
