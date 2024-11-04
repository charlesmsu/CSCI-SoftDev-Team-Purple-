public class OceanGrid extends Grid{
    public OceanGrid() {
        super();

    }

    @Override
    public void updateGridCells(int row) {
        for (int column = 0; column < 10; column++) {
            if (cells[row][column].getState() == CellState.OCCUPIED) {
                System.out.print(" S |");
            } else if (cells[row][column].getState() == CellState.HIT) {
                System.out.print(" X |");
            } else if (cells[row][column].getState() == CellState.MISS) {
                System.out.print(" O |");
            } else {
                System.out.print("   |");
            }

        }
    }

    @Override
    public void printGridName() {
        System.out.println("Ocean Grid:");
    }


    public void placeShip(Ship ship) {
        // look at ship coordinates and mark each as occupied
        for (Coordinate coordinate : ship.getCoordinates()) {

            setCellState(coordinate, CellState.OCCUPIED);
            Cell cell = getCell(coordinate);
            // also set cell's ship reference to this ship
            cell.setShip(ship);
        }

    }

    public ShotResult receiveShot(Coordinate coordinate) {

        Cell cell = getCell(coordinate);
        // get corrdinates from shot row/column
        CellState cs = cell.getState();
        // make descion
        if (cs == CellState.EMPTY) {
            setCellState(coordinate, CellState.MISS);
            return ShotResult.MISS;
        } else {
            Ship ship = cell.getShip();
            ship.registerHit();
            cell.setState(CellState.HIT);
            if (ship.isSunk() == true) {
                return ShotResult.SUNK;
            } else {
                return ShotResult.HIT;
            }
        }

    }
}
