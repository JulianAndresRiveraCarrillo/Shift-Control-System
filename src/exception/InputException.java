package exception;

public class InputException extends Exception{

	int error;
	
	public InputException(int error) {
		super();
		this.error = error;
	}
	
	public String getMessage() {
		String msg = "";
		switch (error) {
		case 1:
			System.err.println("The document Type is obligatory. Please, write it");
			break;
		case 2: 
			System.err.println("The id is obligatory. Please, write it");
			break;
		case 3:
			System.err.println("The name is obligatory. Please, write it");
			break;
		case 4:
			System.err.println("The lastName is obligatory. Please, write it");
			break;
		}
		return msg;
	}
}
