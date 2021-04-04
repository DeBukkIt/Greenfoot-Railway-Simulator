import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackVertical.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackVertical extends Track
{
    public TrackVertical() {
        super(TrackType.VERTICAL);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        return this.getNeighbourAt(movingDirection);
    }
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case TOP: return Direction.BOTTOM;
            case BOTTOM: return Direction.TOP;
            default: return Direction.BOTTOM;
        }
    }
    
}
