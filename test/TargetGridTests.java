import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TargetGridTests {
    TargetGrid grid = new TargetGrid();
    OceanGrid Ogrid = new OceanGrid();

     @Before
    public void buildTest()throws Exception{
        Ship ship = new Ship("Cruiser", 3);
        ArrayList<Coordinate> coordinates= new ArrayList<>();
        coordinates.add(new Coordinate("C5"));
        coordinates.add(new Coordinate("C6"));
        coordinates.add(new Coordinate("C7"));
        // list of coordinate instances 
        ship.setCoordinates(coordinates);
        Ogrid.placeShip(ship);
    }

    @Test
    public void testPrintBoard(){
        grid.printGrid();
    }

    @Test
    public void testHitCell()throws Exception{
        ShotResult result = Ogrid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
        grid.receiveShotResult(result, new Coordinate("C5"));
    }

    /*@Test
    public void testValidHitCell()throws Exception{
        ShotResult result = Ogrid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
        Boolean valid = grid.isShotValid(new Coordinate("C5"));
        assertEquals(false, valid);
    }*/


}
