package model;

public class Turn {

	//constants
	public final static boolean ATTENDED = true;
	public final static boolean UNANTTENDED = false;
	
	//atributes
	public int num;
	public char letter;
	public boolean status;
	
	//constructor
	public Turn(int num, char letter) {
		super();
		this.num = num;
		this.letter = letter;
		this.status = false;
	}
	
	//getters y setters
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toString() {
		String msg = "Turn [" + letter + num +"]";
		return msg;
		
	}
	
	
}
