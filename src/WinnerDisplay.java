public class WinnerDisplay {

    public WinnerDisplay() {// notes for cairo this will need to be the winning players. Player needs a getOceanGrid() method.
        
        
    }

    // announce the winner and print their final oceangrid
    public void printWinnerDisplay(String name, OceanGrid oceanGrid) {
        System.out.println(name + " WINS!!!");

        oceanGrid.printGrid();
    }
}
