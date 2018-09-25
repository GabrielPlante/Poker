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
            if (paquet.size() == 5) System.out.println("Entrez les 5 cartes pour le joueur 2 :");//Si on a finis d'entrer les cartes du premier joueur,
            System.out.println("Carte n° "+(paquet.size()+(paquet.size()<5?1:-4)));//On passe au carte du deuxieme
            System.out.print("Nombre : ");//On affiche à quelle carte on se trouve
            Scanner sc_nombre = new Scanner(System.in);//Permet de recuperer la valeur donnee par l'utilisateur
            int nombre = sc_nombre.nextInt();
            //TODO : faire un systeme permettant d'entrer V, D, R ou A a la place d'un int
            System.out.print("Couleur : ");
            Scanner sc_couleur = new Scanner(System.in);
            String couleur = sc_couleur.nextLine();
            if ((couleur.equals("Co") || couleur.equals("Ca") || couleur.equals("Tr") || couleur.equals("Pi")) && nombre >= 1 && nombre <= 13)
            {
                boolean nouvelle = true;
                for (Carte x:paquet)//On verifie que la carte introduite ne soit pas un doublon
                    if (x.nombre == nombre && x.couleur.equals(couleur))
                        nouvelle = false;//Si c'est le cas, on l'indique
                if (!nouvelle)
                    continue;//Si ce n'est pas une nouvelle carte, on passe au tour de boucle suivant
                paquet.add(new Carte(nombre, couleur));
            }
        }

        System.out.print("Main 1: ");
        Main joueur1 = new Main(paquet);//Initialisation du joueur 1 et 2
        System.out.println("");
        System.out.print("Main 2: ");
        Main joueur2 = new Main(paquet);
        System.out.println("");
        int j1 = joueur1.valeur_main(), j2 = joueur2.valeur_main();
        String gagnant = "La main ";
        if (j1 > j2) gagnant += "1 gagne avec "+Main.combinaisons(j1)+Main.valeur_to_indiceComplet(((j1-1)%13)+1);
        else if (j2 > j1) gagnant += "2 gagne avec "+Main.combinaisons(j2)+Main.valeur_to_indiceComplet(((j2-1)%13)+1);
        else gagnant = "Egalite !";
        System.out.print(gagnant);
    }
}
