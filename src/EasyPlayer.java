public class EasyPlayer implements IPlayer {

    OceanGrid aiOceanGrid = new OceanGrid();
    TargetGrid aiTargetGrid = new TargetGrid();
    ShipFactory aiShipFactory = new AutomaticShipFactory();

    @Override
    public String getName() {
        return "Shooter in the dark";
    }

    @Override
    public Coordinate takeShot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'takeShot'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shipsAreSunk'");
    }

    @Override
    public void placeShips() {
        aiOceanGrid.addShips(aiShipFactory);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecentSunkShip'");
    }
    
}
