package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;


import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //positif test case
    @Given("Register new user with valid json {string}")
    public void registerNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postRegisterUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {

        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body id was {int} and was token {string}")
    public void responseBodyIdWasAndWasToken(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate register successful JSON schema {string}")
    public void validateRegisterSuccessfulJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //negative test case

    @Given("Register with valid email and empty password {string}")
    public void registerWithValidEmailAndEmptyPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postRegisterUserUnsuccessful(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body with error message {string}")
    public void responseBodyWithErrorMessage(String missingPassword) {
        SerenityRest.and()
                .body(ReqresResponses.ERRORMESSAGE,equalTo(missingPassword));
    }

    @And("Validate register unsuccessful JSON schema {string}")
    public void validateRegisterUnsuccessfulJSONSchema(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postRegisterUserUnsuccessful(json);
    }
}
