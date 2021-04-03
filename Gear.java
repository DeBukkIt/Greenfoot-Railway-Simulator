public enum Gear  
{
    FORWARD(1), BACKWARD(-1);
    
    private int multiplier;
    
    Gear(int multiplier) {
        this.multiplier = multiplier;
    }    
}