package service;

import java.util.List;

import dto.UserDTO;
import model.UserModel;
import utils.IDGenerator;
import utils.PasswordUtil;
import utils.ReadFile;
import utils.WriteToFile;

public class UserServiceImp implements UserService {
	@Override
	public boolean addUser(UserModel user) {
		System.out.println("UserServiceImp - addUser()");
		
		user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
		
		System.out.println(user.toString());
		
		long userId = IDGenerator.generateUserId();
		
		if(userId != 0)
		{
			user.setUserId(userId);
			return WriteToFile.writeUserData(user);
		}
		
		return false;
		
		//return WriteToFile.writeUserData(user);
	}
	
	@Override
	public boolean validateUser(String username, String password) {
		System.out.println("UserServiceImp - validateUser()");

		UserModel user = getUser(username);
		boolean isValidated = PasswordUtil.verifyPassword(password, user.getPassword());
		
		System.out.println("User inside UserServiceImp.validateUser() : " + user.toString());
		
		if(user != null) {
			if(isValidated) {
				System.out.println("user validated - true");
				return true;
			}
		}
		
		return false;
	}

	@Override
	public UserModel updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUser(String username) {
		System.out.println("UserServiceImp - getUser()");
		
		List<UserModel> userList = ReadFile.getUsers();
		
		for(UserModel user : userList) {
			if(user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<UserDTO> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
