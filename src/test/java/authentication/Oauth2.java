package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	@Test
	public void Oauth2_0() {
		Response resp = given().formParams("client_id","SDET30CoopsRestAssured")
				.formParam("client_secret", "1052180567319773f70afd83439ae8ef")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://rafeek.com")
				.formParam("code", "authorization_code")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		         resp.then().log().all();
		         String token = resp.jsonPath().get("access_token");
		         System.out.println(token);
		         given().auth().oauth2(token).pathParam("USER_ID", 3102)
		         .when()
		         .post("http://coop.apps.symfonycasts.com/api/USER_ID/eggs-collect")
		         .then().log().all();
	}

}
