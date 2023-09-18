package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //positif
//    @Given("Delete user with valid user id {int}")
//    public void deleteUserWithValidUserI(int id) {
//        reqresAPI.deleteUSer(id);
//    }

//    @When("Send request delete user")
//    public void sendRequestDeleteUser() {
//        SerenityRest.when()
//                .delete(ReqresAPI.DELETE_USER);
//    }

//    @Then("Status code should be {int} No Content")
//    public void statusCodeShouldBeNoContent(int noContent) {
//        SerenityRest.then().statusCode(noContent);
//    }

    //negative

    @Given("Delete user with invalid user id {}")
    public void deleteUserWithInvalidUserId(int id) {
        reqresAPI.deleteUserInvalidId(id);
    }
}
