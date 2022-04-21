package CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	@Test
public void createProjectTest() {
baseURI="http://localhost";
port=8084;
JavaLibrary jlib=new JavaLibrary();
//step 1:crete pre requisit
JSONObject jo=new JSONObject();
jo.put("createdBy","rafeek");
jo.put("projectName","brittania"+jlib.getRandomNumber());
jo.put("status", "completed");
jo.put("teamsize", 2);
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
