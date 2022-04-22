package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class QueryParameters {
	@Test
public void queryParameter() {
	baseURI="https://reqres.in";
	RequestSpecification resp = given().queryParam("page", 2);
	resp.when().get("/api/users")
	.then().log().all();
}
}
