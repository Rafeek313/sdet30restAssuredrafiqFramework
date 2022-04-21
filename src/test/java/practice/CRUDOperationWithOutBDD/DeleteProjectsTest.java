package practice.CRUDOperationWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectsTest {
@Test
public void deleteProject() {
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1018");
	resp.then().log().all();
	int actstatus = resp.getStatusCode();
	Assert.assertEquals(actstatus,204);
}
}
