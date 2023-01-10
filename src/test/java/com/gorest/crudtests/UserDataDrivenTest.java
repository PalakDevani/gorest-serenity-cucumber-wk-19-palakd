package com.gorest.crudtests;

import com.gorest.steps.UsersSteps;
import com.gorest.testbase.TestBase;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


//@Concurrent(threads = "2x")
//@UseTestDataFrom("src/test/java/resources/testdata/userdata.csv")
//@RunWith(SerenityParameterizedRunner.class)


public class UserDataDrivenTest extends TestBase {

    private String token = PropertyReader.getInstance().getProperty("token");
    private String name;
    private String gender;
    private String email;
    private String status;
    private int userID;
    @Steps
    UsersSteps usersSteps;

    @Title("Data driven test for multiple users to the application")
    @Test

    public void createMultipleUsers() {
        usersSteps.createUser(name, gender, email, status, token).statusCode(201);

    }


}
