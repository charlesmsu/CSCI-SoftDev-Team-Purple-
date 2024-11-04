
public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    @Override
    public void updateGridCells(int row) {
        for(int column = 0; column < 10; column++){
                
            if(cells[row][column].getState() == CellState.HIT){
                System.out.print(" X |");
            }else if(cells[row][column].getState() == CellState.MISS){
                System.out.print(" O |");
            }else{
                System.out.print("   |");
            }
            
        }
    }

    @Override
    public void printGridName() {
        System.out.println("Target Grid:");
    }

     // return true or false if the cell state is hit or miss 
     public boolean isShotValid(Coordinate coordinate) {
        

        //use to find cell at coordinate
        Cell cell = getCell(coordinate);

        //get state of cell, empyty or occupied
        CellState cs = cell.getState();

        if (cs == CellState.HIT) {
            return false;
        }

        if (cs == CellState.MISS) {
            return false;
        }
        return true;
    }
        

      
         
    

    public void receiveShotResult(ShotResult result, Coordinate coordinate) {
        Cell cell = getCell(coordinate);

        if (result == ShotResult.HIT || result == ShotResult.SUNK) {
            cell.setState(CellState.HIT);
        } else if (result == ShotResult.MISS){
            cell.setState(CellState.MISS);
        }

    }

}
    
  
