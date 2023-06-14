package com.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class TestTwo {
public static void restTesst() {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String respone = given().log().all().queryParam("key","qaclick123").
	header("Content-Type","application/json").
	body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Frontline house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}").when().post("/maps/api/place/add/json").
	      then().log().all().assertThat().statusCode(200).extract().response().asString();
	      System.out.println(respone);
	      JsonPath jp=new JsonPath(respone);
	      String plc = jp.get("place_id");
	      System.out.println(plc);
	      String address="70 winter walk, USA";
	      given().log().all().queryParam("place_id",plc ).queryParam("key","qaclick123").
	      header("Content-Type","application/json").
	      body("{\r\n"
	      		+ "\"place_id\":\""+plc+"\",\r\n"
	      		+ "\"address\":\""+address+"\",\r\n"
	      		+ "\"key\":\"qaclick123\"\r\n"
	      		+ "}").
	          when().put("/maps/api/place/update/json").
	          then().log().all().assertThat().statusCode(200);
	      given().log().all().queryParam("key","qaclick123")
	      .queryParam("place_id",plc).
	      when().get("/maps/api/place/update/json").
	      then().log().all().assertThat().statusCode(200);
	      
	      
}
public static void main(String[] args) {
	restTesst();
}
}
