package model;

/**
 * this is the Turn class.<br>
 * @author julian andres rivera
 *
 */
public class Turn {

	/**
	 * these are the status of a turn.<br>
	 */
	//constants
	public final static boolean ATTENDED = true;
	public final static boolean UNANTTENDED = false;
	
	/**
	 * these are the attributes of a turns.<br> 
	 */
	public int num;
	public char letter;
	public boolean status;
	
	/**
	 * this is the constructor method of the class.<br>
	 * @param num the num of a turn.<br>
	 * @param letter the letter of a turn.<br>
	 */
	public Turn(int num, char letter) {
		super();
		this.num = num;
		this.letter = letter;
		this.status = UNANTTENDED;
	}
	
	//getters y setters
	/**
	 * this method receive the number of the turn.<br>
	 * @return the number of the turn.<br>
	 */
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * this method receive the letter of a turn.<br>
	 * @return the letter of the turn.<br>
	 */
	public char getLetter() {
		return letter;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	/**
	 * this method receive the status of the turn.<br>
	 * @return the status of the turn.<br>
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * this method change the status of the turn.<br>
	 * @param status the new status of the turn.<br>
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * this method help to show in the screen a turn.<br>
	 */
	public String toString() {
		String msg = "Turn [" + letter + num +"]";
		return msg;
		
	}
	
	
}
