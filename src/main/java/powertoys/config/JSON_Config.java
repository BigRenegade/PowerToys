package powertoys.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Config {


	public void readJSONFile () {
	JSONParser parser = new JSONParser();
	
	try {
		
		Object obj = parser.parse(new FileReader("config/myJSON.json"));
		JSONObject JsonObject = (JSONObject) obj;
		String name = (String) JsonObject.get("Name");
		System.out.println(name);

		JSONArray courses = (JSONArray) JsonObject.get("Courses");
		Iterator<String> iterator = courses.iterator();

		System.out.println("Course:  ");
		
		while(iterator.hasNext()) {
			
			System.out.println("\t" + iterator.next());
			
			}
		
		String category = (String) JsonObject.get("Category");
		System.out.println(category);

		}
	
	catch(FileNotFoundException e) { e.printStackTrace(); }
	catch(IOException e) { e.printStackTrace(); }
	catch(ParseException e) { e.printStackTrace(); }
	catch(Exception e) { e.printStackTrace(); }
	}

	public void writeJSONFile () {
		JSONObject obj = new JSONObject();
		String blank = "{";
		obj.put("Name", "Kenny Lee");
		obj.put("Category", "record");
		
		
		
		JSONArray list = new JSONArray();
		
		list.add("Java");
		list.add("Minecraft");
		list.add("Coding");
		
		obj.put("Courses", list);
		
		try(FileWriter file = new FileWriter("config/myJSON.json")) {
			
			obj.writeJSONString(file);
			//file.write(obj.toJSONString());
			//file.flush();
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(obj);
	}


}
