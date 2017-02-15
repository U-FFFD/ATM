/* Owen Monsma
   CS361
   15 February 2017
*/
class ATM{
  private Account currAccount;
  private boolean validated;

  public cardInserted(String accountNum){
    // validates with Bank that the account number is valid
  }

  public boolean checkPin(String pin){
    // checks the inputted PIN
  }

  public int withdraw(int amount){
    // attempts to withdraw specified amount from account
  }

  public int deposit(int amount){
    // deposits specified amount in account
  }

  private void close(){
    // closes connection to the account
  }


}
