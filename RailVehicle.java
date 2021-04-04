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
    
    public void invertDirection() {
        // This is needed for gear changes (forward/backward)
        switch(direction) {
            case LEFT: direction = Direction.RIGHT; break;
            case RIGHT: direction = Direction.LEFT; break;
            case TOP: direction = Direction.BOTTOM; break;
            case BOTTOM: direction = Direction.TOP; break;
        }
    }
    
}