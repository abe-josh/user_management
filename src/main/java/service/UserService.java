package service;

import java.util.List;

import dto.UserDTO;
import model.UserModel;

public interface UserService {
	
	public UserDTO addUser(UserModel user);
	public UserDTO updateUser(UserDTO userDto);
	public UserDTO getUser(String username);
	public void deleteUser(String username);
	public List<UserDTO> getUsers();
	
}
