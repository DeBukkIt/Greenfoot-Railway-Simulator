import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Locomotive extends RailVehicle
{
    public Locomotive() {
        this.setDirection(Direction.RIGHT);
    }
    
    public Locomotive(Direction initialDirection) {
        super();
        this.setDirection(initialDirection);
    }
    
    public void act()
    {
        // LOCOMOTIVES NO LONGER ACT, IT'S THEIR TRAINS!
    }
    
}
