public class Grid {
    protected Cell[][] cells = new Cell[10][10];
    
    private CellState state = CellState.EMPTY;
    

    public Grid(){
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++){
                cells[row][column] = new Cell(state);
            }
            
        }
    }

    protected void printDivider(){
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
    } 

    protected void printHeader(){
        System.out.println("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |10 |");
    }


    public void updateGridCells(int row) {
        for(int column = 0; column < 10; column++){
            if(cells[row][column].getState() == CellState.EMPTY){
                System.out.print("   |");
            }
            
        }
    }

    public void printGridName() {
        System.out.println("");
    }

    public void printGrid() {
        printGridName();

        String rowName = "";
        printDivider();
        printHeader();
        printDivider();
        for(int row = 0; row < 10 ; row++){
            
            switch(row){
                case 0 :
                rowName = "| A |";
                break;
                case 1 :
                rowName = "| B |";
                break;
                case 2 :
                rowName = "| C |";
                break;
                case 3 :
                rowName = "| D |";
                break;
                case 4 :
                rowName = "| E |";
                break;
                case 5 :
                rowName = "| F |";
                break;
                case 6 :
                rowName = "| G |";
                break;
                case 7 :
                rowName = "| H |";
                break;
                case 8 :
                rowName = "| I |";
                break;
                case 9 :
                rowName = "| J |";
                break;

            }
            System.out.print(rowName);
            updateGridCells(row);
            System.out.println();
            printDivider();
        }

    }


    protected Cell getCell(Coordinate coordinate){
        int r = coordinate.getRow();
        int c = coordinate.getCol();

        //use to find cell at coordinate
        Cell cell = cells[r][c];
        return cell;
    }

    protected CellState getCellState(Coordinate coordinate){
        

        //use to find cell at coordinate
        Cell cell = getCell(coordinate);

        //get state of cell, empyty or occupied
        CellState cs = cell.getState();
        return cs;

    }


    protected void setCellState(Coordinate coordinate, CellState state){
        

        //use to find cell at coordinate
        Cell cell = getCell(coordinate);

        //get state of cell, empty or occupied
        cell.setState(state);

    }

    protected void addShips(ShipFactory factory){
        for (Ship ship : factory.getShips()) {
            for(Coordinate cord: ship.getCoordinates()){
                setCellState(cord, CellState.OCCUPIED);
            }
       }
    }

    

}
