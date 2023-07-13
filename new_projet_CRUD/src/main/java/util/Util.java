package util;

import org.mindrot.jbcrypt.BCrypt;

public class Util {
	public static String capitalize(String word) {
		if(word == null) {
			return word;
		} else {
			return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		}
	}
	
	public static String hashPassword(String mdp) {
		return BCrypt.hashpw(mdp, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String mdp, String mdpHash) {
		return BCrypt.checkpw(mdp, mdpHash);
	}
}
