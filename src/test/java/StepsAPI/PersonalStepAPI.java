package StepsAPI;

import java.io.File;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.Personal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PersonalStepAPI {
	RequestSpecification httpRequest;
	String requestBody;
	static Personal personal;
	static String customerid;
	
	Response response;
	ValidatableResponse validateResponse;

	@Given("user configure Base URI in Rest Assured")
	public void user_configure_base_uri_in_rest_assured() {
		RestAssured.baseURI = "http://localhost:5000/personals";

	}

	@Given("user get the Request Specification interface object")
	public void user_get_the_request_specification_interface_object() {
		httpRequest = RestAssured.given();

	}

	@Given("user add request {string} and {string} header")
	public void user_add_request_and_header(String key, String value) {
		httpRequest.header(key, value);
	}

	@Given("user create request body using json Node as {string}")
	public void user_create_request_body_using_json_node_as(String JsonNodeName) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		File f = new File(System.getProperty("user.dir") + "//src//test//resources//TestData//PersonalTestData.json");
		JsonNode jsonNode = mapper.readTree(f);
		personal = mapper.treeToValue(jsonNode.get(JsonNodeName), Personal.class);
		requestBody = mapper.writeValueAsString(personal);
	}

	@Given("user add request body to HTTP Request")
	public void user_add_request_body_to_http_request() {
		httpRequest.body(requestBody);
	}

	@When("user select HTTP {string} Request")
	public void user_select_http_request(String RequestType) {
		
		if (RequestType.equalsIgnoreCase("POST")) {
			response = httpRequest.post();
		}
		else if (RequestType.equalsIgnoreCase("GET")) {
			response = httpRequest.get(customerid);
		}
		else if (RequestType.equalsIgnoreCase("PUT")) {
			response = httpRequest.put(customerid);
		}
		else if (RequestType.equalsIgnoreCase("DELETE")) {
			response = httpRequest.delete(customerid);
		}
	}

	@Then("user get the validatable Response interface object")
	public void user_get_the_validatable_response_interface_object() {
		validateResponse = response.then().assertThat();

	}

	@Then("user validate status code as {int}")
	public void user_validate_status_code_as(Integer code) {
		validateResponse.statusCode(Matchers.equalTo(code));
	}

	@Then("user validate status line as {string}")
	public void user_validate_status_line_as(String line) {
		validateResponse.statusLine(Matchers.containsString(line));
	}

	@Then("user validate response time should below {int} ms")
	public void user_validate_response_time_should_below_ms(Integer time) {
		validateResponse.time(Matchers.lessThan((long)time));
	}

	@Then("user validate fullname from response body")
	public void user_validate_fullname_from_response_body() {
		
		validateResponse.body("fullName", Matchers.equalTo(personal.getFullName()));
		
	}

	@Then("user validate date key from response body")
	public void user_validate_date_key_from_response_body() {
		
		validateResponse.body("dob", Matchers.hasKey("date"));
	}

	@Then("user validate gender from response body")
	public void user_validate_gender_from_response_body() {
		validateResponse.body("gender", Matchers.equalTo(personal.isGender()));
	}

	@Then("user validate country key from response body")
	public void user_validate_country_key_from_response_body() {
		validateResponse.body("address", Matchers.hasKey("country"));
	}

	@Then("user validate country key-value from response body")
	public void user_validate_country_key_value_from_response_body() {
		validateResponse.body("address.country", Matchers.equalTo(personal.getAddress().getCountry()));
	}

	@Then("user validate json schema")
	public void user_validate_json_schema() {
		
		File f =new File(System.getProperty("user.dir")+"//src//test//resources//JsonSchema//PersonalJsonSchema.json");
		
		validateResponse.body(JsonSchemaValidator.matchesJsonSchema(f));
	}

	@Then("user capture id from response body")
	public void user_capture_id_from_response_body() {
	 customerid = response.getBody().jsonPath().getString("id");
		
	}

	@Then("user print response log in console")
	public void user_print_response_log_in_console() throws InterruptedException {
		validateResponse.log().all();
		
		Thread.sleep(5000);
		System.err.println("---------------------------------------------------------");
		
	}

}
