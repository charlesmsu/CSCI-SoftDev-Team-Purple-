
public class Cell {
    private Ship ship = null;
    private CellState state;

    public Cell( CellState state){
        
        this.state = state;

    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state){
        if(this.state == state){
            String playerInput = ConsoleHelper.getShot();
            
        }
        this.state = state;
    }

    public Ship getShip(){
        return ship;
    }
    public void setShip(Ship ship){
        this.ship = ship;
    }

}