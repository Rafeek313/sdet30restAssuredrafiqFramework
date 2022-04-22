package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.PojoClass;
public class CreateProjectAndGetProject {
	@Test
public void requestChaining() {
	JavaLibrary jlib=new JavaLibrary();
	PojoClass plib=new PojoClass("ali", "mozilla"+jlib.getRandomNumber(), "completed", 35);
	baseURI="http://localhost";
	port=8084;
	 Response resp = given().body(plib).contentType(ContentType.JSON)
	.when().post("/addProject");
	String pid=resp.jsonPath().get("projectId");
	System.out.println(pid);
	resp.then().log().all();
	given()
		.pathParam("proid", pid)
	 .when()
	 	.get("/projects/{proid}")
	 .then()
	 	.assertThat().statusCode(200).log().all();
	
}
}
