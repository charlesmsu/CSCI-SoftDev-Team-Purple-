import java.util.List;
import java.util.ArrayList;

//Call Game class
//make Game class
//call for splash page
//call for prompts
//make rule page
//call for both grids
//make prompt for shots
//prompt(new game or exit app) when game is over
//
public class Game {
    public List<Player> players = new ArrayList<>();
    public Coordinate cord;
    ShotResult result;
    boolean exit;
    Player player12;
    IPlayer player1;
    IPlayer cPlayer;

    public Game() {
        this.exit = false;

    }

    public void play() {
        SplashPageOptions gameOptions = new SplashPageOptions();
        boolean exit = false;

        while (exit == false) { // active loop until exit is true - option 4 works, path now open to add others
            // and expand on current ones (1-3)

            gameOptions.startScreen();
            int choice = ConsoleHelper.getInputWithInRange("Please enter your option (1-4): ", 1, 4);

            switch (choice) {
                case 1:

                    ConsoleHelper.clearScreen();
                    System.out.println("Starting One Player Game...\n");
                    int difficulty = ConsoleHelper.getInputWithInRange(
                            "Which difficulty would you like to play?\n Easy Mode(1) \n Medium Mode(2) \n Hard Mode(3) \n",
                            1, 3);
                    switch (difficulty) {
                        case 1:
                            cPlayer = new EasyPlayer();
                            break;
                        case 2:
                            cPlayer = new EasyPlayer();
                            break;
                        case 3:
                            cPlayer = new EasyPlayer();
                            break;

                    }
                    String name = ConsoleHelper.getInput("\nWhat is the Players name? ");
                    int option = ConsoleHelper.getInputWithInRange("\nHow would like to set your ships? \nAutomatically(1)\nManually ship factory(2)\n", 1, 2);
                    player1 = new HumanPlayer(name);
                    player1.getShipFactory(option);
                    player1.placeShips();
                    player1.printTargetGrid();
                    player1.printOceanGrid();
                    

                    cPlayer.placeShips();
                    cPlayer.printOceanGrid();
                    startOnePlayerGame(player1, cPlayer);

                    break;

                case 2:
                    ConsoleHelper.clearScreen();
                    System.out.println("Starting Two Player Game...\n");
                    // make players
                    addPlayer();
                    addPlayer();
                    buildPlayers();

                    ConsoleHelper.clearScreen();
                    playCycle();

                    break;

                case 3:
                    ConsoleHelper.clearScreen();
                    System.out.println("Displaying Tutorial...");
                    Tutorial.displayTutorial();
                    break;

                case 4:
                    System.out.println("Exiting the game. Goodbye!");
                    exit = true; // break loop and exit
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
                    break;
            }
        }

    }

    public void addPlayer() {
        this.players.add(new Player());
    }

    public void buildPlayers() {
        for (Player player : players) {
            System.out.println("Create new player:");
            player.promptForPlayerName();
            player.getPlayerShips();
            // ask how player one would like set ships on the screen manual or randomly
            // add ships to players grid

            player.getTargetGrid().printGrid();
            player.getOceanGrid().printGrid();
            // display ship grid wait for player input to continue
            ConsoleHelper.getInput("Press Enter To Continue");
            // Clear Screen method
            ConsoleHelper.clearScreen();
        }
    }

    public void startOnePlayerGame(IPlayer player1, IPlayer cPlayer) {


        while (true) {

            ConsoleHelper.getInput("\nIt is " + cPlayer.getName() + " turn.\nPress enter to continue.\n");
            cord = cPlayer.takeShot();
            result = player1.receiveShot(cord);
            cPlayer.receiveShotResult(cord, result);
            if (player1.shipsAreSunk() == true) {
                WinnerDisplay.printWinnerDisplay(cPlayer.getName(), cPlayer.getOceanGrid());
                break;
            }

            // player1s turn

            ConsoleHelper.getInput("It is your turn.\nPress enter to continue.\n");
            while (true) {

                try {
                    player1.printTargetGrid();
                    player1.printOceanGrid();
                    cord = new Coordinate(ConsoleHelper.getShot());
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid coordinate ex. b8.");
                    continue;

                }
            }
            result = cPlayer.receiveShot(cord);
            switch(result){
                case HIT:
                    System.out.println("\nYou Hit a ship!");
                    ConsoleHelper.getInput("Press Enter to continue.\n");
                    break;
                case MISS:
                    System.out.println("\nYou have Missed!");
                    ConsoleHelper.getInput("Press Enter to continue.\n");
                    break;
                case SUNK:
                    SplashPageOptions.displayShipSunk();
                    ConsoleHelper.getInput("Press Enter to continue.\n");
                    break;
            }
            player1.receiveShotResult(cord, result);
            // check if player has won
            if (cPlayer.shipsAreSunk() == true) {
                WinnerDisplay.printWinnerDisplay(player1.getName(), player1.getOceanGrid());
                break;
            }
            ConsoleHelper.clearScreen();

        }


    }

    public void playCycle() {
        while (true) {
            CellState state;
            ConsoleHelper.getInput("It is " + players.get(0).getPlayerName() + "'s turn.\nPress Enter To Continue:");
            players.get(0).getTargetGrid().printGrid();
            players.get(0).getOceanGrid().printGrid();

            while (true) {
                try {
                    cord = new Coordinate(ConsoleHelper.getShot());
                    state = players.get(1).checkShotOceanGrid(cord);
                    if (state == CellState.OCCUPIED) {
                        System.out.println("Try again");
                        continue;
                    }
                    players.get(0).updateTargetGrid(cord, state);
                    break;
                } catch (Exception e) {
                    ConsoleHelper.getInput("Please enter a valid coordinate (ex: b4)");
                }
            }

            players.get(0).getTargetGrid().printGrid();
            players.get(0).getOceanGrid().printGrid();

            if (players.get(1).checkShipCount()) {
                ConsoleHelper.clearScreen();
                WinnerDisplay.printWinnerDisplay(players.get(0).getPlayerName(), players.get(0).getOceanGrid());
                break;
            }

            ConsoleHelper.getInput("Your Grids have been updated. \nPress Enter To Finish your turn:");

            ConsoleHelper.clearScreen();

            ConsoleHelper.clearScreen();

            ConsoleHelper.getInput("It is " + players.get(1).getPlayerName() + "'s turn. \nPress Enter To Continue:");
            players.get(1).getTargetGrid().printGrid();
            players.get(1).getOceanGrid().printGrid();

            while (true) {
                try {
                    cord = new Coordinate(ConsoleHelper.getShot());
                    state = players.get(0).checkShotOceanGrid(cord);
                    if (state == CellState.OCCUPIED) {
                        System.out.println("Try again");
                        continue;
                    }
                    players.get(1).updateTargetGrid(cord, state);
                    break;
                } catch (Exception e) {
                    ConsoleHelper.getInput("Please enter a valid coordinate (ex: b4)");
                }
            }

            players.get(1).getTargetGrid().printGrid();
            players.get(1).getOceanGrid().printGrid();
            ConsoleHelper.getInput("Your Grids have been updated \nPress Enter to Finish your turn:");
            ConsoleHelper.clearScreen();

            if (players.get(0).checkShipCount() == true) {
                ConsoleHelper.clearScreen();
                WinnerDisplay.printWinnerDisplay(players.get(1).getPlayerName(), players.get(1).getOceanGrid());
                break;
            }
        }
    }

    // Method to start one-player game mode
    /*
     * private void startOnePlayerGame() {
     * ConsoleHelper.clearScreen();
     * System.out.println("Starting One Player Game (You vs. Computer)...");
     * 
     * // Add human player
     * Player humanPlayer = new Player();
     * humanPlayer.promptForPlayerName();
     * humanPlayer.getPlayerShips(humanPlayer);
     * players.add(humanPlayer);
     * 
     * // Add AI player
     * Player aiPlayer = new AIPlayer();
     * aiPlayer.getPlayerShips(aiPlayer);
     * players.add(aiPlayer);
     * 
     * playCycle();
     * }
     * public ShotResult convertCellstatetoShotResult(CellState state) {
     * ShotResult result;
     * if (state == CellState.HIT) {
     * result = ShotResult.HIT;
     * }
     * if (state == CellState.MISS){
     * result = ShotResult.MISS;
     * }
     * if (state == CellState.)
     */
}
