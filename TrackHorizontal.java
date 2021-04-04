import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackHorizontal.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackHorizontal extends Track
{
    public TrackHorizontal() {
        super(TrackType.HORIZONTAL);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        return this.getNeighbourAt(movingDirection);
    }
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case LEFT: return Direction.RIGHT;
            case RIGHT: return Direction.LEFT;
            default: return Direction.RIGHT;
        }
    }
    
}