package CRUDOperationWithBDD;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class GetSingleProjectTest {
	@Test
	public void getSingleProjectTest() {
		baseURI="http://localhost";
		port=8084;
		get("/projects/TY_PROJ_614").then().log().all();
	}

}
