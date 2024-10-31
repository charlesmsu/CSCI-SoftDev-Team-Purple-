public class ManualShipFactory extends ShipFactory{  

    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        Coordinate manualCoordinate = null;
        while(true){
            try {String playerResponse = ConsoleHelper.getInput("Where would you like to place the " + ship.getShipName() + " : ");
                manualCoordinate = new Coordinate(playerResponse);
                break;
            } catch (Exception e) {
                
                System.out.println("Please try another coordinate");
            }       
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
                direction = Direction.EAST;
                break;
            case 3:
                direction =  Direction.SOUTH;
                break;
            case 4:
                direction =  Direction.WEST;
                break;
            }
            return direction;

        }
}
