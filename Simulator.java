import java.util.Scanner;
import java.io.File;

public class Simulator{
  private ATM atm;

  public Simulator(){
    Bank theBank = new Bank();
    theBank.createAccount("1234", "6789", 80);
    theBank.createAccount("6789", "4321", 60);
    atm = new ATM(theBank);
  }

  public void run(){
    Scanner in = new Scanner(System.in);

    System.out.println("Enter simulation filename, or press Enter for manual mode: ");
    String filename = in.nextLine();
    // handle input for file or manual
    switch (filename){
      case "":
        System.out.println("Starting in manual mode.");
        break;
      default:
        try{
          System.out.println("Running file " + filename);
          parseTextFile(new File(filename);
        } catch (Exception e){
          System.out.println("File not found. Starting in manual mode.");
        }
        break;
    }

    // main simulation loop

    while (in.hasNextLine()) {
      //TODO: Take in user input, and send this input to the ATM via atm.parse()
    }

  }

  private void parseTextFile(file){
    Scanner in = new Scanner(file);

    while (in.hasNextLine()){
      String response = atm.parse(in.nextLine());
      parseCommand(response);
    }
  }

  private void parseCommand(String command)
  {
    //TODO: Parse the command sent in from the ATM, and print to console
  }

  public static void main (String args[]){
    Simulator sim = new Simulator();
    sim.run();
  }
}
