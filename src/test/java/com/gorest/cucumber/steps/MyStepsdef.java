package com.gorest.cucumber.steps;

import com.gorest.steps.UsersSteps;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepsdef {

    static ValidatableResponse response;


    static String token = PropertyReader.getInstance().getProperty("token");
    static String name = "Prime" + TestUtils.getRandomValue();
    static String gender = "male";
    static String email = name + "@email.com";
    String _name = name + "_update";
    static String status = "active";
    static int userID;


    @Steps
    UsersSteps usersSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response = usersSteps.getUserByID(userID, token);
    }

    @Then("^User must get back a valid status code two hundred$")
    public void userMustGetBackAValidStatusCodeTwoHundred() {
        response.statusCode(200);
    }

    @When("^User sends a Post request to list endpoint$")
    public void userSendsAPostRequestToListEndpoint() {
        response = usersSteps.createUser(name, email, gender, status, token);
    }

    @Then("^User must get back a valid status code two hundred One$")
    public void userMustGetBackAValidStatusCodeTwoHundredOne() {
        response.statusCode(201);
    }

    @When("^User sends a Put request to list endpoint$")
    public void userSendsAPutRequestToListEndpoint() {
        response = usersSteps.updateUser(_name, gender, userID, email, status, token);
    }

    @When("^User sends a Delete request to list endpoint$")
    public void userSendsADeleteRequestToListEndpoint() {
        response = usersSteps.deleteUser(userID, token);
    }

    @Then("^User must get back a valid status code two hundred four$")
    public void userMustGetBackAValidStatusCodeTwoHundredFour() {
        response.statusCode(204);
    }
}
