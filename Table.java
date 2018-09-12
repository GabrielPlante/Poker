import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {
        ArrayList<Carte> paquet = new ArrayList<Carte>();//On fait le paquet de carte
        for (int i = 1;i!=14;++i) {
            paquet.add(new Carte(i, "Coeur"));
            paquet.add(new Carte(i, "Carreau"));
            paquet.add(new Carte(i, "Pique"));
            paquet.add(new Carte(i, "Trefle"));
        }
        Main joueur1 = new Main(paquet);//Initialisation du joueur 1 et 2
        Main joueur2 = new Main(paquet);
        int j1 = joueur1.valeur_main(), j2 = joueur2.valeur_main();
        System.out.print("Valeur de la main du joueur 1 : "+j1+" ");
        System.out.println(Main.combinaisons(j1));
        System.out.print("Valeur de la main du joueur 2 : "+j2+" ");
        System.out.println(Main.combinaisons(j2));
        String gagnant = "Le joueur ";
        if (j1 > j2) gagnant += "1 gagne !";
        else if (j2 > j1) gagnant += "2 gagne !";
        else gagnant = "Egalite !";
        System.out.print(gagnant);
    }
}
