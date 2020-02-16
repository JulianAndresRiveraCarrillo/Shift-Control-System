package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import exception.InputException;
import exception.TurnNotFound;
import exception.UserNotFoundException;
import model.Control;
import model.Turn;
import model.User;

class ControlTest {

	Control co = new Control();;
	User u;
	
	void Setup1() {
		u = new User("TI", "100658947", "andres", "cordoba", 300595465, "Calle 73 # 3-69");
	}
	
	void Setup2() throws InputException {
		co.addUser("CC","123456789", "Pepito","Perez",3009596,"calle 30 # 3-89 ");
	}
	
	void Setup3() throws InputException {
		u = new User("PA", "1006549872", "Federico", "Prieto", 300595436, "Calle 70 # 3-56");
		co.addUser("PA", "1006549872", "Federico", "Prieto", 300595436, "Calle 70 # 3-56");
		
	}
	
	void Setup4() throws InputException, UserNotFoundException {
		co.addUser("CC", "1006051976", "Armando", "Paredes", 300595436, "Calle 50 # 3-70");
		co.addTurn("1006051976");
		}
	
	void Setup5() throws InputException {
		co.addUser("CC", "1006051976", "Armando", "Paredes", 300595436, "Calle 50 # 3-70");
		co.addUser("TI", "31899407", "Gloria", "Salamanc", 301528611, "Calle 70 # 3-90");
		co.addUser("CE", "19281218", "Armando", "Paredes", 316441558, "Calle 50 # 3-10");
		co.addUser("PA", "1234568975", "Armando", "Paredes", 301528353, "Calle 50 # 3-00");
	}
	
	@Test
	void addUserTest1() {
		try {
			assertTrue(co.addUser("TI", "100658947", "andres", "cordoba", 300595465, "Calle 73 # 3-69").equals("The user has been created"));
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void addUserTest2() {
		try {
			Setup2();
			assertEquals("The user is already created",co.addUser("CC","123456789", "Pepito","Perez",3009596,"calle 30 # 3-89 "));
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	void addUserTest4() {
		try {
			Setup5();
			assertTrue(co.addUser("CC", "1006051976", "Armando", "Paredes", 300595436, "Calle 50 # 3-70").equals("The user is already created"));
			assertTrue(co.addUser("TI", "31899407", "Gloria", "Salamanc", 301528611, "Calle 70 # 3-90").equals("The user is already created"));
			assertTrue(co.addUser("CE", "19281218", "Armando", "Paredes", 316441558, "Calle 50 # 3-10").equals("The user is already created"));
			assertTrue(co.addUser("PA", "1234568975", "Armando", "Paredes", 301528353, "Calle 50 # 3-00").equals("The user is already created"));
			assertTrue(co.addUser("CC","123456789", "Pepito","Perez",3009596,"calle 30 # 3-89 ").equals("The user has been created"));
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void searchUserTest() {
		Setup1();
		assertTrue("the user has not been created", co.searchUser("100658947") == null);
	}
	@Test
	void searchUserTest2() {
		try {
			Setup2();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = "123456789";
		co.searchUser(id);
		assertTrue(co.searchUser(id) != null);
	}
	
	void searchUserTest3() {
		assertTrue(co.searchUser("31899407") == null);
		assertTrue(co.searchUser("19281218") == null);
	}
	@Test
	void searchUserTest4() {
		User u2 = new User("CC", "123456798" , "Alexander", "Prieto", 315894650, "Calle 9 # 2-48");
		try {
			Setup3();
			co.addUser("CC", "123456798" , "Alexander", "Prieto", 315894650, "Calle 9 # 2-48");
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = "1006549872";
		String id2 = "123456798";
		assertTrue(co.searchUser(id).getId().equals(u.getId()));
		assertTrue(co.searchUser(id2).getId().equals(u2.getId()));
	}
	
	/*@Test
	void addTurnTest1() {
		try {
			Setup5();
			assertFalse("The client has a turn unattended",c.addTurn("1006051976").equalsIgnoreCase("the turn " + u.turn[0].toString() + " has been assigned to " + u.getName() + " " + u.getLastName()));
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}		
	}
	
	@Test
	void addTurnTest2() {
		
	}
	*/
	@Test
	void showTurnsTest() {
		try {
			Setup4();
		} catch (InputException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Turn [A0]", co.showTurns(), "The turns are the same");
	}
	
	@Test
	void setStatus() {
		try {
			Setup4();
			assertEquals("the Turn [A0] had been attended", co.setStatus('A', 0, "yes"));
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TurnNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
