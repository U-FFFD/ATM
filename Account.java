/* Owen Monsma
   CS361
   15 February 2017
*/

public class Account {
  public Account(){
    this("0000", "0000", 0);
  }

  public Account(String accountNum, String accountPin, int balance) {
    this.accountNum = accountNum;
    this.accountPin = accountPin;
    this.balance = balance;
  }

  private String accountNum;
  private String accountPin;
  private int balance;

  public boolean validate(String pin) {
    return this.accountPin.equals(pin);
  }

  public int deposit(int amount) {
    return this.balance += amount;
  }

  public int withdraw(int amount) throws Exception{
    if (this.balance >= amount) {
      return this.balance -= amount;
    }
    else {
      throw new Exception("Withdrawal amount exceeds balance");
    }
  }

  public int getBalance() {
    return this.balance;
  }
}
