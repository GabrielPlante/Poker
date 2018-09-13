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
        System.out.println("");
        Main joueur2 = new Main(paquet);
        System.out.println("");
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

        /*for (int i = 0; i < 20; ++i) //Code de test
        {
           ArrayList<Carte> paquetTest = new ArrayList<Carte>();//On fait le paquet de carte
            for (int j = 1;j!=14;++j) {
                paquetTest.add(new Carte(j, "Coeur"));
                paquetTest.add(new Carte(j, "Carreau"));
                paquetTest.add(new Carte(j, "Pique"));
                paquetTest.add(new Carte(j, "Trefle"));
            }
            System.out.print("J1 : ");
            Main jou1 = new Main(paquetTest);
            System.out.print(" | ");
            System.out.print(jou1.valeur_main());
            System.out.print(" | ");
            System.out.println(Main.combinaisons(jou1.valeur_main()));

            System.out.print("J2 : ");
            Main jou2 = new Main(paquetTest);
            System.out.print(" | ");
            System.out.print(jou2.valeur_main());
            System.out.print(" | ");
            System.out.println(Main.combinaisons(jou2.valeur_main()));

            System.out.println("Joueur "+(jou1.valeur_main()>jou2.valeur_main()?"1":"2")+" gagne");
        }*/
    }
}
