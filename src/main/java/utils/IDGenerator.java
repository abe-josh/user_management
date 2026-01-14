package utils;

import java.util.List;
import java.util.Optional;

import model.UserModel;

public class IDGenerator {
	
	public static long generateUserId() {
		System.out.println("IDGenerator - generateUserId()");
		
		List<UserModel> userList = ReadFile.getUsers();
		long id = 0;
		
		Optional<Long> maxId = userList.stream().map(UserModel::getUserId).max(Long::compareTo);
		
		if(maxId.isPresent()) {
			id = maxId.get() + 1;
		}
		
		return id;
	}
}
