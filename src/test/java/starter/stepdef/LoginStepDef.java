package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

//positif test case
public class LoginStepDef {


    @Steps
    ReqresAPI reqresAPI;

    //Positif
    @Given("Login user with valid json {string}")
    public void loginUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body token was {string}")
    public void responseBodyTokenWas(String token) {
        SerenityRest.and()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate login successful JSON schema {string}")
    public void validateLoginSuccessfulJSONSchema(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLoginUser(json);
    }
    //Negative
    @Given("Login with valid email and empty password {string}")
    public void loginWithValidEmailAndEmptyPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLoginUserUnsuccessful(json);
    }

    @And("Validate login unsuccessful JSON schema {string}")
    public void validateLoginUnsuccessfulJSONSchema(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLoginUserUnsuccessful(json);
    }
}
