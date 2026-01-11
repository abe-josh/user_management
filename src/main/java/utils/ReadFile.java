package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import model.UserModel;

public class ReadFile {
	
	private static final Path userFile = Paths.get("D:\\joshua\\web_app_java\\UserManagement\\src\\main\\webapp\\files\\user_data.json");
	
	public static List<UserModel> getUsers() {
		System.out.println("ReadFile - getUsers()");
		List<UserModel> userList = new ArrayList<UserModel>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(userFile.toFile()));
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			
			String line;
			
			while((line = reader.readLine()) != null) {
				userList.add(mapper.readValue(line, UserModel.class));
			}
			
			reader.close();
			
			System.out.println("User data has been read successfully from users file.");
			System.out.println(userList);
			
		} catch (Exception e) {
			System.out.println("Failed to read data from file " + userFile.getFileName() + ".\n" + e.getMessage());
			e.printStackTrace();
		}
		
		return userList;
	}
}
