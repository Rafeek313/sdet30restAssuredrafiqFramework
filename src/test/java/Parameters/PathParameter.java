package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class PathParameter {
	@Test
public void getSingleProject() {
		baseURI="http://localhost";
		port=8084;
		RequestSpecification resp = given().pathParam("pid", "TY_PROJ_1610");
	resp.when().get("/projects/{pid}").then().log().all();
}
}
