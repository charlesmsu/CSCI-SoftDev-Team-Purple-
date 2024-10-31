import static org.junit.Assert.*;
import org.junit.Test;



public class ShotTests {
    private Coordinate newshot = null;
    private Grid grid = null;
    

    @Test

    public void testGetShotValues() throws Exception{
        Coordinate newshot = new Coordinate("A7");
        
        int expectedCol = 6;
        int expectedrow = 0;
        int actualrow = newshot.getRow();
        int actualCol = newshot.getCol();

        
        assertEquals(expectedCol, actualCol);
        assertEquals(expectedrow, actualrow);

    }
    @Test
    public void testGetlowercaseShotValues() throws Exception{
        Coordinate newshot = new Coordinate("a7");
        
        int expectedCol = 6;
        int expectedrow = 0;
        int actualrow = newshot.getRow();
        int actualCol = newshot.getCol();

        
        assertEquals(expectedCol, actualCol);
        assertEquals(expectedrow, actualrow);

    }

    @Test(expected = Exception.class)
    public void takeNewShotOutOfOrder() throws Exception{
        newshot = new Coordinate("7A");
    }
    
    @Test(expected = Exception.class)
    public void checkifstringistoolong() throws Exception{
        newshot = new Coordinate("A23");

    }
    @Test(expected = Exception.class)
    public void checkToSeeIfAllCharsAreAllowed() throws Exception{
        newshot = new Coordinate("AAA");
    }
    @Test(expected = Exception.class)
    public void checkToSeeIfAllNumbersIsAllowed() throws Exception{
        newshot = new Coordinate("111");
    }    
    @Test(expected = Exception.class)
    public void checkToSeeIfNoInputIsExcepted() throws Exception{
        newshot = new Coordinate("");
    } 
    @Test(expected = Exception.class)
    public void checkToSeeIfNumberOnAsciiBoardWorkInColumn() throws Exception{
        newshot = new Coordinate("90");
    }

}

