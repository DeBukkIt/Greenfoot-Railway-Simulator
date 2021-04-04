import java.util.List;
import java.util.ArrayList;

public class Train  
{
    private Locomotive loc;
    private List<RailVehicle> vehicles;
    
    private Gear gear;
        
    private boolean isCrashed;
    
    public Train() {
        this.vehicles = new ArrayList<RailVehicle>();
        
        this.gear = Gear.FORWARD;
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
        move();
    }
    
    public void reverseGear() {
        switch(gear) {
            case FORWARD: this.setGear(Gear.BACKWARD); break;
            case BACKWARD: this.setGear(Gear.FORWARD); break;
        }
    }
    
    public void setGear(Gear newGear) {
        if(this.gear != newGear) {
            this.gear = newGear;
            // Invert direction of all train members
            loc.invertDirection();
            for(RailVehicle wagon : this.vehicles) {
                wagon.invertDirection();
            }
        }
    }
    
    public Gear getGear() {
        return this.gear;
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
            case BACKWARD: return hasVehicles() ? getLastVehicle() : loc;
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
    
    public void couple() {
        // Couples a new wagon next to the last wagon of the train (or the loc, if there is no wagon already)
        // Conditions:
        // - new wagon is next to the last wagon
        // - new wagon is on a side of the last wagon, where not other wagon or loc is already, i.e. it's not already part of the train
        // - track below new wagon is connected to the track of the last wagon
        // Be aware of:
        // - on switches there might be multiple wagons fulfilling these conditions
        // - if something like orientation is implemented, couple the wagon on the available side of the wagon (also solves switch problem)
        
        
        RailVehicle couplingVehicle = this.hasVehicles() ? getLastVehicle() : getLoc();
        
        List<RailVehicle> nearbyVehicles = couplingVehicle.getNearbyRailVehicles();
        for(RailVehicle candidate : nearbyVehicles) {
            if(!this.vehicles.contains(candidate)) {
                if(candidate.getTrackBelow() != null) {
                    if(couplingVehicle.getTrackBelow().isConnectedWith(candidate.getTrackBelow())) {
                        this.addVehicle(candidate);
                        break;
                    }
                }
            }
        }
    }
    
    public void decouple() {
        if(this.hasVehicles()) {
            this.removeVehicle(this.getNumberOfVehicles() - 1);
        }
    }
    
    public void move() {
        if(isCrashed()) {
            System.err.println("Train can't move, it's crashed");
            return;
        }
        
        // Determine leading vehicle, current and next leading track and direction of next leading track
        RailVehicle leadingVehicle = this.getLeadingVehicle();
        Track currentLeadingTrack = leadingVehicle.getTrackBelow();
        Track nextLeadingTrack = currentLeadingTrack.determineNextTrack(leadingVehicle.getDirection());
        Direction nextLeadingDirection = currentLeadingTrack.getDirectionOf(nextLeadingTrack);
        
        // Crash if necessary
        if(nextLeadingTrack == null) {
            System.err.println("The train has left the track");
            onCrash();
        } else if(nextLeadingTrack.isOccupied()) {
            System.err.println("The train hit a rail vehicle");
            onCrash();
        } else {
            // Depending on gear
            if(gear == Gear.FORWARD) {
                // Only move vehicles if there are any at all
                if(this.hasVehicles()) {
                    for(int i = this.vehicles.size() - 1; i > 0; i--) {
                        this.getVehicle(i).moveTo(this.getVehicle(i-1).getX(), this.getVehicle(i-1).getY());
                    }
                    this.getFirstVehicle().moveTo(leadingVehicle.getX(), leadingVehicle.getY());
                }
            } else /* gear = Gear.BACKWARD */ {
                // If there is at least one more vehicle in the train than just the loc, move that vehicle)
                if(this.getNumberOfVehicles() > 0) {
                    this.getLoc().moveTo(this.getFirstVehicle().getX(), this.getFirstVehicle().getY());
                }
                // If there are more vehicles (except leading wagon and the loc), move them, too
                if(this.getNumberOfVehicles() > 1) {                    
                    for(int i = 0; i < this.vehicles.size() - 1; i++) {
                        this.getVehicle(i).moveTo(this.getVehicle(i+1).getX(), this.getVehicle(i+1).getY());
                    }
                }
            }
            // Move leading vehicle, let all other vehicles already followed ;-)
            leadingVehicle.moveTo(nextLeadingTrack.getX(), nextLeadingTrack.getY());
            
            // Update leading vehicle with new direction (the one of the next leading track)
            leadingVehicle.setDirection(nextLeadingDirection);
        }
    }
    
}