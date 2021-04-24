import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Repräsentation einer Lokomotive, d.h. einem RailVehicle, das als Teil eines Trains auf Tracks bewegt werden kann.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public class Locomotive extends RailVehicle
{
    /**
     * Anzahl der Inversionsvorgänge der Direction. Mit Hilfe dieser Angabe kann die Methode <code>invertDirection</code> bestimmen,
     * welches Image die Locomotive haben muss, um mit der aktuellen Richtung übereinzustimmen.
     */
    private int directionIversionCounter = 0;
    
    /**
     * Erzeugt eine Locomotive. Ihre Bewegungsrichtung ist RIGHT.
     */
    public Locomotive() {
        this.setDirection(Direction.RIGHT);
    }
    
    /**
     * Erzeugt eine Locomotive mit gegebener initialer Bewegungsrichtung.
     * @param initialDirection  Die gegebene initiale Bewegungsrichtung
     */
    public Locomotive(Direction initialDirection) {
        super();
        this.setDirection(initialDirection);
    }
    
    @Override
    public void invertDirection() {
        super.invertDirection();
        
        // Set image of locomotive according to current gear (forward / reverse)
        if(directionIversionCounter % 2 == 0) {
            setImage("loc_reverse.png");
        } else {
            setImage("loc.png");
        }
        directionIversionCounter++;
    }
    
    /**
     * Diese Methode wird vom Greenfoot-Framework aufgerufen, um Actors die Möglichkeit
     * zu geben, eine Aktion auszuführen. Bei jedem Aktionsschritt in der Umgebung wird die
     * act-Methode jedes Objekts aufgerufen, in nicht spezifizierter Reihenfolge. Die
     * Standardimplementierung tut nichts. Diese Methode kann in Unterklassen
     * überschrieben werden, um die Aktion eines Akteurs zu implementieren.<br><br>
     * Die Implementierung dieser Methode in Locomotive tut ebenfalls nichts, denn die
     * Locomotive soll nicht durch ihre Act-Methode gesteuert werden.
     */
    @Override
    public void act()
    {
        // LOCOMOTIVES NO LONGER ACT, IT'S THEIR TRAINS!
    }
    
}
