import java.util.HashMap;

public class Bank {
	
	private HashMap<String, Account> accounts;
	
	public Bank() {
		accounts = new HashMap<String,Account>();
	}
	
	public void createAccount(String accountNum, String accountPin, int balance) {
		Account a = new Account(accountNum, accountPin, balance);
		accounts.put(accountNum, a);
	}
	
	public Account validate(String accountNum) {
		if(accounts.containsKey(accountNum)) {
			return accounts.get(accountNum);
		}
		return null;
	}
}
