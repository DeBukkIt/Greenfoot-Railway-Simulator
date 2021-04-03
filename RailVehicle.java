import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse RailVehicle.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class RailVehicle extends Actor
{
    Direction direction;
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public Track getTrackBelow() {
        return this.getObjectsInRange(0, Track.class).get(0);
    }
        
    public boolean isOnTrack() {
        return this.getTrackBelow() != null;
    }
}