import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Ein RailVehicle, das auf einem Track entweder selbst fahren oder aber gezogen oder geschoben werden kann.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public abstract class RailVehicle extends Actor
{
    /**
     * Gibt die Richtung an, in die sich das Schienenfahrzeug derzeit bewegt.
     */
    private Direction direction;
    
    /**
     * Gibt die Richtung zurück, in die sich das RailVehicle derzeit bewegt.
     * @return Die Richtung, in die sich das RailVehicle derzeit bewegt
     */
    public Direction getDirection() {
        return this.direction;
    }
    
    /**
     * Setzt die Richtung, in die sich das RailVehicle derzeit bewegt.
     * @param direction Die Richtung, in die sich das RailVehicle derzeit bewegt
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    /**
     * Gibt den Track unterhalb des RailVehicle zurück.
     * @return Der Track unterhalb des RailVehicle; oder null, falls das RailVehicle nicht auf einem Track steht.
     * Falls das RailVehicle auf mehr als einem Track steht, wird nur einer der Tracks zurückgegeben.
     */
    public Track getTrackBelow() {
        List<Track> results = this.getObjectsInRange(0, Track.class);
        if(results.size() >= 1) {
            return results.get(0);
        }
        return null;
    }
    
    /**
     * Gibt an, ob das RailVehicle im Moment der Abfrage auf einem Track steht.
     * @return true, falls das RailVehicle im Moment der Abfrage auf einem Track steht
     */
    public boolean isOnTrack() {
        return this.getTrackBelow() != null;
    }
        
    /**
     * Bewegt das Schienenfahrzeug zur angegebenen Position. Dabei wird das direction-Attribut
     * in Abhängigkeit von der Bewegungsrichtung aktualisiert. Die Korrektheit dieses Vorgangs
     * ist nur für nicht-diagonale Bewegungen gegeben.
     * @param newX  Die X-Koordinaten der neuen Position
     * @param newY  Die Y-Koordinate der neuen Position
     */
    public void moveTo(int newX, int newY) {
        // Remember old coordinates
        int oldX = getX();
        int oldY = getY();
        // Call super class function
        super.setLocation(newX, newY);
        // Update direction attribute depending on position change    
        if(newX > oldX) {
            direction = Direction.RIGHT;
        } else if(newX < oldX) {
            direction = Direction.LEFT;
        } else if(newY > oldY) {
            direction = Direction.BOTTOM;
        } else if(newY < oldY) {
            direction = Direction.TOP;
        }       
    }
    
    /**
     * Kehrt die Bewegungsrichtung in Abhängigkeit von dem aktuell unter dem RailVehicle befindlichen Track um.<br>
     * <b>Achtung:</b> Die Richtung wird nicht einfach zur entgegengesetzten Richtung geändert, sondern so, dass
     * der unter dem RailVehicle befindliche Track das RailVehicle rückwärts leitet. Beispiel: Die Richtung wird
     * auf einem Kurven-Track invertiert, der BOTTOM und RIGHT verbindet. In diesem Fall wird die Richtung LEFT
     * invertiert zu einer Bewegung TOP, sodass die Kurve statt einer Weiterleitung nach BOTTOM eine Weiterleitung
     * nach RIGHT gewährleistet.
     */
    public void invertDirection() {
        // This is needed for gear changes (forward/backward) and this IS NOT always
        // just the opposite direction, but depends on the track below:
        // e.g. a movement to the LEFT onto a bottom-right curve must be "inverted" to TOP
        direction = getTrackBelow().getReversedDirection(direction);
    }
    
    /**
     * Gibt eine Liste aller RailVehicle zurück, die sich über, unter oder neben (jedoch nicht diagonal) dem
     * RailVehicle befinden.
     * @return Eine Liste aller RailVehicle, die sich über, unter oder neben (jedoch nicht diagonal) dem
     * RailVehicle befinden
     */
    public List<RailVehicle> getNearbyRailVehicles() {
        List<RailVehicle> result = this.getObjectsAtOffset(0, 1, RailVehicle.class);
        result.addAll(this.getObjectsAtOffset(0, -1, RailVehicle.class));
        result.addAll(this.getObjectsAtOffset(1, 0, RailVehicle.class));
        result.addAll(this.getObjectsAtOffset(-1, 0, RailVehicle.class));
        return result;
    }
}
