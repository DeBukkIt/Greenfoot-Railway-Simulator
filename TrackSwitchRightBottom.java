import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Repräsentiert eine RIGHT-BOTTOM-Switch, d.h. Weiche, die von links kommende
 * Züge im ungestellten Zustand horizontal leitet, im gestellten Zustand nach unten.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public class TrackSwitchRightBottom extends Switch
{    
    /**
     * Erzeugt eine RIGHT-BOTTOM-Switch
     */
    public TrackSwitchRightBottom() {
        super(TrackType.SWITCH_RIGHTBOTTOM);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case RIGHT:
                newDirection = this.isSwitched() ? Direction.BOTTOM : Direction.RIGHT;
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
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case RIGHT: return this.isSwitched() ? Direction.TOP : Direction.LEFT;
            case LEFT: return this.isSwitched() ? Direction.BOTTOM : Direction.RIGHT;
            case TOP: return Direction.RIGHT;
            default: return Direction.RIGHT;
        }
    }
        
}
