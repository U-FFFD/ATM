import java.util.Scanner;

public class BSim{
	
	private Scanner scan = new Scanner(System.in);
	private ATM atm;				//Create ATM to run simulator off of
	private int value;
	private String accountNum;	//User inputs that will be used
	private	String pin;
	private int balance;
	
	public BSim(ATM timeMachine)
	{
		atm = timeMachine;
		value = 0;
		accountNum = null;
		pin = null;
		balance = 0;
	}

	private boolean goodAccount = false;	
	
	public void execute()
	{
		outerloop: for (int i =0; i <3; i++)	//3 attempts for account number
		{
			System.out.println("Enter an account number");
			accountNum = scan.nextLine();	
			
			if(atm.cardInserted(accountNum) == true)//Get account number from user and verify it	
			{
				for(int x = 0; x < 3; x++)	//3 attempts for PIN number
				{
					System.out.println("Enter your PIN number");
					pin = scan.nextLine();
					
					if(atm.checkPin(pin) == true) // CHECK PIN NUMBER
					{
						goodAccount = true;	//pin and account are good
						break outerloop;
					}
					else //if pin number is incorrect, try again
					{
						if(x<2)
						{
							System.out.println("Invalid PIN, try again.");
							System.out.println();
						}
						else
						{
							System.out.println("Too many failed attempts, ending...");
							atm.close();
							goodAccount = false;
							break outerloop;
						}
					}	
				}
			}
			else	//If account number isnt true, try again
			{
				if(i<2) 
				{
					System.out.println("Invalid account number, try again.");
					System.out.println();
				}
				else// Last attempt at account number
				{
					System.out.println("Too many failed attempts, ending...");
					atm.close();
					goodAccount = false;
					break;
				}
			}	
		}
		
		if(goodAccount)  //accountNum and PIN have been verified
		{
			for(int attempts = 0; attempts < 3; attempts++)	//Only allows 3 attempts from user
			{
				System.out.println("Enter 'D' to deposit cash, or 'W' to withdraw cash");
				String input = scan.nextLine();
				
				if(input.equals("W") || input.equals("w"))	//upper or lowercase to withdraw
				{
					System.out.println("Enter the amount to withdraw");
					value = scan.nextInt();
					
					try	//Attempt withdrawal, throw exception if it fails because of balance
					{
						if(value >= 0)		//Make sure user input isnt negative
						{
						balance = atm.withdraw(value);
						System.out.println("Amount withdrawn: " + value);
						break;
						}
					}
					catch(Exception e)
					{
					System.out.println(e.getMessage());
					System.out.println();
					break;
					}
					
				}
				
				if(input.equals("D") || input.equals("d"))	//upper or lowercase to deposit
				{
					System.out.println("Enter the amount to deposit");
					value = scan.nextInt();
					
					if(value >= 0)		//Make sure user input isn't negative
					{
					balance = atm.deposit(value);
					System.out.println("Amount deposited: " + value);
					break;
					}
				}
				
				if(attempts < 2)	//Last attempt on entering W or D
				{
					System.out.println("Invalid input, try again");
				}
				else
				{
						System.out.println("Too many invalid inputs, ending...");
						break;
				}
				
				
			}
		System.out.println("Current balance: " + balance);
		}	
		System.out.println("Thank you for choosing U+FFFD Banking Systems! Have a nice day.");
	}
		public static void main(String args[])
		{
			Bank myBank = new Bank();
			myBank.createAccount("1234", "6789", 80);
			myBank.createAccount("6789", "4321", 60);
			ATM theFitchATM = new ATM(myBank);
			BSim bsim = new BSim(theFitchATM);
			bsim.execute();
		}
}
