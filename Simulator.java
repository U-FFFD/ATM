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

    while 

  }

  public static void main (String args[]){
    Simulator sim = new Simulator();
    sim.run();
  }
}
