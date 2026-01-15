package utils;

import java.util.List;
import java.util.Optional;

import model.UserModel;

public class IDGenerator {
	
	public static long generateUserId() {
		System.out.println("IDGenerator - generateUserId()");
		
		List<UserModel> userList = ReadFile.getUsers();
		long id = 0;
		
		for(UserModel user : userList) {
			id = Math.max(id, user.getUserId());
		}
		
//		System.out.println("userList size : " + userList.size());
//		
//		for(int i = 0; i < userList.size() - 1; i++) {
//			int k = i + 1;
//			if(userList.get(i).getUserId() > userList.get(k).getUserId()) {
//				id = userList.get(i).getUserId();
//			} {
//				id = userList.get(k).getUserId();
//			}
//			
//			id = Math.max(userList.get(i).getUserId(), userList.get(i + 1).getUserId());
//		}
		
//		Optional<Long> maxId = userList.stream().map(UserModel::getUserId).max(Long::compareTo);
//		
//		if(maxId.isPresent()) {
//			id = maxId.get() + 1;
//		}
		
		return id + 1;
	}
}
