import java.util.HashSet;
import java.util.Set;

public class TakeShot {
    private Set<Coordinate> shotsTaken;

    public TakeShot() {
        this.shotsTaken = new HashSet<>();
    }

    public ShotResult promptAndTakeShot(TargetGrid targetGrid, OceanGrid opponentOceanGrid) {
        Coordinate shot = null;
        while (true) {
            try {
                String input = ConsoleHelper.getShot();
                shot = new Coordinate(input);

                if (shotsTaken.contains(shot)) {
                    System.out.println("You've already taken this shot. Try a different coordinate.");
                    continue;
                }

                if (!targetGrid.isShotValid(shot)) {
                    System.out.println("Invalid shot, please try again.");
                    continue;
                }

                shotsTaken.add(shot);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Coordinates should be in format like 'A5'.");
            }
        }

        ShotResult result = opponentOceanGrid.receiveShot(shot);
        targetGrid.receiveShotResult(result, shot);
        displayShotResult(result, shot);
        return result;
    }

    private void displayShotResult(ShotResult result, Coordinate shot) {
        switch (result) {
            case HIT:
                System.out.println("Hit at " + shot + "!");
                break;
            case MISS:
                System.out.println("Miss at " + shot + "!");
                break;
            case SUNK:
                System.out.println("Hit and sunk at " + shot + "!");
                break;
        }
    }
}
