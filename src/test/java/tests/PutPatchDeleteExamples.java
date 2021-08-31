package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamples {
    @Test
    public void testPut(){

        baseURI="https://reqres.in/api";

        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString());

        given()
            .header("Content-Type", "application/json")
                //Inform the server that the request and response should accept in JSON format
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString());

        when()
            .put("/users/2").

        then()
            .statusCode(200)
            .log().all();

    }

    @Test
    public void testPatch(){

        baseURI="https://reqres.in";

        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString());

        given()
            .header("Content-Type", "application/json")
                    //Inform the server that the request and response should accept in JSON format
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString()).

        when()
            .patch("/api/users/2").

        then()
            .statusCode(200)
            .log().all();

    }

    @Test
    public void testDelete(){

        baseURI="https://reqres.in";

        when()
            .delete("/api/users/2").

        then()
            .statusCode(204)
            .log().all();

    }
}
