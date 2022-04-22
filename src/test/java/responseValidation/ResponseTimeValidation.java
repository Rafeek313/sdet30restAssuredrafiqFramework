package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseTimeValidation {
	@Test
public void responseTimeValidation() {
	baseURI="http://localhost";
	port=8084;
	Response resp = when().get("/projects");
	resp.then().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS);
	long time = resp.getTime();//resp.Time
	System.out.println("response time is "+time);
	
}
}
