package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;
import java.net.URI;

public class ReqresAPI {



//Latihan

    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}*";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

//Tugas

    public static String POST_REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String POST_LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}*";
    public static String GET_SINGLE_USERS = Constants.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USERS_NOT_FOUND = Constants.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";
    public static String GET_SINGLE_RESOURCE_NOT_FOUND = Constants.BASE_URL+"/api/unknown/{id}";




    @Step("Get list user")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete a user")
    public void deleteUSer(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    //Tugas
    @Step("Register user")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Register user Unsuccessful")
    public void postRegisterUserUnsuccessful(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login user")
    public void postLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Login user unsuccessful")
    public void postLoginUserUnsuccessful(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update user")
    public void patchUpdateUser(File json, String id) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single user")
    public void getSingleUsers(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }
    public void getSingleUSerNotFound(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user")
    public void patchUpdateUserInvalid(File json, String id) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public void deleteUserInvalidId(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }

    public void getSingleResource(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }


    public void getSingleResourceNotFound(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }
}
