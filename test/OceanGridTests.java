import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class OceanGridTests{
    OceanGrid grid = new OceanGrid();

    @Before
    public void buildTest()throws Exception{
        Ship ship = new Ship("Cruiser", 3);
        ArrayList<Coordinate> coordinates= new ArrayList<>();
        coordinates.add(new Coordinate("C5"));
        coordinates.add(new Coordinate("C6"));
        coordinates.add(new Coordinate("C7"));
        // list of coordinate instances 
        ship.setCoordinates(coordinates);
        grid.placeShip(ship);
    }
    

    @Test
    public void testOceanGridBoard(){
        grid.printGrid();
    }

    @Test
    public void testMissCell()throws Exception{
        ShotResult result = grid.receiveShot(new Coordinate("A5"));
        assertEquals(ShotResult.MISS, result);
    }

    @Test
    public void testHitCell()throws Exception{
        ShotResult result = grid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
    }


    @Test
    public void testSunkShip()throws Exception{
        ShotResult result = grid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
        result = grid.receiveShot(new Coordinate("C6"));
        assertEquals(ShotResult.HIT, result);
        result = grid.receiveShot(new Coordinate("C7"));
        assertEquals(ShotResult.SUNK, result);
    }

    /*@Test(expected = Exception.class)
    public void testHitSameCellTwice()throws Exception{
        ShotResult result = grid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
        result = grid.receiveShot(new Coordinate("C5"));
        assertEquals(ShotResult.HIT, result);
    }*/

    @Test(expected = Exception.class)
    public void testBadCoordinate()throws Exception{
        OceanGrid grid = new OceanGrid();
        Ship ship = new Ship("Destroyer", 2);
        ArrayList<Coordinate> coordinates= new ArrayList<>();
        coordinates.add(new Coordinate("L3"));
        coordinates.add(new Coordinate("M3"));
        // list of coordinate instances 
        ship.setCoordinates(coordinates);
        grid.placeShip(ship);
    }

    @Test(expected = Exception.class)
    public void testBadCoordinateAndShot()throws Exception{
        OceanGrid grid = new OceanGrid();
        Ship ship = new Ship("Destroyer", 2);
        ArrayList<Coordinate> coordinates= new ArrayList<>();
        coordinates.add(new Coordinate("L3"));
        coordinates.add(new Coordinate("M3"));
        // list of coordinate instances 
        ship.setCoordinates(coordinates);
        grid.placeShip(ship);
        ShotResult result = grid.receiveShot(new Coordinate("M3"));
        assertEquals(ShotResult.HIT, result);
    }

}
