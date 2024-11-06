import java.util.HashSet;
import java.util.Set;

public class AIPlayer extends Player {
    private Set<Coordinate> attemptedShots;

    public AIPlayer() {
        super();
        this.attemptedShots = new HashSet<>();
        this.setPlayerName("Computer");
    }

    @Override
    public Coordinate getShotCoordinate() {
        Coordinate shot;
        do {
            shot = Coordinate.randomCoordinate(); // random coord
        } while (attemptedShots.contains(shot)); // no repeating shots

        attemptedShots.add(shot); // add shot to attempted set
        System.out.println(getPlayerName() + " shoots at " + shot); // show ai shot
        return shot;
    }
}
