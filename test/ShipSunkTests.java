import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ShipSunkTests {
   

    @Test
    public void testShipIsSunk() throws Exception{
        Ship ship = new Ship("Destroyer", 3);
        ship.setCoordinates(Arrays.asList(new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(0, 2)));
        ship.registerHit();
        ship.registerHit();
        assertFalse(ship.isSunk());
        ship.registerHit();
        assertTrue(ship.isSunk());
    }

    @Test
    public void testShipIsNotSunk() throws Exception {
        Ship ship = new Ship("Submarine", 2);
        ship.setCoordinates(Arrays.asList(new Coordinate(1, 1), new Coordinate(1, 2)));
        ship.registerHit();
        assertFalse(ship.isSunk());
    }
}
