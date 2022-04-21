package DiffrentWayToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonObject {
	@Test
	public void createProjectTest() {
	baseURI="http://localhost";
	port=8084;
	JavaLibrary jlib=new JavaLibrary();
	//step 1:crete pre requisit
	JSONObject jo=new JSONObject();
	jo.put("createdBy","rahman");
	jo.put("projectName","oreo"+jlib.getRandomNumber());
	jo.put("status", "completed");
	jo.put("teamsize", 25);
	given()
	.body(jo)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat()
	.statusCode(201)
	.log()
	.all();
}
}
