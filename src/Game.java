import java.util.Scanner;

public class Game {
    public Game(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;  // exit control variable
    
        while (!exit) {  // active loop until exit is true - option 4 works, path now open to add others and expand on current ones (1-3)
            int choice = ConsoleHelper.getInputWithInRange("Please enter your option (1-4): ", 1, 4);

            switch (choice) {
                case 1:
                    System.out.println("Edit Player Configuration...");
                    // add functionality for changing new game config here - add stuff to meeeeee UwU

                    //added a ConsoleHelper Clear Screen method - ex: Consolehelper.clearScreen(number of lines you want to print to clear the screen)
                    break;
                case 2:
                    System.out.println("Displaying Tutorial...");
                    Tutorial.displayTutorial();
                    break;
                case 3:
                    System.out.println("Starting the game...");
                    // add game start logic here - add stuff to meeeeee UwU

                    //added a ConsoleHelper Clear Screen method - ex: Consolehelper.clearScreen(number of lines you want to print to clear the screen)
                    TargetGrid grid = new TargetGrid();
                    grid.printGrid();

                    OceanGrid grid2 = new OceanGrid();
                    grid2.printGrid();
                    break;
                case 4:
                    System.out.println("Exiting the game. Goodbye!");
                    exit = true;  // break loop and exit
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
                    break;
            }

            // wait for user input before displaying options again
            if (!exit) {
                System.out.println("\nPress Enter to return to the menu...");
                scanner.nextLine();  // consume the newline character
                scanner.nextLine();  // wait for enter key
            }
        }
        scanner.close();  // close scanner after exiting
    }
    
}
