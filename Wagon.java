import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Repräsentation eines Waggons, d.h. einem RailVehicle, das als Teil eines Trains auf Tracks von einer Locomotive geschoben oder gezogen werden kann.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public class Wagon extends RailVehicle
{
    /**
     * Erzeugt einen Wagon. Die Bewegungsrichtung ist LEFT.
     */
    public Wagon() {
        this.setDirection(Direction.LEFT);
    }
    
    /**
     * Erzeugt einen Wagon mit gegebener initialer Bewegungsrichtung.
     * @param initialDirection Die gegebene initiale Bewegungsrichtung
     */
    public Wagon(Direction initialDirection) {
        super();
        this.setDirection(initialDirection);        
    }
    
    /**
     * Diese Methode wird vom Greenfoot-Framework aufgerufen, um Actors die Möglichkeit
     * zu geben, eine Aktion auszuführen. Bei jedem Aktionsschritt in der Umgebung wird die
     * act-Methode jedes Objekts aufgerufen, in nicht spezifizierter Reihenfolge. Die
     * Standardimplementierung tut nichts. Diese Methode kann in Unterklassen
     * überschrieben werden, um die Aktion eines Akteurs zu implementieren.<br><br>
     * Die Implementierung dieser Methode in Wagon tut ebenfalls nichts, denn dder Wagon
     * soll nicht durch ihre Act-Methode gesteuert werden.
     */
    public void act() 
    {
        // Wagons do not act on their own
    }
}