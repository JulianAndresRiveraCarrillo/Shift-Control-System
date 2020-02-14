package exception;

public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
	}
	
	public String getMsg() {
		String msg = "User has not been found";
		return msg;
	}
	
}
