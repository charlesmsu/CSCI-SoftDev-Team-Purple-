public class OceanGrid extends Grid{
    public OceanGrid() {
        super();

    }

    @Override
    public void printGrid() {

        System.out.println("Ocean Grid:");

        String rowName = "";
        printDivider();
        printHeader();
        printDivider();
        for (int row = 0; row < 10; row++) {

            switch (row) {
                case 0:
                    rowName = "| A |";
                    break;
                case 1:
                    rowName = "| B |";
                    break;
                case 2:
                    rowName = "| C |";
                    break;
                case 3:
                    rowName = "| D |";
                    break;
                case 4:
                    rowName = "| E |";
                    break;
                case 5:
                    rowName = "| F |";
                    break;
                case 6:
                    rowName = "| G |";
                    break;
                case 7:
                    rowName = "| H |";
                    break;
                case 8:
                    rowName = "| I |";
                    break;
                case 9:
                    rowName = "| J |";
                    break;

            }
            System.out.print(rowName);
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
            System.out.println();
            printDivider();

        }

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
