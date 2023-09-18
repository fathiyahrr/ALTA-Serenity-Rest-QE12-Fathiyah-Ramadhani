package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PatchUpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positif
    @Given("Patch Update user with valid json {string} and user id {string}")
    public void patchUpdateUserWithValidJsonAndUserId(String jsonFile,String id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.patchUpdateUser(json,id);
    }
    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when()
                .patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate patch update user JSON schema {string}")
    public void validatePatchUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//Negative
    @Given("Patch Update user with invalid json {string} and valid user id {}")
    public void patchUpdateUserWithInvalidJsonAndValidUserId(String jsonFile, String id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.patchUpdateUserInvalid(json, id);
    }

    @When("Send request patch update invalid user")
    public void sendRequestPatchUpdateInvalidUser() {
        SerenityRest.when().put(ReqresAPI.PATCH_UPDATE_USER);
    }
    @And("Validate patch update invalid user JSON schema {string}")
    public void validatePatchUpdateInvalidUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
