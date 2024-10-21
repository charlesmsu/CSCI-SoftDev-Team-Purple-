public class WinnerDisplay {

    private Player player;
    private OceanGrid oceanGrid;

    public WinnerDisplay(Player player, OceanGrid oceanGrid) {
        this.player = player;
        this.oceanGrid = oceanGrid;
    }

    // announce the winner and print their final oceangrid
    public void printWinnerDisplay() {
        System.out.println(player.getPlayerName() + " WINS!!!");

        oceanGrid.printGrid();
    }


    // Testing main method, will need to enter actual winning/losing logic eventually
    public static void main(String[] args) {
        // create a Player and set name
        Player player = new Player();
        player.setPlayerName("John");

        // Create an OceanGrid
        OceanGrid oceanGrid = new OceanGrid();
        
        // Initialize the WinnerDisplay with the player and the ocean grid
        WinnerDisplay display = new WinnerDisplay(player, oceanGrid);

        // print announcement and final grid
        display.printWinnerDisplay();
    }
}
