package service;

import java.util.List;

import dto.UserDTO;
import model.UserModel;
import utils.PasswordUtil;

public class UserServiceImp implements UserService {
	@Override
	public UserDTO addUser(UserModel user) {
		System.out.println("UserServiceImp - addUser()");
		
		user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
		
		System.out.println(user.toString());
		
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUser(String username) {
		// TODO Auto-generated method stub
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
