package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positif
    @Given("Get single resource with valid parameter id {int}")
    public void getListResourceWithValidParameterPage(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);

    }
    @And("Validate get single resource JSON schema {string}")
    public void validateGetSingleResourceJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Negative
    @Given("Get single resource not found with invalid parameter id {int}")
    public void getSingleResourceNotFoundWithInvalidParameterId(int id)  {
        reqresAPI.getSingleResourceNotFound(id);
    }
    @When("Send request get single resource with invalid parameter")
    public void sendRequestGetSingleResourceWithInvalidParameter() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE_NOT_FOUND);
    }
    @And("Validate get single resource not found with invalid parameter JSON schema {string}")
    public void validateGetSingleResourceNotFoundWithInvalidParameterJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}