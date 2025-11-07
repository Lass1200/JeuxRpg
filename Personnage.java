package rpggamingg;

import java.util.ArrayList;
import java.util.List;


public class Personnage {

    private String nom;
    private int pv;
    private int mana;
    private int argent;
    private int xp;
    private String caste;
    private List<Armes> inventaire;

    public Personnage(String nom, String caste) {
        this.nom = nom;
        this.caste = caste;
        this.xp = 0;
        this.argent = 50;
        this.inventaire = new ArrayList<>(); 

        switch (caste.toLowerCase()) {
            case "sorcier":
                this.pv = 100;
                this.mana = 190;
                this.argent = 12;
                this.xp = 8;
                break;
            case "guerrier":
                this.pv = 100;
                this.mana = 190;
                this.argent = 90;
                this.xp = 8;
                break;
            case "elfe":
                this.pv = 100;
                this.mana = 170;
                this.argent = 150;
                this.xp = 8;
                break;
            default:
                System.out.println("Caste inconnue, vous devenez un Aventurier !");
                this.pv = 100;
                this.mana = 80;
                this.argent = 12;
                this.xp = 8;
                break;
        }
    }

  
    public void ajouterArme(Armes arme) {
        if (arme != null) {
            inventaire.add(arme);
            System.out.println(arme.getNom() + " ajouté à votre inventaire !");
        }
    }

   
    public List<Armes> getInventaire() {
        return inventaire;
    }

  
    public void afficherInventaire() {
        System.out.println("\n=== Inventaire de " + nom + " ===");
        if (inventaire.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            for (int i = 0; i < inventaire.size(); i++) {
                System.out.println((i + 1) + ". " + inventaire.get(i));
            }
        }
    }

   

    public String getNom() { return nom; }
    public int getPv() { return pv; }
    public int getMana() { return mana; }
    public int getArgent() { return argent; }
    public int getXp() { return xp; }
    public String getCaste() { return caste; }

    public void setPv(int pv) { this.pv = pv; }
    public void setMana(int mana) { this.mana = mana; }
    public void setArgent(int argent) { this.argent = argent; }
    public void setXp(int xp) { this.xp = xp; }

}
