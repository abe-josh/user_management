package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import model.UserModel;

public class WriteToFile {
	
	private static final Path userFile = Paths.get("D:\\joshua\\web_app_java\\UserManagement\\src\\main\\webapp\\files\\user_data.json");
	
	public static boolean writeUserData(UserModel user) {
		System.out.println("WriteToFile writeUserData()"); 
		String userJson = JsonMapper.toJson(user);
		
		if(userJson == null) {
			System.out.println("User is null");
			return false;
		}
		
//		System.out.println(userFile);
//		System.out.println(userFile.toString());
//		System.out.println(userFile.toAbsolutePath());
//		System.out.println(userFile.toAbsolutePath().toString());
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(userFile.toString(), true));

			user.setCreatedDate(LocalDateTime.now());
			user.setUpdatedDate(LocalDateTime.now());
			
			writer.write(userJson + ",\n");
			writer.close();
			
			System.out.println("User data successfully saved to file.");
			
			return true;
			
		} catch (IOException e) {
			System.err.println("Failed to write user data to file.");
			e.printStackTrace();
		}
		
		return false;
	}
}
