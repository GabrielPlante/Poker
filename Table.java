import java.util.ArrayList;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {

        System.out.println("Les cartes sont comprises entre 1 et 13");//Informations donnees a l'utilisateur
        System.out.println("Les couleurs sont : Coeur, Carreau, Trefle, Pique");
        System.out.println("Entrez les 5 cartes pour le joueur 1 :");
        ArrayList<Carte> paquet = new ArrayList<Carte>();//on cree la liste de carte

        while (paquet.size() < 10)
        {
            if (paquet.size() == 5) System.out.println("Entrez les 5 cartes pour le joueur 2 :");
            System.out.println("Carte n° "+(paquet.size()+(paquet.size()<5?1:-4)));
            System.out.print("Nombre : ");
            Scanner sc_nombre = new Scanner(System.in);
            int nombre = sc_nombre.nextInt();
            System.out.print("Couleur : ");
            Scanner sc_couleur = new Scanner(System.in);
            String couleur = sc_couleur.nextLine();
            if ((couleur.equals("Coeur") || couleur.equals("Carreau") || couleur.equals("Trefle") || couleur.equals("Pique")) && nombre >= 1 && nombre <= 13)
                paquet.add(new Carte(nombre, couleur));
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
