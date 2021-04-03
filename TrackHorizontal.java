import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse TrackHorizontal.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TrackHorizontal extends Track
{
    public TrackHorizontal() {
        super(TrackType.HORIZONTAL);
    }
    
    public Track determineNextTrack(Direction movingDirection) {
        return this.getNeighbourAt(movingDirection);
    }
    
}