import java.util.Scanner;
import java.io.File;

public class Simulator{
  public Simulator(){

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
          in = new Scanner (new File(filename));
          System.out.println("Running file " + filename);
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

  private void parseCommand(String command)
  {
    //TODO: Parse the command sent in from the ATM, and print to console
  }

  public static void main (String args[]){
    Simulator sim = new Simulator();
    sim.run();
  }
}
