import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackCurveLeftToDown.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackCurveTopRight extends Track
{
    public TrackCurveTopRight() {
        super(TrackType.CURVE_TOPRIGHT);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case BOTTOM:
                newDirection = Direction.RIGHT;
                break;
            case LEFT:
                newDirection = Direction.TOP;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case LEFT: return Direction.BOTTOM;
            case BOTTOM: return Direction.LEFT;
            default: return Direction.BOTTOM;
        }
    }
    
}
