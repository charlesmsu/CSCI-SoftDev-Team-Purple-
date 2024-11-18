import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.util.Map.Entry;

public class HumanPlayer implements IPlayer{
    private String name;
    private Coordinate shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
    private List<Coordinate> shotList = new ArrayList<Coordinate>();
    
    
    protected ShipFactory builder;

    public HumanPlayer(String name, ShipFactory builder) {
        this.name = name;
        this.builder = builder;
    }

    @Override
    public void printOceanGrid(){
        this.oceanGrid.printGrid();
    }

    @Override
    public void printTargetGrid(){
        targetGrid.printGrid();
    }

    public void setOceanGrid(OceanGrid grid){
        this.oceanGrid = grid;
    }

    public String getName(){
        return name;
    }
    
   
    // row and column Position bool, random do and while return

   
    @Override
    public void placeShips(){
        for (Ship ship : builder.getShips()) {
            oceanGrid.placeShip(ship);
        }

    }


    
    @Override
    public Coordinate takeShot() {
        while (true){
           String input = ConsoleHelper.getInput("Take a Shot> ");
            try {
                shot  = new Coordinate(input);
                shotList.add(shot);
            } catch (Exception e){
                System.out.println("Invalid Shot");
               // explain to user of an invalid shot
               //continue while loop 
               continue;
            }
            
            if (targetGrid.isShotValid(shot)){
                return shot;
                
            }else {
            System.out.printf("You have already taken the Shot at %s%n", input);
            
            }
        }
    }
    @Override
    public ShotResult receiveShot(Coordinate shot) {
        return oceanGrid.receiveShot(shot);
    }
    @Override
    public void receiveShotResult(Coordinate shot, ShotResult result) {
        targetGrid.receiveShotResult(result, shot);
        
    }

    public Grid getOceanGrid() {
        return oceanGrid;
    }


    @Override
    public boolean shipsAreSunk() {
        if(oceanGrid.getSunkShips().size() >= 5){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getRecentSunkShip(){
        List<String> sunkShips = oceanGrid.getSunkShips();

        
        String mostRecentSunkShip = sunkShips.get(sunkShips.size()-1);
        return mostRecentSunkShip;

    }
}
