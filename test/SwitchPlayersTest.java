public class SwitchPlayersTest {
    public static void main(String[] args) {
        // setup players
        Player player1 = new Player();
        player1.setPlayerName("Player 1");
        Player player2 = new Player();
        player2.setPlayerName("Player 2");

        // init mock grids
        TargetGrid player1TargetGrid = new TargetGrid();
        OceanGrid player1OceanGrid = new OceanGrid();
        TargetGrid player2TargetGrid = new TargetGrid();
        OceanGrid player2OceanGrid = new OceanGrid();

        // create switchplayers instance
        SwitchPlayers switchPlayers = new SwitchPlayers(player1, player2, player1TargetGrid, player1OceanGrid, player2TargetGrid, player2OceanGrid);

        // sim player returns
        System.out.println("Testing SwitchPlayers turn switching...");
        switchPlayers.displayCurrentPlayerTurn();
        switchPlayers.switchTurn();
        switchPlayers.displayCurrentPlayerTurn();
    }
}
