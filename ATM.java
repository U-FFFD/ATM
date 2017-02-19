/* Owen Monsma
   CS361
   15 February 2017
*/
// eddited by Emmett W
class ATM{
  private static Bank theBank;

  private Account currAccount;
  private boolean validated;

  public ATM(){
    this(new Bank());
  }

  public ATM(Bank bank){
    // Shell and test: create bank with test cases and pass using this constructor
    theBank = bank;
    currAccount = null;
    validated = false;
  }

  public boolean cardInserted(String accountNum){
    // validates with Bank that the account number is valid
    currAccount = theBank.validate(accountNum);
    // returns whether account exists
    return (this.currAccount != null);
  }

  public boolean checkPin(String pin){
    // checks the inputted PIN
    if (currAccount != null){
      return validated = currAccount.validate(pin);
    }
    else{
      return validated = false;
    }
  }

  public int withdraw(int amount){
    // attempts to withdraw specified amount from account, returns new balance (-1 on invalid)
    if (validated) {
      try {
        currAccount.withdraw(amount);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    return currAccount.getBalance();
    }
    return -1;
  }
   
  public int getBalance() {
	  if (validated) {
		  return currAccount.getBalance();
	  }
	  else {
		//balance could be negative so safest to return 0 on invalid account
		  return 0; 
	  }
  }

  public int deposit(int amount){
    // deposits amount. Returns new balance (-1 on invalid)
    if (validated) {
      return this.currAccount.deposit(amount);
    }
    return -1;
  }

  public void close(){
    // closes connection to the account
    this.currAccount = null;
    this.validated = false;
  }
}
