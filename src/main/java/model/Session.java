package model;

import java.time.LocalDateTime;

public class Session {
	
	private String sessionId;
	private long userId;
	private LocalDateTime loginTime;
	private boolean isActive;
	private boolean rememberMe;
	private LocalDateTime lastActivity;
	private LocalDateTime expiresAt;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	public LocalDateTime getLastActivity() {
		return lastActivity;
	}
	public void setLastActivity(LocalDateTime lastActivity) {
		this.lastActivity = lastActivity;
	}
	
	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", userId=" + userId + ", loginTime=" + loginTime + ", isActive="
				+ isActive + ", rememberMe=" + rememberMe + ", lastActivity=" + lastActivity + ", expiresAt="
				+ expiresAt + "]";
	}
	
}
