import java.util.Scanner;
import java.util.List;
public class Player {
    private String playerName;
    private Coordinate shot;
    private ShipFactory factory;
    private Grid oceanGrid = new OceanGrid();
    private Grid targetGrid = new TargetGrid();
    private int shipCount = 0;

    // constructor that optionally accepts a name
    public Player() {
        this.playerName = "";
    }

    // getter method to retrieve the player's name
    public String getPlayerName() {
        return playerName;
    }

    // setter method to set or update the player's name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // method to prompt the user for their name
    public void promptForPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        setPlayerName(name);
        System.out.println("Player name set to: " + getPlayerName());
    }


    public Grid getOceanGrid(){
        return oceanGrid;
    }
    public Grid getTargetGrid(){
        return targetGrid;
    }

    public void setShot(){
        try {
            this.shot = new Coordinate(ConsoleHelper.getShot());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getPlayerShips(Player player){
        int playerString = ConsoleHelper.getInputWithInRange("\nPress 1 to place your ships manually\nPress 2 to place your ships randomly: ",1,2);
        switch (playerString) {
            case 1:
                this.factory = new ManualShipFactory();
                this.oceanGrid.addShips(factory);
                break;
            case 2:
                this.factory = new AutomaticShipFactory();
                this.oceanGrid.addShips(factory);
                break;

        }
    }
    public Coordinate getShotCoordinate(){
        return shot;
    }
    public void updateTargetGrid(Coordinate shot, CellState state){
        CellState tState =targetGrid.getCellState(shot);
            if(tState.equals(CellState.EMPTY)){
                targetGrid.setCellState(shot, state);
            }
    }
    public CellState checkShotOceanGrid(Coordinate shot){
        List<Ship> ships = factory.getShips();
        List<Coordinate> coords;

        CellState state = oceanGrid.getCellState(shot);
        switch (state) {
            case CellState.OCCUPIED:
                System.out.println("You have hit the Ship");
                oceanGrid.setCellState(shot, CellState.HIT);
                for (Ship ship : ships){
                    if(ship.getCoordinates().contains(shot)){
                        ship.addHitCount();
                        if(ship.isSunk()== true){
                            System.out.println("The "+ ship.getShipName() +" ship has sunk");
                            shipCount +=1;
                        }
                    }

                }
                state = CellState.HIT;
                break;
            case CellState.HIT :
                System.out.println("You have hit the Ship already");
                break;
            case CellState.MISS :
                System.out.println("You have hit this cell already");
                break;
            case CellState.EMPTY:
                System.out.println("You have missed");
                oceanGrid.setCellState(shot, CellState.MISS);
                state = CellState.MISS;
                break;
        }
        return state;

    }
    public boolean checkShipCount(){
        if(shipCount==5){
            return true;
        }
        return false;
    }

}
