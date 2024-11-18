import java.util.List;
import java.util.ArrayList;

public abstract class ShipFactory {
    protected List<Ship> ships = new ArrayList<Ship>();

    public ShipFactory() {
        Constants.shipSpecifications.forEach((k, v) -> ships.add(new Ship(k, v)));
    }

    protected abstract Coordinate getStartCoordinate(Ship ship) throws Exception;

    protected abstract Direction getStartDirection(Ship ship) throws Exception;

    public List<Ship> getShips() {
        List<Ship> placedShips = new ArrayList<>();
        for (Ship ship : ships) {
            List<Coordinate> coords = new ArrayList<>();
            while (true) {
                try {
                    Coordinate start = getStartCoordinate(ship);
                    Direction dir = getStartDirection(ship);
                    coords = coordsWithLengthPositionedAtInDirection(ship.getLength(), start, dir);
                    ship.setCoordinates(coords);
                    if (shipOverLaps(ship, placedShips) == true) {
                        continue;
                    }

                } catch (Exception e) {
                    continue;
                }
                break;
            }
            placedShips.add(ship);
        }
        return ships;// this is returning the list w
    }

    public List<Coordinate> coordsWithLengthPositionedAtInDirection(int length, Coordinate start, Direction direction)
            throws Exception {
        List<Coordinate> shipsCoords = new ArrayList<>();
        shipsCoords.add(start);
        for (int i = 1; i < length; i++) {
            int nextRow = shipsCoords.get(i - 1).getRow();
            int nextColumn = shipsCoords.get(i - 1).getCol();
            switch (direction) {
                case NORTH -> nextRow -= 1;
                case SOUTH -> nextRow += 1;
                case EAST -> nextColumn += 1;
                case WEST -> nextColumn -= 1;
            }
            shipsCoords.add(new Coordinate(nextRow, nextColumn));
        }
        return shipsCoords;
    }
    protected List<Ship> getShipList() {
        return ships;
    }

    protected boolean shipOverLaps(Ship ship, List<Ship> ships) {
        for (Ship existingShip : ships) {
            List<Coordinate> existingShipCoords = existingShip.getCoordinates();
            for (Coordinate c : ship.getCoordinates()) {
                if(existingShipCoords.contains(c)){
                    return true;
                }
            }
        }
        return false;
    }
    public int numberOfSunkShips(){
        int count = (int) ships.stream().filter(ship -> ship.getLength() == ship.getHitCount()).count();

        return count;
    }
}
