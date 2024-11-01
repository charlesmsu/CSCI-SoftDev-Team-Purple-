<<<<<<< HEAD

=======
>>>>>>> 0e688c1845abb40005700d6804634c7aa7041f63
import java.util.List;

public class Ship {
    private int hitCount = 0;
    private String shipName;
    private int shipLength;
    private List<Coordinate> coordinates;

    public Ship(String shipName, int shipLength) {
        this.shipName = shipName;
        this.shipLength = shipLength;
    }

    public int getLength() {
        return shipLength;
    }

    public String getShipName() {
        return shipName;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void registerHit(){
        ++hitCount;
    }

    public boolean isSunk(){
        if(shipLength == hitCount){
            return true;
        }
        return false;
    }    
}
