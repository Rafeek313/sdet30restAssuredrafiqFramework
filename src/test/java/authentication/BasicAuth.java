package authentication;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth {
	@Test
public void basicAuth() {
		baseURI="http://localhost";
		port=8084;
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	@Test
	public void premptiveAuth() {
		baseURI="http://localhost";
		port=8084;
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	@Test
	public void digestAuth() {
		baseURI="http://localhost";
		port=8084;
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
}
