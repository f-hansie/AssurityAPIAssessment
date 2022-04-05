package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getCategoryDetailsTest {

    // declare validate response variable
    private ValidatableResponse validatableResponse;
    // declare and initialize the endpoint url
    private String endpoint = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";

    @Given("I send a request to the URL to get categories details")
    public void i_send_a_request_to_the_url_to_get_categories_details() {

        // send request and get response body
        validatableResponse = given().contentType(ContentType.JSON)
                .when().get(endpoint).then();
        System.out.println("Response :"+validatableResponse.extract().asPrettyString());

    }

    @Then("the response will return id {int} ,name {string} and description {string}")
    public void the_response_will_return_id_name_and_description(int id, String name, String description) {

        // validate Category id
        validatableResponse.assertThat().body("CategoryId",equalTo(id));
        // validate Name value
        validatableResponse.assertThat().body("Name",equalTo(name));
        // validate CanRelist value
        validatableResponse.assertThat().body("CanRelist",equalTo(true));
        //validate description value
        validatableResponse.assertThat().body("Promotions.Description[1]",equalTo(description));

    }
}
