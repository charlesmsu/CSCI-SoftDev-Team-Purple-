import java.util.Scanner;

public class Player {
    private String playerName;
    private Coordinate shot;
    private ShipFactory factory;
    private Grid oceanGrid = new OceanGrid();
    private Grid targetGrid = new TargetGrid();

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
        int playerString = ConsoleHelper.getInputWithInRange("Would you like to set your ships manually or randomly",1,2);
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

}
