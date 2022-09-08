package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

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
    public void the_response_status_is(int status) throws Exception{

        try {

            validatableResponse.assertThat().statusCode(status);
        }catch (Exception e){
            throw new Exception("the response failed to return status 200 and it returned a status " + status);
        }

    }

    @When("the response must return name tag (.*)$")
    public void the_response_must_return_name_tag_carbon_credits(String name) throws Exception {

        try {
            // validate Name value
            validatableResponse.assertThat().body("Name",equalTo(name));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @When("the response must return boolean value (.*)$")
    public void the_response_must_return_boolean_value_true(boolean canRelist) throws Exception {

        try {
            // validate CanRelist value
            validatableResponse.assertThat().body("CanRelist",equalTo(canRelist));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    @Then("the response must return category description (.*)$")
    public void the_response_must_return_category_description_good_position_in_category(String description) throws Exception{

        try {
            //validate description value
            validatableResponse.assertThat().body(containsStringIgnoringCase(description));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
