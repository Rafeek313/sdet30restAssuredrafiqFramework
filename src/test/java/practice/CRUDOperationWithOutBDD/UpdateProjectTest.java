package practice.CRUDOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
public void updateProjectTest() {
	JSONObject jo=new JSONObject();
	jo.put("createdBy","harindar");
	jo.put("projectName","xylem");
	jo.put("status", "completed");
	jo.put("teamsize", 15);
	RequestSpecification req = RestAssured.given();
	req.body(jo);
	req.contentType(ContentType.JSON);
	
	Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1203");
	System.out.println(resp.getContentType());
	System.out.println(resp.asString());
	System.out.println(resp.prettyPrint());
	System.out.println(resp.prettyPeek());
}
}
