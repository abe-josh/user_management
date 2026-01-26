package service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

import model.Session;
import utils.WriteToFile;

public class SessionService {
	
	public String createSession(long userId)  {
		
		Session userSession = new Session();
		LocalDateTime now = LocalDateTime.now();
		String sessionId = generateSessionId();
		
		userSession.setSessionId(sessionId);
		userSession.setUserId(userId);
		userSession.setLoginTime(now);
		userSession.setActive(true);
		userSession.setRememberMe(false);
		userSession.setLastActivity(now);
		userSession.setExpiresAt(now.plusMinutes(15));
		
		if(WriteToFile.writeSessionData(userSession)) {
			return sessionId;
		}
		
		return null;
	}
	
	private String generateSessionId() {
		SecureRandom random = new SecureRandom();
		byte[] sessionId = new byte[32];
		random.nextBytes(sessionId);
		
		String session = Base64.getUrlEncoder().withoutPadding().encodeToString(sessionId);
		
		return session;
	}

}
