package test.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import test.pojo.CreateAUserPojo;
import test.pojo.CreatePostsPojo;
import utils.ConfigReader;
import utils.PayloadUtils;


public class CreateUser_StepDef {
    RequestSpecification requestSpecification;
    Response response;
    WebDriver driver;
    @Given("User get request with correct authorization")
    public void user_get_request_with_correct_authorization() {
        requestSpecification = RestAssured.given().accept("application/json")
                .header("Authorization", ConfigReader.readProperty("auth"));

    }
    @Then("User pass request body")
    public void user_pass_request_body() {
        RestAssured.baseURI = "https://gorest.co.inpublic-api";
        RestAssured.basePath = "users";
        response =requestSpecification.body(PayloadUtils.getCreateUserPayload()).when().post().then()
                .statusCode(200).extract().response();

    }
    @Then("User validates the response body")
    public void user_validates_the_response_body() {
        CreateAUserPojo parsedPost= response.as(CreateAUserPojo.class);
        Assert.assertEquals(57446,parsedPost.getData());


    }

    @Given("User get request with negative authorization {string}")
    public void user_get_request_with_authorization_and_negative_authorization(String token) {
        RestAssured.given().header("Authorization", token)
                .when().get("https://gorest.co.in/public-api/users")
                .then().statusCode(401).extract().response();


    }
    @When("User pass wrong request body {string}, {string}, {string}, {string}")
    public void user_pass_wrong_request_body(String string, String string2, String string3, String string4) {

    }
    @Then("user validates the response body error")
    public void user_validates_the_response_body_error() {

    }


}
