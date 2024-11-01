public class DisplayPlayersTurnTest {
    public static void main(String[] args) {
        // setup a player for testing
        Player player = new Player();
        player.setPlayerName("Test Player");

        // test DisplayPlayersTurn with the player
        System.out.println("Testing DisplayPlayersTurn.showPlayerTurn...");
        DisplayPlayersTurn.showPlayerTurn(player);
    }
}
