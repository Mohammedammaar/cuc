package com.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestOne {
public static void test() {
	try {
		FileReader read=new FileReader("C:\\Users\\HP\\eclipse-workspace\\ApiRest\\src\\test\\resources\\Test\\sample.json");
	    JSONParser pars= new JSONParser();
	    Object obj= pars.parse(read);
	    JSONObject jobj=(JSONObject)obj;
	    String name= (String) jobj.get("Name");
	    System.out.println(name);
	    String name1= (String) jobj.get("course");
	    System.out.println(name1);
	    JSONArray jarr= (JSONArray)jobj.get("subjects");
	    for (Object a : jarr) {
			System.out.println(a);
		}
	
	
	
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static void main(String[] args) {
	test();
}
}
