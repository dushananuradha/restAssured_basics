package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostExamples {
    //@Test
    public void testGet(){
        baseURI="https://reqres.in/api";

        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[4].first_name", equalTo("George")).
            body("data.first_name", hasItems("Michael", "Rachel"));
    }

    @Test
    public void testPost(){

        baseURI="https://reqres.in/api";
        //Since JSONObject class is used, no need of explicit mapping
        //Map <String , Object> map = new HashMap<String, Object>();
        //map.put("name", "Raghav");
        //map.put("job", "Teacher");

        //create the body of the request
        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");
        System.out.println(request.toJSONString());

        given()
            .header("Content-Type", "application/json")
            //Inform the server that the request and response should accept in JSON format
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(request.toJSONString()).

        when()
            .post("/users").

        then()
            .statusCode(201)
            .log().all();

    }
}
