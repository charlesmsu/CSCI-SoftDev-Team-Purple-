import java.util.HashSet;
import java.util.Set;

public class EasyPlayer implements IPlayer {

    OceanGrid aiOceanGrid = new OceanGrid();
    TargetGrid aiTargetGrid = new TargetGrid();
    ShipFactory aiShipFactory = new AutomaticShipFactory();
    Set<Coordinate> attemptedShots = new HashSet<>();

    @Override
    public String getName() {
        return "Shooter in the dark";
    }

    @Override
    public Coordinate takeShot() {
        Coordinate shot;
        do {
            shot = Coordinate.randomCoordinate(); // random coord
        } while (attemptedShots.contains(shot)); // no repeating shots

        attemptedShots.add(shot); // add shot to attempted set
        System.out.println(getName() + " shoots at " + shot); // show ai shot
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
        aiOceanGrid.addShips(aiShipFactory);
        System.out.println("aiplayers grid");
        aiOceanGrid.printGrid();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecentSunkShip'");
    }

}
