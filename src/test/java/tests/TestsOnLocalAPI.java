package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {

    //@Test
    public void get(){
        baseURI="http://localhost:3000";
        given().get("/users").
            then().statusCode(200).
            log().all();
    }

    //@Test
    public void post(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Thomas");
        request.put("lastName", "Edison");
        request.put("subjectId", 1);

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString()).

        when()
            .post("/users").

        then()
            .statusCode(201);
    }

    //@Test
    public void put(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName","Albert");
        request.put("lastName", "Edison");
        request.put("subjectId", 1);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).

                when()
                .put("/users/4").

                then()
                .statusCode(200);
    }

    //@Test
    public void patch(){
        baseURI="http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("lastName", "Anderson");


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).

                when()
                .patch("/users/4").

                then()
                .statusCode(200);
    }

    @Test
    public void delete(){
        baseURI="http://localhost:3000";

        when()
            .delete("/users/4").

        then()
        .statusCode(404);
    }
}
