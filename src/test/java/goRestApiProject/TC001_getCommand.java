package goRestApiProject;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.parser.CustomizationContextChecker;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TC001_getCommand {
	

HashMap map = new HashMap();
String CustName = RandomStringUtils.randomAlphabetic(5);
String custEmail = RandomStringUtils.randomNumeric(3);

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
		
		String CustName = RandomStringUtils.randomAlphabetic(5);
		String custEmail = RandomStringUtils.randomNumeric(3);
		
		map.put("name", CustName);
		map.put("email", "shobana"+custEmail+"@gmail.com");
		map.put("gender", "female");
		map.put("status", "active");
	}
	
	@Test(enabled=false)
	public void getUserDeatils() {
		given()
		.when()
			.get()
		.then()
			.statusCode(200)
			.contentType("application/json; charset=utf-8")
			.body("name", equalTo("Bhadraksh Bhat"))
			.log().all();
	}
	
	@Test
	public void createUser() {
		given()
			.contentType("application/json")
			.headers("Authorization","Bearer a41960017b3442e3571daaaae5e000776b336961bb9c35fe7ff9bc538c0047bc")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.contentType("application/json; charset=utf-8")
			.body("name", equalTo(CustName))
			.log().all();
	}

}
