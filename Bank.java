import java.util.HashMap;

public class Bank {
	
	private HashMap<String, Account> Accounts;
	
	public Bank() {
		Accounts = new HashMap<String,Account>();
	}
	
	public void createAccount(String accountNum, String accountPin, int balance) {
		Account a = new Account(accountNum, accountPin, balance);
		Accounts.put(accountNum, a);
	}
	
	public Account validate(String accountNum) {
		if(Accounts.containsKey(accountNum)) {
			return Accounts.get(accountNum);
		}
		return null;
	}
}
