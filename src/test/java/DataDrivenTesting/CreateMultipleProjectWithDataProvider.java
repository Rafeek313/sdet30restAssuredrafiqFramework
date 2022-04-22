package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDataProvider {
	@Test(dataProvider = "getData")
public void createMultipleProjectWithDataProvider(String createdBy,String projectName,String status,int teamSize){
		baseURI="http://localhost";
		port=8084;
		JavaLibrary jlib=new JavaLibrary();
		PojoClass p=new PojoClass(createdBy, projectName+jlib.getRandomNumber(), status, teamSize);
		given().body(p).contentType(ContentType.JSON).when().post("/addProject").then().log().all();
		
	}
	@DataProvider(name="getData")
	public Object[][] data(){
Object[][] data=new Object[3][4];

data[0][0]="chaitra";
data[0][1]="xylem";
data[0][2]="Completed";
data[0][3]=12;

data[1][0]="Rafeek";
data[1][1]="google";
data[1][2]="On Going";
data[1][3]=12;

data[2][0]="Ali";
data[2][1]="Microsoft";
data[2][2]="Completed";
data[2][3]=12;
return data;

	}

}
