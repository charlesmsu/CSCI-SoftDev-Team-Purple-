import java.util.Scanner;

public class SplashPageOptions {

    public void displayTitle(){
        System.out.print(
        "                                                                            \n" +    
        "██████   █████  ████████ ████████ ██      ███████ ███████ ██   ██ ██ ██████ \n" + 
        "██   ██ ██   ██    ██       ██    ██      ██      ██      ██   ██ ██ ██   ██\n" +
        "██████  ███████    ██       ██    ██      █████   ███████ ███████ ██ ██████ \n" +
        "██   ██ ██   ██    ██       ██    ██      ██           ██ ██   ██ ██ ██     \n" + 
        "██████  ██   ██    ██       ██    ███████ ███████ ███████ ██   ██ ██ ██     \n" +
        "\n"
        );
    }

    public void displayBattleshipArt() {
        System.out.print(
    "                                                                            \n" + 
    "                                       # #  ( )                             \n" +
    "                                    ___#_#___|__                            \n" +
    "                                _  |____________|  _                        \n"+            
    "                         _=====| | |            | | |==== _                 \n"+            
    "                   =====| |.---------------------------. | |====            \n" +            
    "     <--------------------'   .  .  .  .  .  .  .  .   '--------------/     \n" +            
    "       \\                                                             /     \n" +            
    "        \\_____________________________BATTLESHIP____________________/      \n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww   \n" +            
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWWWW\n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww     \n" +            
    "\n");
    }

    public void displayGameOptions() {
        System.out.println(
            "\n" +
            "To get started, choose one of the following options:\n" +
            "\n" +
            "1. Game Config (AI vs AI or AI vs Player) \n" +
            "2. Display Tutorial       \n" +
            "3. Start Game             \n" +
            "4. Exit                   \n" +
            "\n"
        );
    }

    public void promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;  // exit control variable

        while (!exit) {  // active loop until exit is true - option 4 works, path now open to add others and expand on current ones (1-3)
            displayTitle();
            displayBattleshipArt();
            displayGameOptions();

            System.out.print("Please enter your option (1-4): ");
            int choice;

            // ensure valid number input from user
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();  // clear invalid input
                continue;  // restart loop
            }

            switch (choice) {
                case 1:
                    System.out.println("Edit Player Configuration...");
                    // add functionality for changing new game config here - add stuff to meeeeee UwU
                    break;
                case 2:
                    System.out.println("Displaying Tutorial...");
                    Tutorial.displayTutorial();
                    break;
                case 3:
                    System.out.println("Starting the game...");
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

    public static void main(String[] args) {
        SplashPageOptions splashPage = new SplashPageOptions();
        splashPage.promptUserInput();
    }
}