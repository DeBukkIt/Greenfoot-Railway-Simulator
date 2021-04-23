import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Repräsentiert eine RIGHT-BOTTOM-Switch, d.h. Weiche, die von rechts kommende
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
        super(TrackType.SWITCH_RIGHTBOTTOM, "switch_right_bottom_");
        super.setSwitched(false);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        Direction newDirection = null;
        switch(movingDirection) {
            case RIGHT:
                newDirection = this.isSwitched() ? Direction.BOTTOM : Direction.RIGHT;
                break;
            default:
                newDirection = Direction.LEFT;
                break;
        }
        return this.getNeighbourAt(newDirection);
    }
    
    public Direction getReversedDirection(Direction movingDirection) {
        switch(movingDirection) {
            case LEFT: return Direction.RIGHT;
            case TOP: return this.isSwitched() ? Direction.RIGHT : Direction.BOTTOM;
            case RIGHT: return this.isSwitched() ? Direction.TOP : Direction.LEFT;
            
            default: return Direction.RIGHT;
        }
    }
        
}
