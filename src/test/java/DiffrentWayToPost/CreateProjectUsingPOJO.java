package DiffrentWayToPost;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites
		PojoClass pLib = new PojoClass("Harendra", "Google "+jLib.getRandomNumber(), "Completed", 0);
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		.when()                          //Step 2: perform action
		 .post("/addProject")
		.then()                          //Step 3: validation
		 .assertThat().statusCode(201)
		 .log().all();
		
		
		
	}

}
