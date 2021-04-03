import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse RailVehicle.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class RailVehicle extends Actor
{
    private RailVehicle nextRailVehicle; // TODO Also add reference to other neighbour vehicle to be able to move the train in other direction
    
    public RailVehicle() {
        this(null);
    }
    
    public RailVehicle(RailVehicle nextRailVehicle) {
        this.nextRailVehicle = nextRailVehicle;
    }
    
    public boolean hasNextRailVehicle() {
        return nextRailVehicle != null;
    }
    
    public RailVehicle getNextRailVehicle() {
        return this.nextRailVehicle;
    }
    
    public void setNextRailVehicle(RailVehicle nextRailVehicle) {
        this.nextRailVehicle = nextRailVehicle;
    }
    
    public void moveAsTrainTo(int newX, int newY) {
        // Remember my old position
        int myOldX = getX();
        int myOldY = getY();
        
        // Move
        setLocation(newX, newY);
        
        // Let the next vehicle in train move, too (if there is one)
        if(nextRailVehicle != null) {
            nextRailVehicle.moveAsTrainTo(myOldX, myOldY);
        }
    }
}