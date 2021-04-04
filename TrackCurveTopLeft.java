import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackCurveLeftToDown.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackCurveTopLeft extends Track
{
    public TrackCurveTopLeft() {
        super(TrackType.CURVE_TOPLEFT);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case RIGHT:
                newDirection = Direction.TOP;
                break;
            case BOTTOM:
                newDirection = Direction.LEFT;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case RIGHT: return Direction.BOTTOM;
            case BOTTOM: return Direction.RIGHT;
            default: return Direction.BOTTOM;
        }
    }
    
}
