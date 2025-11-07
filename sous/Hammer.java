package rpggamingg.sous;

import rpggamingg.Armes;
import rpggamingg.Monster;
import rpggamingg.Obstacle;

public class Hammer extends Armes{
    static final double ratiomonstre = 0.8;
    static final double ratioobstacle = 1.2;

    

    public Hammer() {
            super("marteau",34,20);
        }

    public void attaquer(Monster m){
        m.hit(this.degats* ratiomonstre);
       
    }
    public void attaquer(Obstacle o){
       o.hit(this.degats *ratioobstacle);
    }

}
