import java.util.Scanner;

public class Player {
    private String playerName;

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

    // main testing method
    public static void main(String[] args) {
        Player player = new Player();
        player.promptForPlayerName();
        // player name is now set and can be used
    }
}
