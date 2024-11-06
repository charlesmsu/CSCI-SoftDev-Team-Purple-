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
    boolean exit;

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
                    startOnePlayerGame();
                    ConsoleHelper.clearScreen(30);
                    System.out.println("Starting One Player Game...\n");
                    // select Computer level Difficulty
                    // start by getting the players names request player ones name first
                    // build the players grids then start
                    // ask how player one would like set ships on the screen manual or randomly
                    // add ships to players grid
                    // display ship grid wait for player input to continue
                    // computer player loop
                    // display shot as it is taken(computer shot at ex:b4)
                    // player ones turn

                    // will need to enter loop for the players to take shots on each others boards
                    // and update the grids
                    // if statement to show when a ship has sunk
                    // if true asscii art by the choosen one daniel-sun
                    // if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)

                    // Clear Screen method
                    // repeat the steps for player 2 below
                    // start by getting the players names request player 2 name
                    // build the players grids then start
                    // ask how player one would like set ships on the screen manual or randomly
                    // add ships to players grid
                    // display ship grid wait for player input to continue
                    // Clear Screen method

                    // will need to enter loop for the players to take shots on each others boards
                    // and update the grids
                    // if statement to show when a ship has sunk
                    // if true asscii art by the choosen one daniel-sun
                    // if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)
                    break;
                case 2:
                    ConsoleHelper.clearScreen(30);
                    System.out.println("Starting Two Player Game...\n");
                    // make players
                    addPlayer();
                    addPlayer();
                    buildPlayers();

                    // display ship grid wait for player input to continue

                    // Clear Screen method
                    ConsoleHelper.clearScreen(20);
                    playCycle();

                    // will need to enter loop for the players to take shots on each others boards
                    // and update the grids

                    // if statement to show when a ship has sunk
                    // if true asscii art by the choosen one daniel-sun
                    // if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)

                    break;

                case 3:
                    ConsoleHelper.clearScreen(30);
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
            player.getPlayerShips(player);
            // ask how player one would like set ships on the screen manual or randomly
            // add ships to players grid

            player.getTargetGrid().printGrid();
            player.getOceanGrid().printGrid();
            // display ship grid wait for player input to continue
            ConsoleHelper.getInput("Press Enter To Continue");
            // Clear Screen method
            ConsoleHelper.clearScreen(55);
        }
    }

    public void playCycle() {
        while (true) {
            CellState state;
            ConsoleHelper.getInput("It is " + players.get(0).getPlayerName() + "'s turn. \nPress Enter To Continue:");
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
                WinnerDisplay.printWinnerDisplay(players.get(0).getPlayerName(), players.get(0).getOceanGrid());
                break;
            }
            
            ConsoleHelper.getInput("Your Grids have been updated. \nPress Enter To Finish your turn:");
            ConsoleHelper.clearScreen(50);
    
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
            ConsoleHelper.clearScreen(50);
    
            if (players.get(0).checkShipCount()) {
                WinnerDisplay.printWinnerDisplay(players.get(1).getPlayerName(), players.get(1).getOceanGrid());
                break;
            }
        }
    }
    
    // Method to start one-player game mode
    private void startOnePlayerGame() {
        ConsoleHelper.clearScreen(30);
        System.out.println("Starting One Player Game (You vs. Computer)...");
    
        // Add human player
        Player humanPlayer = new Player();
        humanPlayer.promptForPlayerName();
        humanPlayer.getPlayerShips(humanPlayer);
        players.add(humanPlayer);
    
        // Add AI player
        Player aiPlayer = new AIPlayer();
        aiPlayer.getPlayerShips(aiPlayer);
        players.add(aiPlayer);
    
        playCycle();
    }
}    
