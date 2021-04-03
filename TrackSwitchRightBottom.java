import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackCurveLeftToDown.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackSwitchRightBottom extends Track
{
    boolean isSwitched; // i.e. switch leads the train to the side (acts like a curve)
    
    public TrackSwitchRightBottom() {
        super(TrackType.SWITCH_RIGHTBOTTOM);
        this.isSwitched = true;
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case RIGHT:
                newDirection = isSwitched ? Direction.BOTTOM : Direction.RIGHT;
                break;
            case TOP:
                newDirection = Direction.LEFT;
                break;
            case LEFT:
                newDirection = Direction.LEFT;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
    public void setSwitched(boolean switched) {
        this.isSwitched = switched;
    }
        
}
