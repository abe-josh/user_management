package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

	public static String hashPassword(String password) {
		// define a cost factor (work factor)
		int logRounds = 12;
		
		// generate salt
		String salt = BCrypt.gensalt(logRounds);
		
		// hash the password with the salt
		return BCrypt.hashpw(password, salt);
	}
}
