import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyTrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Locomotive extends RailVehicle
{
    boolean isCrashed;
    Direction currentMovingDirection;
        
    public Locomotive(RailVehicle nextRailVehicle, Direction initialMovingDirection) {
        super(nextRailVehicle);
        
        isCrashed = false;
        currentMovingDirection = initialMovingDirection;
        // reverseDirection();
    }
    
    public void act()
    {
        if(!isCrashed()) {
            moveOnRail();
        }
    }    
    
    public void onCrash() {
        isCrashed = true;
    }
    
    public boolean isCrashed() {
        return isCrashed;
    }
    
    public boolean isOnTrack() {
        java.util.List<Track> tracks = getObjectsInRange(0, Track.class);
        return !tracks.isEmpty();
    }
    
    public Track getCurrentTrack() {
        java.util.List<Track> tracks = getObjectsInRange(0, Track.class);
        return tracks.get(0);
    }
    
    public void reverseDirection() {
        switch(currentMovingDirection) {
            case TOP: currentMovingDirection = Direction.BOTTOM; break;
            case RIGHT: currentMovingDirection = Direction.LEFT; break;
            case BOTTOM: currentMovingDirection = Direction.TOP; break;
            case LEFT: currentMovingDirection = Direction.RIGHT; break;
        }
    }
    
    public void moveOnRail() {
        // Determine the direction of movement depending on the underlying track, connected tracks and speed (i.e. forward/reverse)
        Track nextTrack = this.getCurrentTrack().determineNextTrack(currentMovingDirection);   
        
        if(nextTrack == null) {
            isCrashed = true;
        } else {
            // Update moving direction
            currentMovingDirection = this.getCurrentTrack().getDirectionOf(nextTrack);
            // Acutally move
            moveAsTrainTo(nextTrack.getX(), nextTrack.getY());
        }
    }
}
