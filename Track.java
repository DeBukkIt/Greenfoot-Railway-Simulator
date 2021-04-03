import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.Set;
import java.util.HashSet;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Track.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Track extends Actor
{   
    private TrackType trackType;
    // 0: top, 1: right, 2: bottom, 3: left
    private Track[] neighbouringTracks;
    
    public Track(TrackType trackType) {
        this.trackType = trackType;
    }
    
    public abstract Track determineNextTrack(Direction movingInDirection);
    
    public void findNeighbouringTracks() {
        neighbouringTracks = new Track[4];
        
        Object trackTop = getOneObjectAtOffset(0, -1, Track.class);
        Object trackRight = getOneObjectAtOffset(1, 0, Track.class);
        Object trackBottom = getOneObjectAtOffset(0, 1, Track.class);
        Object trackLeft = getOneObjectAtOffset(-1, 0, Track.class);
        
        if(trackTop != null) {
            neighbouringTracks[0] = (Track) trackTop;
        }
        if(trackRight != null) {
            neighbouringTracks[1] = (Track) trackRight;
        }
        if(trackBottom != null) {
            neighbouringTracks[2] = (Track) trackBottom;
        }
        if(trackLeft != null) {
            neighbouringTracks[3] = (Track) trackLeft;
        }
    }
    
    public boolean hasNeighbourAt(Direction dir) {
        return neighbouringTracks[dir.getId()] != null && isConnectedWith(neighbouringTracks[dir.getId()]);
    }

    public Track getNeighbourAt(Direction dir) {
        if(hasNeighbourAt(dir)) {
            return neighbouringTracks[dir.getId()];
        }
        return null;
    }
    
    public Direction getDirectionOf(Track other) {
        for(Direction dir : Direction.values()) {
            if(this.hasNeighbourAt(dir) && this.getNeighbourAt(dir).equals(other)) {
                return dir;
            }
        }
        return null;
    }
    
    public boolean isConnectedWith(Track other) {
        if(other == null) {
            return false;
        }
        
        if( (this.trackType.getConnectsLeft() && other.trackType.getConnectsRight() && this.getX() - 1 == other.getX() && this.getY() == other.getY())
        ||  (this.trackType.getConnectsRight() && other.trackType.getConnectsLeft() && this.getX() + 1 == other.getX() && this.getY() == other.getY())
        ||  (this.trackType.getConnectsTop() && other.trackType.getConnectsBottom() && this.getX() == other.getX() && this.getY() - 1 == other.getY())
        ||  (this.trackType.getConnectsBottom() && other.trackType.getConnectsTop() && this.getX() == other.getX() && this.getY() + 1 == other.getY())  ) {
            return true;
        }
        return false;
    }
    
    @Override
    public void act() 
    {
        // tracks do not act
    }  
    
    @Override
    public void move(int distance) {
        // tracks do not move
    }
}