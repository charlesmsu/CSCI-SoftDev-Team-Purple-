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
    private List<Player> players = new ArrayList<>();
    boolean exit;
    public Game(){
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
                    ConsoleHelper.clearScreen(30);
                    System.out.println("Starting One Player Game");
                    //select Computer level Difficulty
                    //start by getting the players names request player ones name first
                    //build the players grids then start 
                    // ask how player one would like set ships on the screen manual or randomly
                        //add ships to players grid
                        //display ship grid wait for player input to continue
                    //computer player loop
                    //display shot as it is taken(computer shot at ex:b4)
                    //player ones turn


                     //will need to enter loop for the players to take shots on each others boards and update the grids
                        //if statement to show when a ship has sunk
                            //if true asscii art by the choosen one daniel-sun
                        //if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)

                    //Clear Screen method
                    //repeat the steps for player 2 below
                    //start by getting the players names request player 2 name
                    //build the players grids then start 
                    // ask how player one would like set ships on the screen manual or randomly
                        //add ships to players grid
                        //display ship grid wait for player input to continue
                    //Clear Screen method

                    //will need to enter loop for the players to take shots on each others boards and update the grids
                        //if statement to show when a ship has sunk
                            //if true asscii art by the choosen one daniel-sun
                        //if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)
                    break;
                case 2:
                    ConsoleHelper.clearScreen(30);
                    System.out.println("Starting Two Player Game");
                    //make players
                    addPlayer();
                    addPlayer();
                    buildPlayers();
                    
                    //display ship grid wait for player input to continue
                    ConsoleHelper.getInput("Press Enter Too Continue");
                    //Clear Screen method
                    ConsoleHelper.clearScreen(20);
                    buildPlayers();
                    
                    //will need to enter loop for the players to take shots on each others boards and update the grids
                    
                        //if statement to show when a ship has sunk
                            //if true asscii art by the choosen one daniel-sun
                        //if no ships left then we will display the WinnerDisplay

                    // added a ConsoleHelper Clear Screen method - ex:
                    // Consolehelper.clearScreen(number of lines you want to print to clear the
                    // screen)

                    TargetGrid grid = new TargetGrid();
                    grid.printGrid();

                    OceanGrid grid2 = new OceanGrid();
                    grid2.printGrid();
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
    public void addPlayer(){
        this.players.add(new Player());
    }

    public void buildPlayers(){
        for(Player player : players){
            ConsoleHelper.getInput("Create new player:");
            player.promptForPlayerName();
            player.getPlayerShips(player);
            // ask how player one would like set ships on the screen manual or randomly
            //add ships to players grid
            player.getOceanGrid().printGrid();
            player.getTargetGrid().printGrid();
            //display ship grid wait for player input to continue
            ConsoleHelper.getInput("Press Enter Too Continue");
            //Clear Screen method
            ConsoleHelper.clearScreen(20);
        }
    }
    
    // some two player game functionality i'm putting in as part of DisplayPlayersTurn(), can be used, doesn't have to, just figured it would be useful to have on standby if the time came
    
    // public void startTwoPlayerGame() {
    //    Player player1 = new Player();
    //    Player player2 = new Player();
    //    player1.promptForPlayerName();
    //    player2.promptForPlayerName();

    //    TargetGrid player1TargetGrid = new TargetGrid();
    //    OceanGrid player1OceanGrid = new OceanGrid();
    //    TargetGrid player2TargetGrid = new TargetGrid();
    //    OceanGrid player2OceanGrid = new OceanGrid();

    //    SwitchPlayers switchPlayers = new SwitchPlayers(player1, player2, player1TargetGrid, player1OceanGrid, 
    //                                                    player2TargetGrid, player2OceanGrid);

    //    while (!gameOver) {
    //        ShotResult result = switchPlayers.playTurn();
    //        gameOver = checkForWinner(switchPlayers);
    //    }

    //    System.out.println("Game over! Thanks for playing.");
    //}

    // private boolean checkForWinner(SwitchPlayers switchPlayers) {
    //    OceanGrid opponentOceanGrid = switchPlayers.getOpponentOceanGrid();
    //    if (opponentOceanGrid.allShipsSunk()) {
    //        System.out.println(switchPlayers.getCurrentPlayer().getPlayerName() + " wins!");
    //        return true;
    //    }
    //    return false;
    }
