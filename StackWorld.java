import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

/**
 * Repräsentiert eine World, in der Tracks so angeordnet sind, dass ein Train seine Waggons
 * darauf mittels des StackSort-Algorithmus sortieren kann.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public class StackWorld extends World
{    
    /**
     * Der Train, bestehend aus einer Locomotive und ein paar bunten Wagons
     */
    private Train train;
    
    // The switches to be controlled by program code (act method)
    private TrackSwitchRightBottom trackSwitchRightBottom = new TrackSwitchRightBottom();
    private TrackSwitchRightBottom trackSwitchRightBottom2 = new TrackSwitchRightBottom();
    private TrackSwitchRightBottom trackSwitchRightBottom3 = new TrackSwitchRightBottom();
    
    /**
     * Konstruiert die StackWorld. Als Orientierungshilfe wird das vorgegebene Raster
     * mit dünnen, grauen Linien in den Hintergrund gezeichnet.
     */
    public StackWorld()
    {    
        // Create a new world with 16x12 cells with a cell size of 64x64 pixels.
        super(16, 12, 64);

        // Paint the background grid
        paintBackgroundGrid();
        
        // Initialize Actors
        prepare();
        setPaintOrder(RailVehicle.class, Track.class, World.class);
    }

    /**
     * Zeichnet ein graues Raster in den Hintergrund, sodass die per Super-Konstruktor festgelegten
     * Zellen sichtbar werden.
     */
    private void paintBackgroundGrid() {
        GreenfootImage bg = getBackground();

        bg.setColor(Color.GRAY);
        for(int x = 1; x < getWidth(); x++) {
            bg.drawLine(x * getCellSize(), 0, x * getCellSize(), getHeight() * getCellSize());
        }
        for(int y = 1; y < getWidth(); y++) {
            bg.drawLine(0, y * getCellSize(), getWidth() * getCellSize(), y * getCellSize());
        }
    }
    
    /**
     * Verarbeitet Tastatur- und Mauseingaben, steuert den Train in Abhängigkeit von der Eingabe und
     * Switches in Abhängigkeit von der angeklickten Stelle.
     */
    public void act() {
        // Train controls
        boolean keyDownM = Greenfoot.isKeyDown("m");
        boolean keyDownR = Greenfoot.isKeyDown("r");
        boolean keyDownC = Greenfoot.isKeyDown("c");
        boolean keyDownD = Greenfoot.isKeyDown("d");
        
        if(keyDownM) {
            train.move();
        } else if(keyDownR) {
            train.reverseGear();
        } else if(keyDownC) {
            train.couple();
        } else if(keyDownD) {
            train.decouple();
        }
        
        // Switch clicks
        if(Greenfoot.getMouseInfo() != null) {
            Actor focusedActor = Greenfoot.getMouseInfo().getActor();
            if(Greenfoot.mousePressed(focusedActor)) {
                if(focusedActor != null && focusedActor instanceof Switch) {
                    Switch clickedSwitch = (Switch) focusedActor;
                    clickedSwitch.toggleSwitched();
                }
            }
        }
    }
    
    /**
     * Beispiel-Implementierung einer programmgesteuerten Kontrolle des Trains,
     * um Wagons in Abhängigkeit von ihrem Inhalt auf verschiedene Gleise zu schieben und
     * von dort wieder abzuholen.<br>
     * <br>
     * Alternativ zu dieser programmgesteuerten Kontrolle ist die Kontrolle der Bewegungen
     * per Tastatur und Mausklick.
     */
    /*
    public void act() {
        this.started();        
        
        int smallestContent = Integer.MAX_VALUE;
        
        // Put all wagons onto one stack
        moveTillEnd();
        trackSwitchRightBottom.setSwitched(true);
        train.reverseGear();
        moveTillEnd();
        while(train.hasVehicles()) {
            train.decouple();
        }
        
        // Find smallest
        while(train.isWagonAvailbleForCoupling()) {
            // Take one wagon
            train.couple();
            train.reverseGear();
            moveTillEnd();
            
            // Bring it to another stack
            trackSwitchRightBottom2.setSwitched(true);
            train.reverseGear();
            moveTillEnd();
            // Check if it's the smallest value yet
            if(((Wagon) train.getFirstVehicle()).getContent() < smallestContent) {
                smallestContent = ((Wagon) train.getFirstVehicle()).getContent();
            }
            train.decouple();
            
            // Move into first stack again
            train.reverseGear();
            moveTillEnd();
            trackSwitchRightBottom2.setSwitched(false);
            train.reverseGear();
            moveTillEnd();
        }

        // Do other fun stuff with the train...
    }
    */
    
    private void moveTillEnd() {
        while(!train.isObstacleAhead()) {
            train.move();
            Greenfoot.delay(3);
        }
    }
    

    /**
     * Bereite die Welt für den Programmstart vor, indem RailVehicles und Tracks
     * initialisiert und platziert werden.
     */
    private void prepare()
    {
        // Init train
        Locomotive loc;
        Wagon wagon1 = null;
        Wagon wagon2 = null;
        Wagon wagon3 = null;
        Wagon wagon4 = null;

        loc = new Locomotive(Direction.RIGHT);
        wagon1 = new Wagon(17, WagonColor.RED, Direction.LEFT);
        wagon2 = new Wagon(5, WagonColor.GREEN, Direction.LEFT);
        wagon3 = new Wagon(12, WagonColor.BLUE, Direction.LEFT);
        wagon4 = new Wagon(36, WagonColor.YELLOW, Direction.LEFT);
        
        train = new Train(loc, wagon1, wagon2, wagon3, wagon4);

        // Place train
        addObject(wagon4, 1, 1);
        addObject(wagon3, 2, 1);
        addObject(wagon2, 3, 1);
        addObject(wagon1, 4, 1);
        addObject(loc, 5, 1);

        // Place track  
        TrackHorizontal trackHorizontal = new TrackHorizontal();
        addObject(trackHorizontal,1,1);
        TrackHorizontal trackHorizontal2 = new TrackHorizontal();
        addObject(trackHorizontal2,2,1);
        TrackHorizontal trackHorizontal3 = new TrackHorizontal();
        addObject(trackHorizontal3,3,1);
        TrackHorizontal trackHorizontal4 = new TrackHorizontal();
        addObject(trackHorizontal4,4,1);
        TrackHorizontal trackHorizontal5 = new TrackHorizontal();
        addObject(trackHorizontal5,5,1);
        TrackHorizontal trackHorizontal6 = new TrackHorizontal();
        addObject(trackHorizontal6,6,1);
        TrackHorizontal trackHorizontal7 = new TrackHorizontal();
        addObject(trackHorizontal7,8,1);
        TrackHorizontal trackHorizontal8 = new TrackHorizontal();
        addObject(trackHorizontal8,10,1);
        TrackHorizontal trackHorizontal9 = new TrackHorizontal();
        addObject(trackHorizontal9,12,1);
        TrackHorizontal trackHorizontal10 = new TrackHorizontal();
        addObject(trackHorizontal10,13,1);
        TrackHorizontal trackHorizontal11 = new TrackHorizontal();
        addObject(trackHorizontal11,14,1);
        TrackCurveLeftBottom trackCurveLeftBottom = new TrackCurveLeftBottom();
        addObject(trackCurveLeftBottom,15,1);
        TrackVertical trackVertical = new TrackVertical();
        addObject(trackVertical,15,2);
        TrackVertical trackVertical2 = new TrackVertical();
        addObject(trackVertical2,15,3);
        TrackVertical trackVertical3 = new TrackVertical();
        addObject(trackVertical3,15,4);
        TrackVertical trackVertical4 = new TrackVertical();
        addObject(trackVertical4,15,5);
        TrackVertical trackVertical5 = new TrackVertical();
        addObject(trackVertical5,15,6);
        TrackVertical trackVertical6 = new TrackVertical();
        addObject(trackVertical6,15,7);
        TrackVertical trackVertical7 = new TrackVertical();
        addObject(trackVertical7,15,8);
        TrackHorizontal trackHorizontal12 = new TrackHorizontal();
        addObject(trackHorizontal12,0,1);
        TrackVertical trackVertical8 = new TrackVertical();
        addObject(trackVertical8,7,2);
        TrackVertical trackVertical9 = new TrackVertical();
        addObject(trackVertical9,9,2);
        TrackVertical trackVertical10 = new TrackVertical();
        addObject(trackVertical10,11,2);
        TrackVertical trackVertical11 = new TrackVertical();
        addObject(trackVertical11,7,3);
        TrackVertical trackVertical12 = new TrackVertical();
        addObject(trackVertical12,7,4);
        TrackVertical trackVertical13 = new TrackVertical();
        addObject(trackVertical13,7,5);
        TrackVertical trackVertical14 = new TrackVertical();
        addObject(trackVertical14,7,6);
        TrackVertical trackVertical15 = new TrackVertical();
        addObject(trackVertical15,7,7);
        TrackVertical trackVertical16 = new TrackVertical();
        addObject(trackVertical16,7,8);
        TrackVertical trackVertical17 = new TrackVertical();
        addObject(trackVertical17,7,9);
        TrackVertical trackVertical18 = new TrackVertical();
        addObject(trackVertical18,7,10);
        TrackVertical trackVertical19 = new TrackVertical();
        addObject(trackVertical19,9,3);
        TrackVertical trackVertical20 = new TrackVertical();
        addObject(trackVertical20,9,4);
        TrackVertical trackVertical21 = new TrackVertical();
        addObject(trackVertical21,9,5);
        TrackVertical trackVertical22 = new TrackVertical();
        addObject(trackVertical22,9,6);
        TrackVertical trackVertical23 = new TrackVertical();
        addObject(trackVertical23,9,7);
        TrackVertical trackVertical24 = new TrackVertical();
        addObject(trackVertical24,9,8);
        TrackVertical trackVertical25 = new TrackVertical();
        addObject(trackVertical25,9,9);
        TrackVertical trackVertical26 = new TrackVertical();
        addObject(trackVertical26,9,10);
        TrackVertical trackVertical27 = new TrackVertical();
        addObject(trackVertical27,11,3);
        TrackVertical trackVertical28 = new TrackVertical();
        addObject(trackVertical28,11,4);
        TrackVertical trackVertical29 = new TrackVertical();
        addObject(trackVertical29,11,5);
        TrackVertical trackVertical30 = new TrackVertical();
        addObject(trackVertical30,11,6);
        TrackVertical trackVertical31 = new TrackVertical();
        addObject(trackVertical31,11,7);
        TrackVertical trackVertical32 = new TrackVertical();
        addObject(trackVertical32,11,8);
        TrackVertical trackVertical33 = new TrackVertical();
        addObject(trackVertical33,11,9);
        TrackVertical trackVertical34 = new TrackVertical();
        addObject(trackVertical34,11,10);
        
        addObject(trackSwitchRightBottom,7,1);
        addObject(trackSwitchRightBottom2,9,1);
        addObject(trackSwitchRightBottom3,11,1);
    }
    
    /**
     * Macht die Tracks beim Programmstart mit den umgebenden Tracks vertraut, sodass der Train später
     * zuverlässug an benachbarte Tracks weitergeleitet werden kann.
     */
    @Override
    public void started() {
        super.started();
        initTrackEnvironments();
    }
    
    /**
     * Macht die Tracks mit den umgebenden Tracks vertraut, sodass der Train später
     * zuverlässug an benachbarte Tracks weitergeleitet werden kann. Hierzu wird die entsprechende
     * Methode {@link Track#findNeighbouringTracks findNeighbouringTracks()} aller platzierten
     * Tracks aufgerufen.
     */
    private void initTrackEnvironments() {
        // Initialize tracks' environment
        List<Track> allTracks = getObjects(Track.class);
        for(Track currentTrack : allTracks) {
            currentTrack.findNeighbouringTracks();
        }
    }
}
