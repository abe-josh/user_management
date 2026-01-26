package service;

import java.util.List;

import dto.UserDTO;
import model.UserModel;

public interface UserService {
	
	public boolean addUser(UserModel user);
	public UserModel updateUser(UserModel user);
	public UserModel getUser(String username);
	public void deleteUser(String username);
	public List<UserDTO> getUsers();
	public boolean validateUser(String username, String password);
	public long validateUser1(String username, String password);
}
