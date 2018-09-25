import java.util.ArrayList;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {

        System.out.println("Les cartes sont comprises entre 1 et 13");//Informations donnees a l'utilisateur
        System.out.println("Les couleurs sont : Co, Ca, Tr, Pi");
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
            if ((couleur.equals("Co") || couleur.equals("Ca") || couleur.equals("Tr") || couleur.equals("Pi")) && nombre >= 1 && nombre <= 13)
                paquet.add(new Carte(nombre, couleur));
        }

        System.out.println("Main 1: ");
        Main joueur1 = new Main(paquet);//Initialisation du joueur 1 et 2
        System.out.println("");
        System.out.println("Main 2: ");
        Main joueur2 = new Main(paquet);
        System.out.println("");
        int j1 = joueur1.valeur_main(), j2 = joueur2.valeur_main();
        String gagnant = "La main ";
        if (j1 > j2) gagnant += "1 gagne avec "+Main.combinaisons(j1);
        else if (j2 > j1) gagnant += "2 gagne avec "+Main.combinaisons(j2);
        else gagnant = "Egalite !";
        System.out.print(gagnant);
        //TODO : faire la presentation exacte demande dans le doc
    }
}
