package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Get list users
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameter(int page) {

        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {

        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {

        SerenityRest.then().statusCode(ok);
    }

//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int page) {
//        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page)); //actual, expected
//    }

    @And("Validate get list user JSON schema {string}")
    public void validateGetListUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //post create new users
    @Given("Create new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {

        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {

        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate create a new user JSON schema {string}")
    public void validateCreateANewUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenarior 3
    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonNdUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.putUpdateUser(json, id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate put update user JSON schema {string}")
    public void validatePutUpdateUserJSONScema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 4
    @Given("Delete user with valid user id {int}")
    public void deleteUserWithValidUserIs(int id) {
        reqresAPI.deleteUSer(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

}