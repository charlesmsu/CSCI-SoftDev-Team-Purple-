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
     if(aiShipFactory.numberOfSunkShips()==5) {
        return true;}
        else {
            return false;
        }
    }

    @Override
    public void placeShips() {
        for (Ship ship : aiShipFactory.getShips()) {
            aiOceanGrid.placeShip(ship);
        }
        System.out.println("aiplayers grid");
    }

    @Override
    public void printOceanGrid() {
        aiOceanGrid.printGrid();
    }
    public Grid getOceanGrid() {
        return aiOceanGrid;
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
