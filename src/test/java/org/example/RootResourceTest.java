package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;

@QuarkusTest
public class RootResourceTest {


  @Test
  void testListAllFruits() {
    //List all, should have all 3 fruits the database has initially:
    given()
            .when().get("/roots")
            .then()
            .statusCode(200)
            .body(
                    containsString("Cherry"),
                    containsString("Apple"),
                    containsString("Banana")
            );

    //Delete the Cherry:
    given()
            .when().delete("/roots/1")
            .then()
            .statusCode(204)
    ;

    //List all, cherry should be missing now:
    given()
            .when().get("/roots")
            .then()
            .statusCode(200)
            .body(
                    not(containsString("Cherry")),
                    containsString("Apple"),
                    containsString("Banana")
            );

    //Create a new Fruit
    given()
            .when().post("/roots/name/Orange")
            .then()
            .statusCode(200)
            .body(containsString("Orange"))
            .body("id", notNullValue())
            .extract().body().jsonPath().getString("id");

    //List all, Orange should be present now:
    given()
            .when().get("/roots")
            .then()
            .statusCode(200)
            .body(
                    not(containsString("Cherry")),
                    containsString("Apple"),
                    containsString("Orange")
            );
  }

  @Test
  void testFindByColor() {
    //Find by color that no fruit has
    given()
            .when().get("/roots/name/Black")
            .then()
            .statusCode(200)
            .body("size()", is(0));

    //Find by color that multiple fruits have
    given()
            .when().get("/roots/name/Apple")
            .then()
            .statusCode(200)
            .body(
                    containsString("Apple")
            );

    //Find by color that matches
    given()
            .when().get("/roots/name/Avocado")
            .then()
            .statusCode(200)
            .body("size()", is(1))
            .body(containsString("Avocado"));

    //Update color of Avocado
    given()
            .when().put("/roots/id/4/name/Black")
            .then()
            .statusCode(200)
            .body(containsString("Black"));

    //Find by color that Avocado now has
    given()
            .when().get("/roots/name/Black")
            .then()
            .statusCode(200)
            .body("size()", is(1))
            .body(
                    containsString("Black")
            );
  }}
