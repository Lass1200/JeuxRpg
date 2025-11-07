package rpggamingg;

public class Destructible {
    protected double life = 100;
    public void hit(double degats){
        this.life -= degats;
    }
}
