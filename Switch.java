import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Switch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Switch extends Track
{
    private boolean isSwitched; // i.e. switch leads the train to the side (acts like a curve)
    
    public Switch(TrackType trackType) {
        super(trackType);
        this.isSwitched = false;
    }
    
    public void setSwitched(boolean switched) {
        this.isSwitched = switched;
    }
    
    public boolean isSwitched() {
        return this.isSwitched;
    }
    
    public void toggleSwitched() {
        this.setSwitched(this.isSwitched() ? false : true);
    }
}
