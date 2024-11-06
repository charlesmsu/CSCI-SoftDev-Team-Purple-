public interface IPlayer {
    public String getName();
    public Coordinate takeShot();
    public ShotResult receiveShot(Coordinate shot);
    public void receiveShotResult(Coordinate shot, ShotResult shotResult);
    public boolean shipsAreSunk();
    public void placeShips();
    public void printOceanGrid();
    public void printTargetGrid();
    public String getRecentSunkShip();
}
