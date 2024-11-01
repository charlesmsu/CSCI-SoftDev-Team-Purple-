public class TakeShotTest {
    public static void main(String[] args) {
        // setup the player's target grid and the opponent's hidden ocean grid
        TargetGrid targetGrid = new TargetGrid();
        OceanGrid oceanGrid = new OceanGrid(); // remains hidden from view

        // init takeshot
        TakeShot takeShot = new TakeShot();

        // run method and print only the shot result
        System.out.println("Testing promptAndTakeShot in TakeShot...");

        // sim taking a shot
        ShotResult result = takeShot.promptAndTakeShot(targetGrid, oceanGrid);
        System.out.println("Shot Result: " + result);  // Show result feedback only
        
        // display player's target grid after each shot to show shot history
        System.out.println("Player's Target Grid:");
        targetGrid.printGrid();
    }
}
