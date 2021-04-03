/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Direction.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public enum Direction  
{
    TOP(0), RIGHT(1), BOTTOM(2), LEFT(3);
    
    private int id;
    
    Direction(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
}