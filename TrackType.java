/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse RailOrientation.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public enum TrackType  
{
    HORIZONTAL(false, true, false, true),
    VERTICAL(true, false, true, false),
    CURVE_LEFTBOTTOM(false, false, true, true),
    CURVE_TOPLEFT(true, false, false, true),
    CURVE_TOPRIGHT(true, true, false, false),
    CURVE_RIGHTBOTTOM(false, true, true, false),
    SWITCH_RIGHTBOTTOM(false, true, true, true);
    
    private boolean connectsTop;
    private boolean connectsRight;
    private boolean connectsBottom;
    private boolean connectsLeft;
    
    TrackType(boolean connectsTop, boolean connectsRight,
                boolean connectsBottom, boolean connectsLeft) {
      this.connectsTop = connectsTop;
      this.connectsRight = connectsRight;
      this.connectsBottom = connectsBottom;
      this.connectsLeft = connectsLeft;
    }
    
    public boolean getConnectsTop() {
        return connectsTop;
    }
    
    public boolean getConnectsRight() {
        return connectsRight;
    }
    
    public boolean getConnectsBottom() {
        return connectsBottom;
    }
    
    public boolean getConnectsLeft() {
        return connectsLeft;
    }
}