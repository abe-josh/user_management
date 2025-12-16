package java.dto;

import java.time.LocalDateTime;

public class UserDTO {
	private long userId;
	private String userName;
	private String email;
	private long mobileNumber;
	private LocalDateTime dateOfBirth;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
