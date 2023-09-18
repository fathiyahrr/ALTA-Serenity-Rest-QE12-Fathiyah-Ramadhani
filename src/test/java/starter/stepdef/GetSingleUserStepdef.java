package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepdef {

    @Steps
    ReqresAPI reqresAPI;

    //positif

    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterData(int id) {
        reqresAPI.getSingleUsers(id);
    }

    @When("Send request get single users")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }
    @And("Response body data should be id {int}")
    public void responseBodyDataShouldBe(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id));
    }
    @And("Validate get single user JSON schema {string}")
    public void validateGetSingleUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
    //negative
    @Given("Get single user not found with invalid parameter id {int}")
    public void getSingleUserNotFoundWithInvalidParameterId(int id) {
        reqresAPI.getSingleUSerNotFound(id);
    }

    @When("Send request get single users with invalid parameter")
    public void sendRequestGetSingleUsersWithInvalidParameter() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS_NOT_FOUND);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int id) {
//        SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id));
//   }

    @And("Validate get single user with invalid parameter JSON schema {string}")
    public void validateGetSingleUserVithInvalidParameterJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



}
