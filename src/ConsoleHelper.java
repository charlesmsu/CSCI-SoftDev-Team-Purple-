import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

    public static String getInput(final String prompt) {
        String inStr = "";
        System.out.print(prompt);
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    public static int getInputWithInRange(String prompt, int min, int max){
        int inInt = 0;
        String inStr = "";
        System.out.print(prompt);

        try {
            inStr = reader.readLine();
            try {
                inInt = Integer.parseInt(inStr);
                if(inInt > max || inInt < min){
                    System.out.println("You must enter an integer between " + min + " and " + max + ".");
                    inInt = getInputWithInRange(prompt, min, max); // Recursively call until valid input
                }
            } catch(NumberFormatException e) {
                System.out.println("You must enter a number");
                inInt = getInputWithInRange(prompt, min, max); // Recursively call until valid input
            }
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inInt;
    }

    public static String getShot() {
        String inStr = "";
        System.out.println("\n\n Where would you like to shoot? : ");
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    //will delay screen display so players can see animations ascii art
    public static void delayPrint(int seconds){
        seconds = 1000*seconds;
            try {
                Thread.sleep(seconds);  
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }
        //intended to clear screens inbetween player turns
        public static void clearScreen(int linesPrinted){

            for(int i=0; i < linesPrinted; i++){
                System.out.println();
            }
        }
    
    
}
