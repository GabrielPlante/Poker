import java.util.ArrayList;
public class Main {
    public Main(ArrayList<Carte> paquet)//Le constructeur
    {
        for (int i = 0;i!=5;++i){
            cartes.add(paquet.get(0));//On associe la premiere du paquet à la main
            paquet.remove(0);//On l'enleve du paquet
        }
        for (Carte y:cartes){
            System.out.print(Main.valeur_to_indiceDim(y.nombre)+y.couleur+" "); // Pour l'affichage de la main
        }
    }
    /*MANUEL : Implementer une nouvelle fonction :
    Faire une fonction avec le bon nom (couleur, carre...)
    Elle doit etre "private int"
    Elle ne doit pas prendre d'argument
    Elle doit renvoyer 0 si elle ne trouve pas ce qu'elle cherche
    Elle doit renvoyer ça valeur (qui est comprise entre 1 et 13 inclus)
    Ensuite il faut modifier la fonction valeur_main:
    Il faut tester votre combinaison apres les combinaisons plus fortes et avant les combinaisons plus faible
    Il faut tester si elle est different de 0 (au quelle cas la combinaison existe dans la main)
    Si la combinaison existe effectivement, renvoyer n*13+la fonction
    n est le nombre de combinaison inferieure a celle que vous codez
     */

    /*
    Ajout de la suite.
    Le jeu affiche deux mains de cinq cartes et indique laquelle est la plus forte sans tenir compte des
    combinaisons: couleur, full, carré et quinte flush.
    */


    public int valeur_main()
    {
        if (quinte_flush() != 0)
            return 104+quinte_flush();
        if (carre() != 0)
            return 91+carre();
        if (full() != 0)
            return 78+full();
        if (couleur() != 0)
            return 65+couleur();
        if (suite() != 0)
            return 52+suite();
        if (brelan() != 0)
            return 39+brelan();
        if (double_paire() != 0)
            return 26+double_paire();//13+13=26
        if (paire() != 0)
            return 13+paire();//plus haute carte est entre 1 et 13, paire aussi.
        else return plus_haute_carte();
    }

    private int quinte_flush()
    {
        if (suite() != 0 && couleur() != 0)
            return plus_haute_carte();
        return 0;
    }

    private int carre()//On teste chaque nombre s'il est 4 fois dans la main
    {
        for (int i = 1; i!= 14; ++i)
        {
            int nbr = 0;
            for (Carte x:cartes)
            {
                if (x.nombre == i)
                    ++nbr;
            }
            if (nbr == 4)
                return i;
        }
        return 0;
    }

    private int full()//On teste si il y a un brelan et une paire, et qu'il soit de nombre different
    {
        if (brelan() != 0)
            for (Carte x:cartes)
                for (Carte y:cartes)
                    if (x.nombre == y.nombre && !x.couleur.equals(y.couleur) && x.nombre != brelan())
                        return brelan();
        return 0;
    }

    private int couleur()//On teste si la couleur de chaque carte est la meme que la couleur de la carte suivante
    {
        for (int i = 0; i!=cartes.size()-1;++i)
        {
            if (!cartes.get(i).couleur.equals(cartes.get(i+1).couleur))
                return 0;
        }
        return plus_haute_carte();
    }

    private int suite() {
        int min = 13;
        int isAllHere = 0;
        for (Carte y: cartes){
            if (y.nombre < min) min = y.nombre;
        }
        for (int i = min + 1; i <= min +4; i++){
            for (Carte y: cartes) {
                if (y.nombre == i) {
                    isAllHere += 1;
                    break;
                }
            }
        }

        if (isAllHere == 4) return plus_haute_carte();
        return 0;
    }

    private int brelan()//Systeme different que paire, on s'assure que chaque carte (i, j, et k) soient differentes
    {
        for (int i = 0; i!=cartes.size()-2;++i)
        {
            for (int j = i+1; j < cartes.size(); ++j)
            {
                for (int k = j+1; k < cartes.size(); ++k)
                {
                    if (cartes.get(i).nombre == cartes.get(j).nombre && cartes.get(j).nombre == cartes.get(k).nombre)
                        return cartes.get(i).nombre;
                }
            }
        }
        return 0;
    }

    private int double_paire()
    {
        int a = 0, max = 0;// a:nombre de pair, max la valeur de la plus grande paire
        for (Carte y:cartes)
        {
            for (Carte x:cartes)
            {
                if (y.nombre == x.nombre && !y.couleur.equals(x.couleur))
                {
                    if (y.nombre >= max)
                        max = y.nombre;
                    ++a;
                }
            }
        }
        if (a == 4) //On teste chaque carte, donc s'il y a une paire, a == 2, si il y a 2 paire, a == 4
            return max;
        else return 0;//Sinon on revoit 0, qui sert de false
    }
    private int paire()
    {
        for (Carte y:cartes)
        {
            for (Carte x:cartes)
            {
                if (y.nombre == x.nombre && !y.couleur.equals(x.couleur))//On regarde si c'est le meme nombre et pas la meme couleur
                    return x.nombre;
            }
        }
        return 0;
    }
    private int plus_haute_carte()
    {
        int x = 0;
        for (Carte y:cartes)//simple
            if (y.nombre > x) x = y.nombre;
        return x;
    }
    private ArrayList<Carte> cartes = new ArrayList<>();//La liste qui contient les cartes de la main du joueur

    public static String combinaisons(int x) {//Permet de savoir avec la valeur de valeur_main à quoi on a affaire
        x = (x-1)/13;
        switch (x)
        {
            case 0: return "carte la plus élevée : ";
            case 1: return "paire de ";
            case 2: return "double paire de ";
            case 3: return "brelan de ";
            case 4: return "suite de ";
            case 5: return "couleur de ";
            case 6: return "full de ";
            case 7: return "carre de ";
            case 8: return "quinte flush de ";
            default: return "C'est pas bon";
        }
    }
    public static String valeur_to_indiceDim(int x) //Pour transformer la valeur en la l'indice du diminutif de la carte
    {
        if (x < 10)
            return Integer.toString(x+1);
        switch (x)
        {
            case 10: return "V";
            case 11: return "D";
            case 12: return "R";
            case 13: return "A";
            default: return "C'est pas bon";
        }
    }
    public static String valeur_to_indiceComplet(int x) //Pour transformer la valeur en la l'indice complet de la carte
    {
        if (x < 10)
            return Integer.toString(x+1);
        switch (x)
        {
            case 10: return "Valet";
            case 11: return "Dame";
            case 12: return "Roi";
            case 13: return "As";
            default: return "C'est pas bon";
        }
    }
}