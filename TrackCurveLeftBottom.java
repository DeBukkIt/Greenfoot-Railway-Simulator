import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackCurveLeftToDown.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackCurveLeftBottom extends Track
{
    public TrackCurveLeftBottom() {
        super(TrackType.CURVE_LEFTBOTTOM);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case RIGHT:
                newDirection = Direction.BOTTOM;
                break;
            case TOP:
                newDirection = Direction.LEFT;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
}
