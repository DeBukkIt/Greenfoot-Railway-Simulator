import java.util.List;
import java.util.ArrayList;

public class Train  
{
    private Locomotive loc;
    private List<RailVehicle> vehicles;
    
    Gear gear;
        
    boolean isCrashed;
    
    public Train() {
        this.vehicles = new ArrayList<RailVehicle>();
        
        this.gear = Gear.BACKWARD;
    }
    
    public Train(Locomotive loc) {
        this();        
        this.loc = loc;
    }
    
    public Train(Locomotive loc, RailVehicle... vehicles) {
        this(loc);        
        for(RailVehicle rv : vehicles) {
            this.vehicles.add(rv);
        }
    }
    
    public void act() {
        if(!isCrashed()) {
            moveOnRail();
        }
    }
    
    public void removeLoc() {
        this.setLoc(null);
    }
    
    public void setLoc(Locomotive loc) {
        this.loc = loc;
    }
    
    public Locomotive getLoc() {
        return this.loc;
    }
    
    public boolean hasLoc() {
        return this.loc != null;
    }
    
    public void addVehicle(RailVehicle vehicle) {
        if(vehicle != null) {
            this.vehicles.add(vehicle);
        }
    }

    public void removeVehicle(int index){
        if(index >= 0) {
            this.vehicles.remove(index);
        }
    }
    
    public RailVehicle getVehicle(int index) {
        if(index >= 0) {
            return this.vehicles.get(index);
        }
        return null;
    }
    
    public boolean hasVehicles() {
        return this.getNumberOfVehicles() > 0;
    }
    
    public int getNumberOfVehicles() {
        return this.vehicles.size();
    }
    
    public RailVehicle getFirstVehicle() {
        return this.vehicles.get(0);
    }
    
    public RailVehicle getLastVehicle() {
        return this.vehicles.get(this.vehicles.size() - 1);
    }
    
    public RailVehicle getLeadingVehicle() {
        switch(gear) {
            case FORWARD: return loc;
            case BACKWARD: return getLastVehicle();
            default: return loc;
        }
    }
    
    public void onCrash() {
        this.isCrashed = true;
    }
    
    public void setCrashed(boolean isCrashed) {
        this.isCrashed = isCrashed;
    }
    
    public boolean isCrashed() {
        return this.isCrashed;
    }
    
    public void moveOnRail() {
        // Determine leading vehicle, current and next leading track and direction of next leading track
        RailVehicle leadingVehicle = this.getLeadingVehicle();
        Track currentLeadingTrack = leadingVehicle.getTrackBelow();
        Track nextLeadingTrack = currentLeadingTrack.determineNextTrack(leadingVehicle.getDirection());
        Direction nextLeadingDirection = currentLeadingTrack.getDirectionOf(nextLeadingTrack);
        
        // Crash if necessary
        if(nextLeadingTrack == null) {
            onCrash();
        } else {
        
            // Save old location of leading vehicle
            int oldX = leadingVehicle.getX();
            int oldY = leadingVehicle.getY();
            // Move leading vehicle, let all other vehicles follow
            leadingVehicle.setLocation(nextLeadingTrack.getX(), nextLeadingTrack.getY());
            // Depending on gear
            if(gear == Gear.FORWARD) {
                for(int i = this.vehicles.size() - 1; i > 0; i--) {
                    this.getVehicle(i).setLocation(this.getVehicle(i-1).getX(), this.getVehicle(i-1).getY());
                }
                this.getFirstVehicle().setLocation(oldX, oldY);
                // TODO CHANCE DIRECTION OF NON-LEADING, BUT TERMINATING VEHICLE, IN CASE TRAIN CHANGES DIRECTION!
            } else {
                this.getLoc().setLocation(this.getFirstVehicle().getX(), this.getFirstVehicle().getY());
                for(int i = 0; i < this.vehicles.size() - 2; i++) {
                    this.getVehicle(i).setLocation(this.getVehicle(i+1).getX(), this.getVehicle(i+1).getY());
                }
                // TODO MOVE PRE-LAST VEHICLE TO OLD!!! POSITION OF LEADING VEHICLE
            }
            
            // Update leading vehicle with new direction (the one of the next leading track)
            leadingVehicle.setDirection(nextLeadingDirection);
        }
    }
    
}