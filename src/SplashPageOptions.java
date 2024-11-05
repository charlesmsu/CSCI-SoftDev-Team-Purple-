import java.util.Scanner;

public class SplashPageOptions {

    public void displayTitle(){
        System.out.print(
            Colors.RED +
        "                                                                            \n" +    
        "██████   █████  ████████ ████████ ██      ███████ ███████ ██   ██ ██ ██████ \n" + 
        "██   ██ ██   ██    ██       ██    ██      ██      ██      ██   ██ ██ ██   ██\n" +
        "██████  ███████    ██       ██    ██      █████   ███████ ███████ ██ ██████ \n" +
        "██   ██ ██   ██    ██       ██    ██      ██           ██ ██   ██ ██ ██     \n" + 
        "██████  ██   ██    ██       ██    ███████ ███████ ███████ ██   ██ ██ ██     \n" +
        Colors.RESET +
        "\n"
        );
    }

    public void displayBattleshipArt() {
        System.out.print(
    "                                                                            \n" + 
    "                                       # #  ( )                             \n" +
    "                                    ___#_#___|__                            \n" +
    "                                _  |____________|  _                        \n" +            
    "                         _=====| | |            | | |==== _                 \n" +            
    "                   =====| |.---------------------------. | |====            \n" +            
    "     <--------------------'   .  .  .  .  .  .  .  .   '--------------/     \n" +            
    "       \\                                                             /     \n" +            
    "        \\_____________________________BATTLESHIP____________________/      \n" + 
    Colors.BLUE +           
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww   \n" +            
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWWWW\n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww     \n" +
    Colors.RESET +            
    "\n");
    }

    public static void displayShipSunk() {
        System.out.print(
    Colors.RED +
    "                                      ___                                   \n" +
    "                              __,-~~/~    `---.                             \n" +
    "                            _/_,---(      ,    )                            \n" +
    "                        __ /        <    /   )  \\___                       \n" +
    "         - ------===;;;'====------------------===;;;===----- -  -           \n" +
    "                           \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/                 \n" +
    "                           (_ (   \\  (     >    \\)                        \n" +
    "                            \\_( _ <         >_>'                           \n" +
    "                               ~ `-i' ::>|--\"                              \n" +
    "                                   I;|.|.|                                  \n" +       
    "     <--------------------'   .  . I;|.|.|.  .  .  .   '--------------/     \n" +            
    "       \\                         <|i::|i|`.                          /     \n" +            
    "        \\_______________________(` ^'\\\"`-' \\\")__________________/      \n" + 
    Colors.BLUE +           
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww   \n" +            
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww \n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww     \n" + 
    Colors.RESET +           
    "\n");
    }

    public void displayGameOptions() {
        System.out.println(
            "\n" +
            "To get started, choose one of the following options:\n" +
            "\n" +
            "1. Start One Player Game \n" +
            "2. Start Two Player Game      \n" +
            "3. Tutorial          \n" +
            "4. Exit                   \n" +
            "\n"
        );
    }

    public void startScreen(){
        displayTitle();
        displayBattleshipArt();
        //will delay the print of the game opptions so the player can see the title
        ConsoleHelper.delayPrint(2);

        displayGameOptions();
    }

    public void promptUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;  // exit control variable

        while (!exit) {  // active loop until exit is true - option 4 works, path now open to add others and expand on current ones (1-3)
            displayTitle();
            displayBattleshipArt();
            //will delay the print of the game opptions so the player can see the title
            ConsoleHelper.delayPrint(1);

            displayGameOptions();

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

    public static void main(String[] args) {
        SplashPageOptions splashPage = new SplashPageOptions();
        splashPage.promptUserInput();
    }
}