package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;

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


    @When("the response status is {int}")
    public void the_response_status_is(int status) {

        validatableResponse.assertThat().statusCode(status);
    }


    @Then("the response will return name {string},canRelist {string} and description {string}")
    public void the_response_will_return_name_can_relist_true_and_description(String name, String canRelist, String description) {

        // validate Name value
        validatableResponse.assertThat().body("Name",equalTo(name));
        // validate CanRelist value
        validatableResponse.assertThat().body("CanRelist",equalTo(canRelist));
        //validate description value
        validatableResponse.assertThat().body("Promotions.Description[1]",equalTo(description));
    }
}
