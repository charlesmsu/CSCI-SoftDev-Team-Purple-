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
                    System.out.println(dir);
                    coords = coordsWithLengthPositionedAtInDirection(ship.getLength(), start, dir);
                    ship.setCoordinates(coords);
                    if (shipOverLaps(ship, placedShips) == true) {
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("A ship is already here");
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

    protected boolean shipOverLaps(Ship ship, List<Ship> ships) {
        for (Ship existingShip : ships) {
            List<Coordinate> existingShipCoords = existingShip.getCoordinates();
            for (Coordinate c : ship.getCoordinates()) {
                for (Coordinate ec : existingShipCoords) {
                    if (ec.equals(c)) {
                        System.out.println("there is no ship here");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
