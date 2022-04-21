package practice.CRUDOperationWithOutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectTest {
@Test
public void getAllProject() {
	Response resp = RestAssured.get("http://localhost:8084/projects");
	resp.then().log().all();
	int actstatus = resp.getStatusCode();
	Assert.assertEquals(actstatus, 200);
}
}
