public class DisplayPlayersTurn {

    public static void showPlayerTurn(Player player) {
        ConsoleHelper.clearScreen();
        String playerName = player.getPlayerName();
        ConsoleHelper.delayPrint(1);

        System.out.println("======================================");
        System.out.println("          " + playerName + "'s Turn");
        System.out.println("======================================");
        ConsoleHelper.delayPrint(1);
    }
}
