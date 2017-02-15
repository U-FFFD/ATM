import java.util.HashMap;

public class Bank {
	
	private HashMap<String, Account> Accounts = new HashMap<String,Account>();
	
	public void createAccount(String accountNum, String accountPin, int balance) {
		Account a = new Account(accountNum, accountPin, balance);
		Accounts.put(accountNum, a);
	}
	
	public void deposit(String accountNum, int amount) throws Exception {
		if (validate(accountNum)) {
			Accounts.get(accountNum).deposit(amount);
		}
		else
			throw new Exception("Account does not exist");
	}
	
	public void withdraw(String accountNum, int amount) throws Exception {
		if (validate(accountNum)) {
			Accounts.get(accountNum).withdraw(amount);
		}
		else
			throw new Exception("Account does not exist");
	}
	
	public boolean validate(String accountNum) {
		if(Accounts.containsKey(accountNum)) {
			return true;
		}
		
		return false;
	}
}
