import static org.junit.Assert.assertTrue;

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
	@Test
	public static void newAccount() {
		
	}
	@Test
	public static void startATM() {
		ATM atm = new ATM();
	}
	@Test 
	public static void validateCard() {
		
	}
	@Test
	public static void validateAccount() {
		

	}
	@Test
	public static void widthdraw() {
		
	}
	public static void widthdrawExceed() {
		
		
	}
	public static void wrongPin(){
		int pin = 15328;
		atm.enterPin(pin); 	// call pin method of the ATM.
		

	}
	public static void 

}
