public class WinnerDisplay {

    private Player player;
    private OceanGrid oceanGrid;

    public WinnerDisplay(Player player, OceanGrid oceanGrid) {// notes for cairo this will need to be the winning players. Player needs a getOceanGrid() method.
        
        this.player = player;
        this.oceanGrid = oceanGrid;
    }

    // announce the winner and print their final oceangrid
    public void printWinnerDisplay() {
        System.out.println(player.getPlayerName() + " WINS!!!");

        oceanGrid.printGrid();
    }
}
