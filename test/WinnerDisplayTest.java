import java.util.ArrayList;
import java.util.List;

public class WinnerDisplayTest {

    public static void main(String[] args) throws Exception {
        OceanGrid oceanGrid = new OceanGrid();

        // Create test ships
        Ship ship1 = new Ship("Destroyer", 2);
        Ship ship2 = new Ship("Submarine", 3);

        // Coordinates for test ships
        List<Coordinate> ship1Coords = new ArrayList<>();
        ship1Coords.add(new Coordinate(0, 0));
        ship1Coords.add(new Coordinate(0, 1));
        ship1.setCoordinates(ship1Coords);

        List<Coordinate> ship2Coords = new ArrayList<>();
        ship2Coords.add(new Coordinate(2, 2));
        ship2Coords.add(new Coordinate(2, 3));
        ship2Coords.add(new Coordinate(2, 4));
        ship2.setCoordinates(ship2Coords);

        // Place test ships
        oceanGrid.placeShip(ship1);
        oceanGrid.placeShip(ship2);

        // Test hits/misses
        oceanGrid.receiveShot(new Coordinate(0, 0));
        oceanGrid.receiveShot(new Coordinate(2, 2));
        oceanGrid.receiveShot(new Coordinate(5, 5));
        oceanGrid.receiveShot(new Coordinate(8, 8));

        WinnerDisplay.printWinnerDisplay("Testymctester", oceanGrid);
    }
}
