package stepDefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LocationChild;
import pojo.ReqPlaceData;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Util;

import static io.restassured.RestAssured.*;

public class placeSteps extends Util {

	RequestSpecification req;
	Response rep;
	TestDataBuild b = new TestDataBuild();

	@Given("create payload with request")
	public void create_payload_with_request() throws IOException {

		req = given().spec(setup()).body(b.requestData());

	}

	@When("user send {string} requet with {string} method")
	public void user_send_requet_with_method(String endpoint, String method) {
		APIResources resource = APIResources.valueOf(endpoint);
		System.out.println(resource.getResource());

		if (method.equalsIgnoreCase("post")) {

			rep = req.when().post(resource.getResource());
		} else if (method.equalsIgnoreCase("get")) {
			rep = req.when().get(resource.getResource());
		} else if (method.equalsIgnoreCase("put")) {
			rep = req.when().put(resource.getResource());
		} else if (method.equalsIgnoreCase("delete")) {
			rep = req.when().delete(resource.getResource());
		}
	}

	@Then("validate status code is 200")
	public void validate_status_code_is() {
		int statusCode = rep.statusCode();
		Assert.assertEquals(200, statusCode);
	}

	@Then("{string} value in body is {string}")
	public void value_in_body_is(String expectedKey, String expectedValue) {

		String response = rep.asString();
		String actualValue = getJsonValue(response, expectedKey);
		Assert.assertEquals(expectedValue, actualValue);
	}

}
