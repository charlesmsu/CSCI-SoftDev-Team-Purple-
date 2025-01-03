// This class starts making the main menu input act like a goober when I close the scanner so I just left it open and it seems to work so far???? Might need to switch scanner to console helper getinputwithinrange method.

import java.util.Scanner;

public class WinnerDisplay {

    public WinnerDisplay() {// notes for cairo this will need to be the winning players. Player needs a getOceanGrid() method.


    }

    // announce the winner and print their winning ocean grid
    public static void printWinnerDisplay(String name, Grid oceanGrid) {
        System.out.println(Colors.YELLOW + "**************************************************" + Colors.RESET);
        System.out.println(Colors.YELLOW + "***** " + Colors.BLUE + name.toUpperCase() + " WINS!!! " + Colors.YELLOW + "*****");
        System.out.println(Colors.YELLOW + "**************************************************" + Colors.RESET);
        System.out.println();
        
        String formattedName = capitalizeFirstLetter(name);
        System.out.println(formattedName + "'s winning");

        oceanGrid.printGrid();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Prompt for 1 to return or 'x' to exit
        System.out.println("\nPress 1 to return to main menu\nPress 'x' to exit game");

        // Wait for user input
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Returning to the main menu...");
                // I think(? I could be wrong) this needs to be handled in the Game class, can't figure out how to do it from here
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

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
}