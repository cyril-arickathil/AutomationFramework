package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.ValidatableResponse;
import org.example.api.Contacts;
import org.example.api.Login;
import org.example.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest
{
    private static final Logger log = LoggerFactory.getLogger(ApiTest.class);
    final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";
    String TOKEN;


    @Test
    public void login()
    {
        String endPoint = BASE_URL + "/users/login";
        System.out.println("endpoint is " + endPoint);
        Login login = new Login("cyril_test@fake.com", "faketest");
        var response = given().contentType("application/json").body(login).when().post(BASE_URL + "/users/login");
        TOKEN = response.jsonPath().get("token");
        System.out.println(TOKEN);
    }

    @Test(dependsOnMethods = "login")
    public void createContact() throws JsonProcessingException {
        Contacts.Location location = new Contacts.Location("kochi", "India");
        Contacts.Employer employer = new Contacts.Employer("SDET", "Google");
        Contacts contacts = new Contacts(
                "James",
                "Dave",
                "james_dave@fake.com",
                location,
                employer
        );
        var response = given().header("Authorization", "Bearer " + TOKEN).contentType("application/json")
                .body(contacts).when().post(BASE_URL + "/contacts");

        response.then().assertThat().statusCode(201).
                body("firstName", equalTo("James"));
        String _id = response.jsonPath().get("_id");
        System.out.println(_id);
    }

    @Test(dependsOnMethods = "login")
    public void getContacts() {
        var response = given().header("Authorization", "Bearer " + TOKEN).contentType("application/json")
                .when().get(BASE_URL + "/contacts");
        response.jsonPath().get("[0]._id");
        response.then().log().body();
    }

    @Test
    public void getUsers() {
        String endpoint = "https://reqres.in/api/users/2";
        ValidatableResponse response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void createUser() {
        String body = """
                        {
                             "id" : "786",
                            "name": "test_user123",
                            "job": "6355"
                        }
                """;
        String endPoint = "https://reqres.in/api/users";
        User user = new User(15, "testUser", "QA-automationa");
        ValidatableResponse response = given().body(body).when().post(endPoint).then();
        response.log().body();
        response.log().status();

    }
}
