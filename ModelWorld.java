import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

/**
 * Repräsentiert eine beinahe leere World, in der Tracks so angeordnet werden können,
 * dass ein Train seine Waggons darauf mittels eines geeigneten Algorithmus sortieren kann.
 * 
 * @author Leonard Bienbeck
 * @version 1.0.0
 */
public class ModelWorld extends World
{    
    /**
     * Der Train, bestehend aus einer Locomotive und ein paar bunten Wagons
     */
    private Train train;
    
    /**
     * Konstruiert die ModelWorld. Als Orientierungshilfe wird das vorgegebene Raster
     * mit dünnen, grauen Linien in den Hintergrund gezeichnet.
     */
    public ModelWorld()
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
        wagon1 = new Wagon(3, WagonColor.RED, Direction.LEFT);
        wagon2 = new Wagon(1, WagonColor.GREEN, Direction.LEFT);
        wagon3 = new Wagon(2, WagonColor.BLUE, Direction.LEFT);
        wagon4 = new Wagon(4, WagonColor.YELLOW, Direction.LEFT);

        train = new Train(loc, wagon1, wagon2, wagon3, wagon4);

        // Place train
        addObject(wagon4, 1, 1);
        addObject(wagon3, 2, 1);
        addObject(wagon2, 3, 1);
        addObject(wagon1, 4, 1);
        addObject(loc, 5, 1);

        // Place track
        TrackHorizontal trackHorizontal6 = new TrackHorizontal();
        addObject(trackHorizontal6,0,1);
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
        TrackHorizontal trackHorizontal7 = new TrackHorizontal();
        addObject(trackHorizontal7,6,1);
        
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
