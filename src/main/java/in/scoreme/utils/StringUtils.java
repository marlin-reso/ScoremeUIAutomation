package in.scoreme.utils;

public class StringUtils {
	
	public static String getRandomEmailId() {

		String emailId = "testautomation" + System.currentTimeMillis() + "@opencart.com";
		return emailId;

	}

}
