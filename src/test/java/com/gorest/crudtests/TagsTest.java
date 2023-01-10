package com.gorest.crudtests;

import com.gorest.constants.Endpoints;
import com.gorest.testbase.TestBase;
import com.gorest.utils.PropertyReader;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)

public class TagsTest extends TestBase {

    private String token = PropertyReader.getInstance().getProperty("token");

    @WithTag("Usersfeature: NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {

        SerenityRest.rest().given()
                .header("Authorization", "Bearer " + token)
                .when()
                .patch("/users")
                .then()
                .statusCode(404)
                .log().all();
    }


    @WithTags({
            @WithTag("usersfeature:SMOKE"),
            @WithTag("usersfeature:POSITIVE")
    })

    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTags({
            @WithTag("Usersfeature:SMOKE"),
            @WithTag("Usersfeature:NEGATIVE")
    })

    @Title("This test will provide an error code of 404 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {

         int userID = 108;
        SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
          .header("Authorization", "Bearer " + token)
             .pathParam("userID", userID)
                .when()
             .delete(Endpoints.GET_USER_BY_ID)
                //.post("UserID")
                .then()
                .statusCode(404)
                .log().all();
    }


}
