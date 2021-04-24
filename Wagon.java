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
     * Gibt die Farbe des Wagons als Zeichenkette an, so wie sie im Dateinamen
     * des zugehörigen Images anzutreffen ist.
     */
    private String colorName = "";
    /**
     * Gibt den Kupplungs-Zustand des Wagons als Zeichenkette an, so wie er im
     * Dateinamen des zugehörigen Images anzutreffen ist.
     */
    private String coupleState = "";
    
    /**
     * Erzeugt einen Wagon. Die Bewegungsrichtung ist RIGHT, die Farbe ist BLUE.
     */
    public Wagon() {
        this(WagonColor.BLUE, Direction.RIGHT);
    }
    
    /**
     * Erzeugt einen Wagon mit gegebener initialer Bewegungsrichtung.
     * @param initialDirection Die gegebene initiale Bewegungsrichtung
     */
    public Wagon(WagonColor color, Direction initialDirection) {
        super();
        this.setColor(color);
        this.setDirection(initialDirection);        
    }
    
    /**
     * Bestimmt die Farbe des Wagons
     * @param Die Farbe des Wagons als Element des Enums <code>WagonColor</code>
     */
    private void setColor(WagonColor color) {
        this.colorName = color.name().toLowerCase();
        updateImage();
    }
    
    /**
     * Aktualisiert das angezeigte Image des Wagons in Abhängigkeit von der gewählten
     * Farbe und dem Kupplungs-Zustand (angekuppelt, abgekuppelt).
     */
    private void updateImage() {
        this.setImage("wagon_" + colorName + coupleState + ".png");
    }
    
    @Override
    public void onCouple() {
        this.coupleState = "";
        updateImage();
    }
    
    @Override
    public void onDecouple() {
        this.coupleState = "_decoupled";
        updateImage();
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
    @Override
    public void act() 
    {
        // Wagons do not act on their own
    }
}