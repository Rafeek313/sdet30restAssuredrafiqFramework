package CRUDOperationWithBDD;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
public class GetAllProjectTest {
	@Test
public void getAllproject() {
	baseURI="http://localhost";
	port=8084;
	
	get("/projects").then().assertThat().statusCode(200).log().all();
	
	
}
}
