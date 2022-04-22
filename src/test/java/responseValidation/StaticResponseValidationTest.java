package responseValidation;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import projectLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	@Test
public void staticResponseValidationTest() {
		JavaLibrary jlib=new JavaLibrary();
		PojoClass plib=new PojoClass("rafeek","xylem"+jlib.getRandomNumber(),"Completed",30);
		baseURI="http://localhost";
		port=8084;
		String expectedData = "TY_PROJ_1606";
	Response resp = given().body(plib).contentType(ContentType.JSON).when().post("/addProject");
	String actualData = resp.jsonPath().get("projectId");
	resp.then().log().all();
	Assert.assertEquals(expectedData, actualData);
	
}
}
