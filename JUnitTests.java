import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTests {
	
	// ACCOUNT TESTS
	@Test //DONE
	public  void validateAccount() {
		String pin = "5556";
		Account testAcc = new Account("1111", pin, 500);
		assertFalse(testAcc.validate("12358"));
		assertTrue(testAcc.validate("5556"));
	}
	@Test //DONE
	public  void widthdraw() throws Exception {
		Account testAcc = new Account("4444", "1234", 500);
		testAcc.withdraw(350);
		assertTrue(testAcc.getBalance() == 150);
	}
	@Test //DONE
	public  void deposit() {
		Account testAcc = new Account("1111", "1234", 200);
		testAcc.deposit(250);
		assertTrue(testAcc.getBalance() == 450);
	}
	@Test //DONE
	public  void widthdrawExceed() {
		Account testAcc = new Account("1234", "5555", 60);
		try {
			testAcc.withdraw(600);
		} catch (Exception e) {
			System.out.println("Withdrawl exceed test, expect err message: ");
			System.out.println(e.getMessage());
			assertTrue("Withdrawal amount exceeds balance".equalsIgnoreCase(e.getMessage()));
		}		
	}
	//END ACCOUNT
	
	// BANK TESTS
	public  void bankTest() {
		Bank testBank = new Bank();
		String pin2 = "4444";
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		Account testAcc = testBank.validate("1333");
		assertTrue(testAcc.getBalance() == 20);
		assertTrue(testAcc.validate(pin2));
	}
	// END BANK
	
	// ATM TESTS	
	@Test
	public  void validateATM() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertFalse(atm.cardInserted("1666"));	//invalid account
		assertTrue(atm.cardInserted("8895"));	//valid account	
		atm.close();
	}
	@Test
	public  void checkPin() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertTrue(atm.cardInserted("1324"));
		assertFalse(atm.checkPin("1355")); //false entry
		assertFalse(atm.checkPin("79635532")); //very false entry
		assertTrue(atm.checkPin("1111")); 	//correct pin, should be true.
		atm.close();
	}
	@Test 
	public  void atmWithdraw() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertTrue(atm.cardInserted("1324"));
		atm.checkPin("1111");
		atm.withdraw(500);
		assertTrue(atm.getBalance() == (9000-500));
		atm.close();
	}
	
	@Test 
	public  void withdrawBadPin() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertTrue(atm.cardInserted("8895"));
		atm.checkPin("2222");
		atm.withdraw(100);
		assertFalse(atm.getBalance() == (200-100));
		atm.checkPin("1956");
		assertTrue(atm.getBalance() == 200);
		atm.close();
	}
	
	@Test 
	public  void atmDeposit() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertTrue(atm.cardInserted("8895"));
		assertTrue(atm.deposit(15) == -1);
		atm.checkPin("1956");
		atm.deposit(453);
		assertTrue(atm.getBalance() == 653);
		atm.close();
	}
	@Test
	public  void checkClosed() {
		Bank testBank = new Bank();
		testBank.createAccount("5568", "1325", 50);
		testBank.createAccount("1333", "4444", 20);
		testBank.createAccount("1324", "1111", 9000);
		testBank.createAccount("8895", "1956", 200);
		testBank.createAccount("0001", "7779", 0);
		ATM atm = new ATM(testBank); //start ATM with bank filled with accounts.
		assertTrue(atm.cardInserted("1324"));
		atm.checkPin("1111");
		atm.withdraw(500);
		assertTrue(atm.getBalance() == 8500);
		atm.deposit(600);
		assertTrue(atm.getBalance() == 9100);
		atm.close();
		assertTrue(atm.getBalance() == 0);
		assertTrue(atm.withdraw(500) == -1);
	}
	// END ATM
	
	//SIM TESTS
	/*
	public  void testSim() {
		System.out.println("\n Starting CLI...");
		//BSim simulator = new Bsim();
		ATM atm2 = new ATM();
		atm2.start();
		Account newAcc = Account();
	}
	*/
	// END SIM
}
