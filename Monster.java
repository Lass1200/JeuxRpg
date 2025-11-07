package rpggamingg;

public class Monster extends Destructible {
    private String nom;


    public Monster(String nom, double vie, int xpRecompense, int argentRecompense) {
        this.nom = nom;
        this.life = vie;  
    }

  
    public String getNom() { return nom; }

    public boolean estMort() {
        return life <= 0;
    }
}
