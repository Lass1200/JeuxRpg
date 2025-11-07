package rpggamingg;

import java.util.Random;
import java.util.Scanner;

public class Carte {
    private final int taille;
    private char[][] grille;
    private int joueurX, joueurY;

    public Carte(int taille) {
        this.taille = taille;
        this.grille = new char[taille][taille];
        initialiserCarte();
    }

    private void initialiserCarte() {

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = '.';
            }
        }


        joueurX = 0;
        joueurY = 0;
        grille[joueurX][joueurY] = 'J';


        grille[taille - 1][taille - 1] = 'S';


        Random rand = new Random();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if ((i != 0 || j != 0) && (i != taille - 1 || j != taille - 1)) {
                    int r = rand.nextInt(20);
                    if (r < 2) grille[i][j] = 'M'; // 10% monstres
                    else if (r < 4) grille[i][j] = 'O'; // 10% obstacles
                }
            }
        }
    }

    public void afficherCarte() {
        // Affiche la carte du jeu
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean deplacer(String direction, Personnage joueur) {
        int nx = joueurX;
        int ny = joueurY;

        switch (direction.toLowerCase()) {
            case "haut": nx--; break;
            case "bas": nx++; break;
            case "gauche": ny--; break;
            case "droite": ny++; break;
            default:
                System.out.println("Direction invalide !");
                return false;
        }

        if (nx < 0 || ny < 0 || nx >= taille || ny >= taille) {
            System.out.println("Impossible d'aller par là !");
            return false;
        }

        char caseSuivante = grille[nx][ny];
        if (caseSuivante == 'M') {
            System.out.println(" oh non y'a un monstre!");
            combat(joueur, "monstre");
        } else if (caseSuivante == 'O') {
            System.out.println(" y'a un cailloux la!");
            combat(joueur, "obstacle");
        } else if (caseSuivante == 'S') {
            System.out.println(" t'es sortie gg !");
            return true; 
        }


        grille[joueurX][joueurY] = '.';
        joueurX = nx;
        joueurY = ny;
        grille[joueurX][joueurY] = 'J';
        return false;
    }

    private void combat(Personnage joueur, String type) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Combattre / Détruire\n2. Fuir");
        String choix = sc.nextLine();

        if (choix.equals("1")) {
            System.out.println(" ca attaque !");
            joueur.setXp(joueur.getXp() + 100);
            System.out.println("tu gagne 100xp!");
        } else {
            System.out.println(" tu fuie ?!");
        }
    }
}
