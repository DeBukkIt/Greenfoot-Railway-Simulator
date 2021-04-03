import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackCurveLeftToDown.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackCurveRightBottom extends Track
{
    public TrackCurveRightBottom() {
        super(TrackType.CURVE_RIGHTBOTTOM);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case LEFT:
                newDirection = Direction.BOTTOM;
                break;
            case TOP:
                newDirection = Direction.RIGHT;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
}
