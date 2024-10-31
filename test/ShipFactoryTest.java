import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShipFactoryTest {
    private ShipFactory factory; // Make factory an instance variable
    private Ship ship1;
    private Ship ship2;
    private Ship ship3;
    private Ship ship4;
    private Ship ship5;

    @Before
    public void createFactory() throws Exception {
        factory = new ShipFactory(); // Assuming this is how you initialize the factory
        ship1 = new Ship("BATTLESHIP",4);
        ship2 = new Ship("CARRIER", 5);
        ship3 = new Ship("CRUISER",3);
        ship4 = new Ship("SUBMARINE",3);
        ship5 = new Ship("DESTROYER",2);

        ArrayList<Coordinate> location1 = new ArrayList<>();
        location1.add(new Coordinate("a1"));
        location1.add(new Coordinate("a2"));
        location1.add(new Coordinate("a3"));
    }

    @Test
    public void shipSizeCheck() {

        assertEquals(5, factory.getShipListLength());
    }

    @Test
    public void pickRandomStartPointOngridEast() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a1"),
                Direction.EAST);

    }

    @Test(expected = Exception.class)
    public void pickRandomStartPointoffgridEast() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a9"),
                Direction.EAST);

    }

    @Test
    public void pickRandomStartPointGridGoWest() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a5"),
                Direction.WEST);

    }

    @Test(expected = Exception.class)
    public void pickRandomStartPointoffgridWest() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a2"),
                Direction.WEST);

    }

    @Test(expected = Exception.class)
    public void pickRandomStartPointoffgridSouth() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("j9"),
                Direction.SOUTH);

    }

    @Test
    public void pickRandomStartPointGridSouth() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("d3"),
                Direction.SOUTH);

    }

    @Test(expected = Exception.class)
    public void pickRandomStartPointoffgridNorth() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a1"),
                Direction.NORTH);

    }

    @Test
    public void pickRandomStartPointGridNorth() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("j4"),
                Direction.NORTH);

    }

    @Test(expected = Exception.class)
    public void pickRandomStartPointoffgrid() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("10,19"),
                Direction.EAST);

    }

    @Test
    public void pickRandomStartPoint() throws Exception {
        ArrayList<Coordinate> location1 = new ArrayList<>();
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(ship3, new Coordinate("a1"),
                Direction.EAST);

    }

    @Test
    public void testShipOverLaping() throws Exception {
        // Create Coordinates for Ship 1
        ArrayList<Coordinate> location1 = new ArrayList<>();
        location1.add(new Coordinate("a1"));
        location1.add(new Coordinate("a2"));
        location1.add(new Coordinate("a3"));

        // Add Coordinates to Ship 1
        ship4.addCoordinates(location1);

  
        ArrayList<Coordinate> location2 = new ArrayList<>();
        location2.add(new Coordinate("a2")); 
        location2.add(new Coordinate("a3"));
        location2.add(new Coordinate("a4"));

        ship3.addCoordinates(location2);


        assertTrue(factory.shipOverlapsExistingShip(ship1, new ArrayList<>(List.of(ship1))));
    }

    @Test
    public void testShipNotOverLaping() throws Exception {
 
        ArrayList<Coordinate> location1 = new ArrayList<>();
        location1.add(new Coordinate("a1"));
        location1.add(new Coordinate("a2"));
        location1.add(new Coordinate("a3"));

        ship4.addCoordinates(location1);

        ArrayList<Coordinate> location2 = new ArrayList<>();
        location2.add(new Coordinate("b2")); // Overlaps with Ship 1
        location2.add(new Coordinate("b3"));
        location2.add(new Coordinate("b4"));

        ship3.addCoordinates(location2);


        // Assert that the ships are overlapping
        assertFalse(factory.shipOverlapsExistingShip(ship1, new ArrayList<>(List.of(ship1))));
    }

    @Test
    public void buildShipsThatDoNotOverLap() throws Exception {
        factory.buildShips();
        for (Ship ship : factory.getShipList()) {
            while (true) {
                try{
                ArrayList<Coordinate> locations = factory.coordsWithLengthPositionedAtInDirection(ship,
                        Coordinate.randomCoordinate(), factory.getStartDirection(ship));
                if (false == factory.shipOverlapsExistingShip(ship, factory.getShipList())) {
                    ship.addCoordinates(locations);
                    break;
                }
            }
            catch(Exception e){}
            
            }
        }

        assertEquals(5, factory.getShipListLength());
        // check if ships have proper coords length
        assertEquals(5, factory.getShipFromIndex(1).getCoordinates().size());
        assertEquals(4, factory.getShipFromIndex(0).getCoordinates().size());
        assertEquals(3, factory.getShipFromIndex(2).getCoordinates().size());
        assertEquals(3, factory.getShipFromIndex(3).getCoordinates().size());
        assertEquals(2, factory.getShipFromIndex(4).getCoordinates().size());
        // verify Ship names
        assertEquals("Battleship", factory.getShipFromIndex(0).getName());
        assertEquals("Carrier", factory.getShipFromIndex(1).getName());
        assertEquals("Submarine", factory.getShipFromIndex(2).getName());
        assertEquals("Cruiser", factory.getShipFromIndex(3).getName());
        assertEquals("Destroyer", factory.getShipFromIndex(4).getName());

    }
}
