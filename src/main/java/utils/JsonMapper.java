package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import model.Model;

public class JsonMapper {
	
	public static String toJson(Model model) {
		System.out.println("JsonMapper toJson()"); 
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		try {
			return mapper.writeValueAsString(model);
		} catch (Exception e) {
			System.err.println("Failed to parse " + model.getClass() + " object to json.\n" + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
}
