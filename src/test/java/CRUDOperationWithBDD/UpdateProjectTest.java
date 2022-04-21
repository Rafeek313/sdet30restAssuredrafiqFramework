package CRUDOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
@Test
public void udateProjectTest() {
	baseURI="http://localhost";
	port=8084;
	JavaLibrary jlib=new JavaLibrary();
	//step 1:crete pre requisit
	JSONObject jo=new JSONObject();
	jo.put("createdBy","Harindar");
	jo.put("projectName","honda"+jlib.getRandomNumber());
	jo.put("status", "completed");
	jo.put("teamsize", 2);
	given()
	.body(jo)
	.contentType(ContentType.JSON)
	.when()
	.put("/projects/TY_PROJ_1004")
	.then()
	.assertThat()
	.statusCode(200)
	.log()
	.all();
}
}
