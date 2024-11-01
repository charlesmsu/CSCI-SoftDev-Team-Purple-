public class SwitchPlayers {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private TargetGrid player1TargetGrid;
    private OceanGrid player1OceanGrid;
    private TargetGrid player2TargetGrid;
    private OceanGrid player2OceanGrid;

    public SwitchPlayers(Player player1, Player player2, TargetGrid player1Target, OceanGrid player1Ocean, 
                         TargetGrid player2Target, OceanGrid player2Ocean) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1TargetGrid = player1Target;
        this.player1OceanGrid = player1Ocean;
        this.player2TargetGrid = player2Target;
        this.player2OceanGrid = player2Ocean;
        this.currentPlayer = player1;
    }

    public void displayCurrentPlayerTurn() {
        DisplayPlayersTurn.showPlayerTurn(currentPlayer);
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public TargetGrid getCurrentPlayerTargetGrid() {
        return currentPlayer == player1 ? player1TargetGrid : player2TargetGrid;
    }

    public OceanGrid getOpponentOceanGrid() {
        return currentPlayer == player1 ? player2OceanGrid : player1OceanGrid;
    }

    public ShotResult playTurn() {
        displayCurrentPlayerTurn();

        TargetGrid targetGrid = getCurrentPlayerTargetGrid();
        OceanGrid opponentOceanGrid = getOpponentOceanGrid();

        TakeShot takeShot = new TakeShot();
        ShotResult result = takeShot.promptAndTakeShot(targetGrid, opponentOceanGrid);
        
        switchTurn();
        return result;
    }
}
