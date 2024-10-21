public class WinnerDisplay {

    private Player player;
    private TargetGrid targetGrid;

    //constructor
    public WinnerDisplay(Player player, TargetGrid targetGrid) {
        this.player = player;
        this.targetGrid = targetGrid;
    }

    // announce the winner and print their final targetgrid
    public void printWinnerDisplay() {
        System.out.println(player.getPlayerName() + " WINS!!!");

        targetGrid.printGrid();
    }


    // Testing main method, will need to enter actual winning/losing logic eventually
    public static void main(String[] args) {
        // create a Player and set name
        Player player = new Player();
        player.setPlayerName("John");

        // Create a TargetGrid
        TargetGrid targetGrid = new TargetGrid();
        
        // Initialize the WinnerDisplay with the player and the target grid
        WinnerDisplay display = new WinnerDisplay(player, targetGrid);

        // print announcement and final grid
        display.printWinnerDisplay();
    }
}
