package exception;

public class TurnNotFound extends Exception{

	public TurnNotFound() {
		
	}
	
	public String msg() {
		String msg = "There aren't turns for attend";
		return msg;
	}
}
