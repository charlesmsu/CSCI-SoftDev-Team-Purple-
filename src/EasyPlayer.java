import java.util.HashSet;
import java.util.Set;

public class EasyPlayer implements IPlayer {
    private OceanGrid aiOceanGrid;
    private TargetGrid aiTargetGrid;
    private AutomaticShipFactory aiShipFactory;
    private Set<Coordinate> attemptedShots;

    public EasyPlayer() {
        aiOceanGrid = new OceanGrid();
        aiTargetGrid = new TargetGrid();
        aiShipFactory = new AutomaticShipFactory();
        attemptedShots = new HashSet<>();
        placeShips(); // automatically place ships
    }

    @Override
    public String getName() {
        return "Rear Admiral (Lower Half)";
    }

    @Override
    public Coordinate takeShot() {
        Coordinate shot;
        do {
            shot = Coordinate.randomCoordinate();
        } while (attemptedShots.contains(shot));

        attemptedShots.add(shot);
        System.out.println(getName() + " shoots at " + shot);
        return shot;
    }

    @Override
    public ShotResult receiveShot(Coordinate shot) {
        return aiOceanGrid.receiveShot(shot);
    }

    @Override
    public void receiveShotResult(Coordinate shot, ShotResult shotResult) {
        aiTargetGrid.receiveShotResult(shotResult, shot);
    }

    @Override
    public boolean shipsAreSunk() {
        // Use a set to collect unique ships
        Set<Ship> shipsOnGrid = new HashSet<>();

        // Iterate through all OceanGrid cells
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Coordinate coordinate;
                try {
                    coordinate = new Coordinate(row, col);
                } catch (Exception e) {
                    continue;
                }
                Cell cell = aiOceanGrid.getCell(coordinate);
                Ship ship = cell.getShip();

                // Add ship to set if it exists
                if (ship != null) {
                    shipsOnGrid.add(ship);
                }
            }
        }

        // Check if all ships are sunk
        for (Ship ship : shipsOnGrid) {
            if (!ship.isSunk()) {
                return false; // If any ship is not sunk return false
            }
        }

        return true;
    }

    @Override
    public void placeShips() {
        for (Ship ship : aiShipFactory.getShips()) {
            aiOceanGrid.placeShip(ship);
        }
        //aiOceanGrid.addShips(aiShipFactory);
    }

    @Override
    public void printOceanGrid() {
        aiOceanGrid.printGrid();
    }

    @Override
    public void printTargetGrid() {
        aiTargetGrid.printGrid();
    }

    @Override
    public String getRecentSunkShip() {
        return "The Rear Admiral has sunk your ship!";
    }

}
