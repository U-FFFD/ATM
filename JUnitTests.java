import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTests {

	public JUnitTests() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass\n Starting CLI.");
		BSim simulator = new Bsim();
	}
	@Test (expected = Exception.class)
	public static void newAccount() {
		//try random account number. 
		Bsim("12345");
		
	}
	@Test
	public static void startATM() {
		ATM atm = new ATM();
	}
	@Test 
	public static void validateCard() {
		
	}
	// ACCOUNT TESTS
	@Test //DONE
	public static void validateAccount() {
		String pin = "5556";
		Account testAcc = new Account("1111", pin, 500);
		assertFalse(testAcc.validate("12358"));
		assertTrue(testAcc.validate("5556"));
	}
	@Test //DONE
	public static void widthdraw() throws Exception {
		Account testAcc = new Account("4444", "1234", 500);
		testAcc.withdraw(350);
		assertTrue(testAcc.getBalance() == 150);
	}
	@Test //DONE
	public static void deposit() {
		Account testAcc = new Account("1111", "1234", 200);
		testAcc.deposit(250);
		assertTrue(testAcc.getBalance() == 450);
	}
	@Test //DONE
	public static void widthdrawExceed() {
		Account testAcc = new Account("1234", "5555", 60);
		try {
			testAcc.withdraw(600);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Withdrawal amount exceeds balance".equalsIgnoreCase(e.getMessage()));
		}		
	}
	//END ACCOUNT
	public static void wrongPin(){
		int pin = 15328;
		atm.enterPin(pin); 	// call pin method of the ATM.
		

	}
	public static void testSim() {
		
		ATM atm2 = new ATM();
		atm2.start();
		Account newAcc = Account();
	}

}
