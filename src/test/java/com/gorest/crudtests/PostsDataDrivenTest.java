package com.gorest.crudtests;


import com.gorest.steps.PostsSteps;
import com.gorest.steps.UsersSteps;
import com.gorest.testbase.TestBase;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

//@Concurrent(threads = "6x")
//@UseTestDataFrom("src/test/java/resources/testdata/postsdata.csv")
//@RunWith(SerenityParameterizedRunner.class)

public class PostsDataDrivenTest extends TestBase {


    static String token = PropertyReader.getInstance().getProperty("token");


    private String name = "Prime" + TestUtils.getRandomValue();
    private String gender = "male";
    private String email = name + "@email.com";
    private String status = "active";
    private int userID = Integer.parseInt("123" + TestUtils.getRandomValue());

    private String title;
    private String body;
    private int postID;

    @Steps
    PostsSteps postsSteps;
    @Steps
    UsersSteps usersSteps;

    @Title("Create a new post for users")
    @Test

    public void createNewPostForUsers() {
        userID = usersSteps.createUser(name, gender, email, status, token).extract().path("id");
        postsSteps.createPost(userID, title, body, token).statusCode(201);


    }
}
