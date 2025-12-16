package model;

import java.time.LocalDateTime;

public class UserModel {
	private long userId;
	private String userName;
	private String email;
	private long mobileNumber;
	private LocalDateTime dateOfBirth;
	private String password;
	private String salt;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", dateOfBirth=" + dateOfBirth + ", password=" + password + ", salt=" + salt
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
