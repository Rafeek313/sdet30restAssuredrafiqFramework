package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {
	@Test
public void dynamicResponseValidation() {
		baseURI="http://localhost";
		port=8084;
		String expectedData = "TY_PROJ_1013";
	Response resp = when().get("/projects");
	List<String> actualData = resp.jsonPath().get("projectId");
	boolean flag=false;
	for(String pid:actualData)
	{
		if(pid.equalsIgnoreCase(expectedData))
			flag=true;		
	}
	Assert.assertEquals(flag, true);
	System.out.println("data verified");
}
}
