import java.util.ArrayList;

public class ManualShipFactory extends ShipFactory{
    
    
    public ManualShipFactory() {
       
    }

    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        Coordinate manualCoordinate = null;
            try {String playerResponse = ConsoleHelper.getInput("Where would like to place" + ship.getShipName() + " : ");
                manualCoordinate = new Coordinate(playerResponse);
                
            } catch (Exception e) {
                
                System.out.println("Please try another coordinate");
            }       
            return manualCoordinate;
        }
    
    @Override
    protected Direction getStartDirection(Ship Ship){
        Direction direction = null;
        int playerInput = ConsoleHelper.getInputWithInRange("Please select a direction:\n" +
        "1. North\n" +
        "2. East\n" +
        "3. South\n" +
        "4. West\n",1,4);   

        switch (playerInput) {
            case 1:
                direction = Direction.NORTH;
                break;
            case 2:
                direction = Direction.SOUTH;
                break;
            case 3:
                direction =  Direction.EAST;
                break;
            case 4:
                direction =  Direction.SOUTH;
                break;
            }
            return direction;

        }
}
