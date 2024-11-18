import java.util.HashSet;
import java.util.Set;

public class AIPlayer implements IPlayer {
    private String name; // player's name
    private OceanGrid oceanGrid; // player's ocean grid
    private TargetGrid targetGrid; // player's target grid
    private AutomaticShipFactory shipFactory; // ship factory for automatic placement
    private Set<Coordinate> attemptedShots; // track attempted shots

    public AIPlayer(String name) {
        this.name = name != null ? name : "AIPlayer"; // assign name
        this.oceanGrid = new OceanGrid(); // init player's ocean grid
        this.targetGrid = new TargetGrid(); // init player's target grid
        this.shipFactory = new AutomaticShipFactory(); // init automatic ship factory
        this.attemptedShots = new HashSet<>(); // init set for tracking shots
        placeShips(); // automatically place ships
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinate takeShot() {
        Coordinate shot;
        do {
            shot = Coordinate.randomCoordinate(); // gen random coord
        } while (attemptedShots.contains(shot)); // ensure unique shot

        attemptedShots.add(shot); // add shot to attempted shots
        System.out.println(name + " shoots at " + shot);
        return shot;
    }

    @Override
    public ShotResult receiveShot(Coordinate shot) {
        return oceanGrid.receiveShot(shot);
    }

    @Override
    public void receiveShotResult(Coordinate shot, ShotResult shotResult) {
        targetGrid.receiveShotResult(shotResult, shot);
    }

    @Override
    public boolean shipsAreSunk() {
        // Check if all ships in the OceanGrid are sunk
        Set<Ship> shipsOnGrid = new HashSet<>();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Coordinate coordinate;
                try {
                    coordinate = new Coordinate(row, col);
                } catch (Exception e) {
                    continue;
                }
                Cell cell = oceanGrid.getCell(coordinate);
                Ship ship = cell.getShip();

                if (ship != null) {
                    shipsOnGrid.add(ship);
                }
            }
        }
        for (Ship ship : shipsOnGrid) {
            if (!ship.isSunk()) {
                return false; // if any ship is not sunk, return false
            }
        }
        return true; // all ships sunk
    }

    @Override
    public void placeShips() {
        oceanGrid.addShips(shipFactory);
    }

    @Override
    public void printOceanGrid() {
        oceanGrid.printGrid();
    }

    @Override
    public void printTargetGrid() {
        targetGrid.printGrid();
    }

    @Override
    public OceanGrid getOceanGrid() {
        return oceanGrid;
    }

    @Override
    public String getRecentSunkShip() {
        return "AIPlayer has sunk your ship!"; // message
    }
}
