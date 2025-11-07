package rpggamingg;

import java.util.ArrayList;
import java.util.List;

import rpggamingg.sous.Axe;
import rpggamingg.sous.Bow;
import rpggamingg.sous.Hammer;

public class Magasin {

    private List<Armes> stock;

    public Magasin() {
        stock = new ArrayList<>();
        stock.add(new Axe());
        stock.add(new Bow());
        stock.add(new Hammer());
    }

    public void afficherStock() {
        System.out.println("le stock");
        for (int i = 0; i < stock.size(); i++) {
            System.out.println((i + 1) + ". " + stock.get(i));
        }
    }

    public boolean AcheterArme(Personnage perso, int index) {
        if (index < 0 || index >= stock.size()) {
            return false;
        }
        Armes arme = stock.get(index);

        if (perso.getArgent() >= arme.getPrix()) {
            perso.setArgent(perso.getArgent() - arme.getPrix());
            perso.ajouterArme(arme);
            return true;
        } else {
            return false;
        }
    }
}
