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

    public static String getInputWithInRange(String prompt, int min, int max){
        
        String inStr = "";
        System.out.print(prompt);
        
        
        
        try {
            inStr = reader.readLine();
            try{int inInt = Integer.parseInt(inStr);
                if(inInt > max || inInt < min){
                    System.out.println("You must enter an Integer within " + min +" and " + max+".");
                }
            }
            catch(Exception e){
            System.out.println("You must enter a number");}
            

        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    public static String getShot(){
        String inStr = "";
        System.out.println("\n\nWhere would you like to shoot? : ");
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
        
    }
}
