package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
@Test
public void bearertoken() {
	baseURI="https://api.github.com";
	JSONObject jo=new JSONObject();
	jo.put("name", "SDET30-RestAssured");
	given().auth().oauth2("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").body(jo).contentType(ContentType.JSON)
	.when().post("/user/repos")
	.then().log().all();
}
}
