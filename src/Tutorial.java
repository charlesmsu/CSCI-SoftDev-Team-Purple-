// This class starts making the main menu input act like a goober when I close the scanner so I just left it open and it seems to work so far????

import java.util.Scanner;

public class Tutorial {

    public static void printOnePlayerRules() {
        System.out.println("One Player Mode (vs. Computer) Rules:");
        System.out.println("- The player places their ships on the grid.");
        System.out.println("- Ships cannot overlap and must be placed within the grid.");
        System.out.println("- The computer will randomly place ships on its grid.");
        System.out.println("- Take turns entering coordinates (Ex: A10) to fire at each other's grid.");
        System.out.println("- A hit is marked with 'X' and a miss with 'O'. Sunk ships are marked with 'S'. ");
        System.out.println("- The first to sink all five of the opponent's ships wins.");
    }

    public static void printTwoPlayerRules() {
        System.out.println("Two Player Mode Rules:");
        System.out.println("- Both players place their ships on the grid.");
        System.out.println("- Ships cannot overlap and must be placed within the grid.");
        System.out.println("- Players take turns entering coordinates (Ex: A10) to fire at each other's grid.");
        System.out.println("- A hit is marked with 'X' and a miss with 'O'. Sunk ships are marked with 'S'.");
        System.out.println("- The first player to sink all five of the opponent's ships wins. \n");
    }

    public static void displayTutorial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("TUTORIAL");
        System.out.println("______________________________________________________");
        printOnePlayerRules();
        System.out.println("______________________________________________________");
        printTwoPlayerRules();
        System.out.println("______________________________________________________");

        // Prompt for 1 to return or 'x' to exit
        System.out.println("\nPress 1 to return to main menu\nPress 'x' to exit game");

        // Wait for user input
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Returning to the main menu...");
                break;
            } else if (input.equalsIgnoreCase("x")) {
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);  // Exit
                break;
            } else {
                // Invalid input
                System.out.println("Invalid input. Please press 1 to return to the main menu or 'x' to exit game.");
            }
        }
    }
}
