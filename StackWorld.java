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
        wagon1 = new Wagon(WagonColor.RED, Direction.LEFT);
        wagon2 = new Wagon(WagonColor.GREEN, Direction.LEFT);
        wagon3 = new Wagon(WagonColor.BLUE, Direction.LEFT);
        wagon4 = new Wagon(WagonColor.YELLOW, Direction.LEFT);

        train = new Train(loc, wagon1, wagon2, wagon3, wagon4);

        // Place track

        TrackHorizontal trackHorizontal = new TrackHorizontal();
        addObject(trackHorizontal,7,1);
        TrackHorizontal trackHorizontal2 = new TrackHorizontal();
        addObject(trackHorizontal2,6,1);
        TrackHorizontal trackHorizontal3 = new TrackHorizontal();
        addObject(trackHorizontal3,5,1);
        TrackHorizontal trackHorizontal4 = new TrackHorizontal();
        addObject(trackHorizontal4,3,1);
        TrackHorizontal trackHorizontal5 = new TrackHorizontal();
        addObject(trackHorizontal5,4,1);
        TrackHorizontal trackHorizontal6 = new TrackHorizontal();
        addObject(trackHorizontal6,2,1);
        TrackHorizontal trackHorizontal7 = new TrackHorizontal();
        addObject(trackHorizontal7,1,1);
        TrackHorizontal trackHorizontal8 = new TrackHorizontal();
        addObject(trackHorizontal8,0,1);
        TrackSwitchRightBottom trackSwitchRightBottom = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom,8,1);
        TrackHorizontal trackHorizontal9 = new TrackHorizontal();
        addObject(trackHorizontal9,9,1);
        TrackSwitchRightBottom trackSwitchRightBottom2 = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom2,10,1);
        TrackHorizontal trackHorizontal10 = new TrackHorizontal();
        addObject(trackHorizontal10,11,1);
        TrackSwitchRightBottom trackSwitchRightBottom3 = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom3,12,1);
        TrackHorizontal trackHorizontal11 = new TrackHorizontal();
        addObject(trackHorizontal11,13,1);
        TrackCurveLeftBottom trackCurveLeftBottom = new TrackCurveLeftBottom();
        addObject(trackCurveLeftBottom,14,1);
        TrackVertical trackVertical = new TrackVertical();
        addObject(trackVertical,8,2);
        TrackVertical trackVertical2 = new TrackVertical();
        addObject(trackVertical2,8,3);
        TrackVertical trackVertical3 = new TrackVertical();
        addObject(trackVertical3,8,4);
        TrackVertical trackVertical4 = new TrackVertical();
        addObject(trackVertical4,8,5);
        TrackVertical trackVertical5 = new TrackVertical();
        addObject(trackVertical5,8,6);
        TrackVertical trackVertical6 = new TrackVertical();
        addObject(trackVertical6,8,7);
        TrackVertical trackVertical7 = new TrackVertical();
        addObject(trackVertical7,8,8);
        TrackVertical trackVertical8 = new TrackVertical();
        addObject(trackVertical8,8,9);
        TrackVertical trackVertical9 = new TrackVertical();
        addObject(trackVertical9,10,2);
        TrackVertical trackVertical10 = new TrackVertical();
        addObject(trackVertical10,10,3);
        TrackVertical trackVertical11 = new TrackVertical();
        addObject(trackVertical11,10,4);
        TrackVertical trackVertical12 = new TrackVertical();
        addObject(trackVertical12,10,5);
        TrackVertical trackVertical13 = new TrackVertical();
        addObject(trackVertical13,10,6);
        TrackVertical trackVertical14 = new TrackVertical();
        addObject(trackVertical14,10,7);
        TrackVertical trackVertical15 = new TrackVertical();
        addObject(trackVertical15,10,8);
        TrackVertical trackVertical16 = new TrackVertical();
        addObject(trackVertical16,10,9);
        TrackVertical trackVertical17 = new TrackVertical();
        addObject(trackVertical17,12,2);
        TrackVertical trackVertical18 = new TrackVertical();
        addObject(trackVertical18,12,3);
        TrackVertical trackVertical19 = new TrackVertical();
        addObject(trackVertical19,12,4);
        TrackVertical trackVertical20 = new TrackVertical();
        addObject(trackVertical20,12,5);
        TrackVertical trackVertical21 = new TrackVertical();
        addObject(trackVertical21,12,6);
        TrackVertical trackVertical22 = new TrackVertical();
        addObject(trackVertical22,12,7);
        TrackVertical trackVertical23 = new TrackVertical();
        addObject(trackVertical23,12,8);
        TrackVertical trackVertical24 = new TrackVertical();
        addObject(trackVertical24,12,9);
        TrackVertical trackVertical25 = new TrackVertical();
        addObject(trackVertical25,14,2);
        TrackVertical trackVertical26 = new TrackVertical();
        addObject(trackVertical26,14,3);
        TrackVertical trackVertical27 = new TrackVertical();
        addObject(trackVertical27,14,4);
        TrackVertical trackVertical28 = new TrackVertical();
        addObject(trackVertical28,14,5);
        TrackVertical trackVertical29 = new TrackVertical();
        addObject(trackVertical29,14,6);
        TrackVertical trackVertical30 = new TrackVertical();
        addObject(trackVertical30,14,7);
        TrackVertical trackVertical31 = new TrackVertical();
        addObject(trackVertical31,14,8);
        TrackVertical trackVertical32 = new TrackVertical();
        addObject(trackVertical32,14,9);
        
        // Place train
        addObject(wagon4, 2, 1);
        addObject(wagon3, 3, 1);
        addObject(wagon2, 4, 1);
        addObject(wagon1, 5, 1);
        addObject(loc, 6, 1);
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
