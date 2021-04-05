import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

/**
 * Write a description of class StackWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackWorld extends World
{    
    Train train;
    
    public StackWorld()
    {    
        // Create a new world with 32x22 cells with a cell size of 32x32 pixels.
        super(16, 12, 64);

        paintBackgroundGrid();
        prepare();
        initTrackEnvironments();
    }

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
                    System.out.println("Switch toggled");
                }
            }
        }
    }

    /**
     * Bereite die Welt für den Programmstart vor.
     * Das heißt: Erzeuge die Anfangs-Objekte und füge sie der Welt hinzu.
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
        wagon1 = new Wagon(Direction.LEFT);
        wagon2 = new Wagon(Direction.LEFT);
        wagon3 = new Wagon(Direction.LEFT);
        wagon4 = new Wagon(Direction.LEFT);

        train = new Train(loc, wagon1, wagon2, wagon3, wagon4);

        // Place objets
        TrackHorizontal trackHorizontal = new TrackHorizontal();
        addObject(trackHorizontal,0,1);
        TrackHorizontal trackHorizontal2 = new TrackHorizontal();
        addObject(trackHorizontal2,1,1);
        TrackHorizontal trackHorizontal3 = new TrackHorizontal();
        addObject(trackHorizontal3,2,1);
        TrackHorizontal trackHorizontal4 = new TrackHorizontal();
        addObject(trackHorizontal4,3,1);
        TrackHorizontal trackHorizontal5 = new TrackHorizontal();
        addObject(trackHorizontal5,4,1);
        TrackSwitchRightBottom trackSwitchRightBottom = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom,5,1);
        TrackHorizontal trackHorizontal6 = new TrackHorizontal();
        addObject(trackHorizontal6,6,1);
        TrackHorizontal trackHorizontal7 = new TrackHorizontal();
        addObject(trackHorizontal7,7,1);
        TrackHorizontal trackHorizontal8 = new TrackHorizontal();
        addObject(trackHorizontal8,8,1);
        TrackHorizontal trackHorizontal9 = new TrackHorizontal();
        addObject(trackHorizontal9,9,1);
        TrackHorizontal trackHorizontal10 = new TrackHorizontal();
        addObject(trackHorizontal10,10,1);
        TrackHorizontal trackHorizontal11 = new TrackHorizontal();
        addObject(trackHorizontal11,11,1);
        TrackSwitchRightBottom trackSwitchRightBottom2 = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom2,12,1);
        TrackHorizontal trackHorizontal12 = new TrackHorizontal();
        addObject(trackHorizontal12,13,1);
        TrackSwitchRightBottom trackSwitchRightBottom3 = new TrackSwitchRightBottom();
        addObject(trackSwitchRightBottom3,14,1);
        trackSwitchRightBottom.setLocation(5,1);
        trackSwitchRightBottom.setLocation(12,2);
        trackHorizontal11.setLocation(5,1);
        trackSwitchRightBottom.setLocation(9,2);
        trackHorizontal9.setLocation(11,1);
        trackHorizontal10.setLocation(9,1);
        trackSwitchRightBottom.setLocation(10,1);
        TrackHorizontal trackHorizontal13 = new TrackHorizontal();
        addObject(trackHorizontal13,15,1);
        TrackVertical trackVertical = new TrackVertical();
        addObject(trackVertical,10,2);
        TrackVertical trackVertical2 = new TrackVertical();
        addObject(trackVertical2,10,3);
        TrackVertical trackVertical3 = new TrackVertical();
        addObject(trackVertical3,12,2);
        TrackVertical trackVertical4 = new TrackVertical();
        addObject(trackVertical4,12,3);
        TrackVertical trackVertical5 = new TrackVertical();
        addObject(trackVertical5,14,2);
        TrackVertical trackVertical6 = new TrackVertical();
        addObject(trackVertical6,14,3);
        TrackVertical trackVertical7 = new TrackVertical();
        addObject(trackVertical7,10,4);
        TrackVertical trackVertical8 = new TrackVertical();
        addObject(trackVertical8,12,4);
        TrackVertical trackVertical9 = new TrackVertical();
        addObject(trackVertical9,14,4);
        TrackVertical trackVertical10 = new TrackVertical();
        addObject(trackVertical10,10,5);
        TrackVertical trackVertical11 = new TrackVertical();
        addObject(trackVertical11,12,5);
        TrackVertical trackVertical12 = new TrackVertical();
        addObject(trackVertical12,14,5);
        TrackVertical trackVertical13 = new TrackVertical();
        addObject(trackVertical13,10,6);
        TrackVertical trackVertical14 = new TrackVertical();
        addObject(trackVertical14,12,6);
        TrackVertical trackVertical15 = new TrackVertical();
        addObject(trackVertical15,14,6);
        TrackVertical trackVertical16 = new TrackVertical();
        addObject(trackVertical16,10,7);
        TrackVertical trackVertical17 = new TrackVertical();
        addObject(trackVertical17,12,7);
        TrackVertical trackVertical18 = new TrackVertical();
        addObject(trackVertical18,14,7);
        TrackVertical trackVertical19 = new TrackVertical();
        addObject(trackVertical19,10,8);
        TrackVertical trackVertical20 = new TrackVertical();
        addObject(trackVertical20,12,8);
        TrackVertical trackVertical21 = new TrackVertical();
        addObject(trackVertical21,14,8);

        addObject(wagon4, 2, 1);
        addObject(wagon3, 3, 1);
        addObject(wagon2, 4, 1);
        addObject(wagon1, 5, 1);
        addObject(loc, 6, 1);
        trackHorizontal7.setLocation(7,0);
        trackSwitchRightBottom.setLocation(7,1);
        trackVertical.setLocation(7,2);
        trackVertical2.setLocation(7,3);
        trackVertical7.setLocation(8,4);
        trackVertical10.setLocation(7,5);
        trackVertical13.setLocation(7,6);
        trackVertical16.setLocation(7,7);
        trackVertical19.setLocation(7,8);
        trackHorizontal10.setLocation(9,0);
        trackSwitchRightBottom2.setLocation(10,1);
        trackSwitchRightBottom2.setLocation(9,1);
        trackHorizontal9.setLocation(10,1);
        trackSwitchRightBottom3.setLocation(11,1);
        trackHorizontal12.setLocation(12,1);
        trackHorizontal12.setLocation(12,1);
        trackHorizontal12.setLocation(13,1);
        trackSwitchRightBottom3.setLocation(10,1);
        trackHorizontal12.setLocation(12,1);
        trackHorizontal10.setLocation(13,1);
        trackHorizontal7.setLocation(14,1);
        trackVertical3.setLocation(9,2);
        trackVertical4.setLocation(9,3);
        trackVertical8.setLocation(9,4);
        trackVertical11.setLocation(9,5);
        trackVertical11.setLocation(9,5);
        trackVertical14.setLocation(9,6);
        trackVertical17.setLocation(9,7);
        trackVertical20.setLocation(9,8);
        trackVertical21.setLocation(11,8);
        trackVertical18.setLocation(11,7);
        trackVertical15.setLocation(11,6);
        trackVertical12.setLocation(11,5);
        trackVertical9.setLocation(11,4);
        trackVertical6.setLocation(11,3);
        trackVertical5.setLocation(11,2);
        trackVertical7.setLocation(7,4);
        trackHorizontal9.setLocation(11,1);
        trackHorizontal9.setLocation(10,0);
        trackSwitchRightBottom3.setLocation(11,1);
        trackHorizontal9.setLocation(10,1);
    }
    
    private void initTrackEnvironments() {
        // Initialize tracks' environment
        List<Track> allTracks = getObjects(Track.class);
        for(Track currentTrack : allTracks) {
            currentTrack.findNeighbouringTracks();
        }
    }
}
