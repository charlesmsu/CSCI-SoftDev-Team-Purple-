import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ShipFactoryTests {

    ShipFactory factory;

    @Before
    public void init(){
       factory = new AutomaticShipFactory();
    }

    @Test (expected = Exception.class)
    public void testOffTheTop() throws Exception {
        Coordinate start = new Coordinate("d2");
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.NORTH);
    }

    @Test (expected = Exception.class)
    public void testOffTheBottom() throws Exception {
       Coordinate start = new Coordinate(8, 8);
       List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.SOUTH);
    }

    @Test (expected = Exception.class)
    public void testOffOfTheBottom() throws Exception {
       Coordinate start = new Coordinate("G5");
       List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.SOUTH);
    }

    @Test (expected = Exception.class)
    public void testOffToRight() throws Exception {
       Coordinate start = new Coordinate(3, 8);
       List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.EAST);
    }

    @Test (expected = Exception.class)
    public void testOffToLeft() throws Exception {
       Coordinate start = new Coordinate("A2");
       List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.WEST);  
    }

    @Test
    public void testGenerateThreeCoordinatesToWest()throws Exception {
        Coordinate teststart = new Coordinate(2,2);
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(3, teststart, Direction.WEST);

        assertEquals(3, result.size());
        assertTrue(result.contains(new Coordinate(2,2)));
        assertTrue(result.contains(new Coordinate(2,1)));
        assertTrue(result.contains(new Coordinate(2,0)));
    }

    @Test
    public void testGenerateTwoCoordinatesToNorth()throws Exception {
        Coordinate teststart = new Coordinate(2,1);
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(2, teststart, Direction.NORTH);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Coordinate(2,1)));
        assertTrue(result.contains(new Coordinate(1,1)));
    }

    @Test
    public void testGenerateFiveCoordinatesToEast()throws Exception {
        Coordinate teststart = new Coordinate(2,1);
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, teststart, Direction.EAST);

        assertEquals(5, result.size());
        assertTrue(result.contains(new Coordinate(2,1)));
        assertTrue(result.contains(new Coordinate(2,2)));
        assertTrue(result.contains(new Coordinate(2,3)));
        assertTrue(result.contains(new Coordinate(2,4)));
        assertTrue(result.contains(new Coordinate(2,5)));
    }

    @Test
    public void testDetectOverlap()throws Exception {
        Ship one = new Ship("Submarine", 3);
        one.setCoordinates(List.of(
            new Coordinate("B3"),
            new Coordinate("B4"),
            new Coordinate("B5")
        ));
        Ship two = new Ship("Destroyer", 4);
        two.setCoordinates(List.of(
            new Coordinate("A3"),
            new Coordinate("B3"),
            new Coordinate("C3"),
            new Coordinate("D3")
        ));
        assertTrue(factory.shipOverLaps(one, List.of(two)));
    }

    @Test
    public void testNoOverlap()throws Exception {
        Ship one = new Ship("Submarine", 3);
        one.setCoordinates(List.of(
            new Coordinate("B3"),
            new Coordinate("B4"),
            new Coordinate("B5")
        ));
        Ship two = new Ship("Destroyer", 4);
        two.setCoordinates(List.of(
            new Coordinate("E3"),
            new Coordinate("E4"),
            new Coordinate("E5"),
            new Coordinate("E6")
        ));
        assertFalse(factory.shipOverLaps(one, List.of(two)));
    }

    @Test
    public void testGenerateFourCoordinatesToSouth()throws Exception {
        Coordinate teststart = new Coordinate(2,1);
        List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(4, teststart, Direction.SOUTH);
        assertEquals(4, result.size());
        assertTrue(result.contains(new Coordinate(2,1)));
        assertTrue(result.contains(new Coordinate(3,1)));
        assertTrue(result.contains(new Coordinate(4,1)));
        assertTrue(result.contains(new Coordinate(5,1)));
    }


    @Test
    public void testShipPlaceAtPositionAndDirectionContainsTheCoordinatesGivenAsString() throws Exception{
     Coordinate start = new Coordinate("C4");
     List<Coordinate> coords = factory.coordsWithLengthPositionedAtInDirection(4, start, Direction.EAST);      
     assertFalse(coords.contains(new Coordinate("c3")));
     assertTrue(coords.contains(new Coordinate("c4")));
     assertTrue(coords.contains(new Coordinate("c5")));
     assertTrue(coords.contains(new Coordinate("c6")));
     assertTrue(coords.contains(new Coordinate("c7")));
     assertFalse(coords.contains(new Coordinate("c8")));
     assertEquals(4, coords.size());
    }

    @Test
    public void testShipPlacedAtPositionAndDirectionContainsCoordinatesAtIndex() throws Exception {
     Coordinate start = new Coordinate("A1");   
     List<Coordinate> result = factory.coordsWithLengthPositionedAtInDirection(5, start, Direction.SOUTH);
     assertEquals(start, result.get(0));
     assertEquals(new Coordinate("A1"), result.get(0));
     assertEquals(new Coordinate("B1"), result.get(1));
     assertEquals(new Coordinate("C1"), result.get(2));
     assertEquals(new Coordinate("D1"), result.get(3));
     assertEquals(new Coordinate("E1"), result.get(4));
     assertEquals(5, result.size());
    }

    @Test
    public void testShipPlaceAtPositionAndDirectionDoesNotTheCoordinatesAtProperIndex() throws Exception{
     Coordinate start = new Coordinate("C4");
     List<Coordinate> coords = factory.coordsWithLengthPositionedAtInDirection(4, start, Direction.EAST);      
     assertFalse(coords.contains(new Coordinate("c3")));
     assertTrue(coords.contains(new Coordinate("c4")));
     assertTrue(coords.contains(new Coordinate("c5")));
     assertTrue(coords.contains(new Coordinate("c6")));
     assertTrue(coords.contains(new Coordinate("c7")));
     assertFalse(coords.contains(new Coordinate("c8")));
     assertEquals(4, coords.size());
    } 
}
