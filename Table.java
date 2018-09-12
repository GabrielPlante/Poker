import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {
        ArrayList<Carte> paquet = new ArrayList<Carte>();
        for (int i = 1;i!=14;++i) {
            paquet.add(new Carte(i, "Coeur"));
            paquet.add(new Carte(i, "Carreau"));
        }
        Main joueur1 = new Main(paquet);
        Main joueur2 = new Main(paquet);
        String gagnant = "Le joueur "+((joueur1.valeur_main()>joueur2.valeur_main()) ? "1" : "2") + " gagne !";
        System.out.print(gagnant);
    }
}
