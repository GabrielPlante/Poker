import java.util.ArrayList;
public class Main {
    public Main(ArrayList<Carte> paquet)//Le constructeur
    {
        for (int i = 0;i!=5;++i){
            int x = (int)(Math.random()*paquet.size());
            cartes.add(paquet.get(x));//On associe une carte random du paquet à la main
            paquet.remove(x);//On l'enleve du paquet
        }
        for (Carte y:cartes){
            System.out.print(y.nombre+" "); // Pour le debugage
        }
        System.out.print("\n");
    }
    public int valeur_main()
    {
        if (double_paire() != 0)
            return 26+double_paire();//13+13=26
        if (paire() != 0)
            return 13+paire();//plus haute carte est entre 1 et 13, paire aussi.
        else return plus_haute_carte();
    }
    private int double_paire()
    {
        int a = 0, max = 0;// a:nombre de pair, max la valeur de la plus grande paire
        for (Carte y:cartes)
        {
            for (Carte x:cartes)
            {
                if (y.nombre == x.nombre && y.couleur != x.couleur)
                {
                    if (y.nombre >= max)
                        max = y.nombre;
                    ++a;
                }
            }
        }
        if (a == 2) //Si on a trouve 2 paire, on renvoit la valeur
            return max;
        else return 0;//Sinon on revoit 0, qui sert de false
    }
    private int paire()
    {
        for (Carte y:cartes)
        {
            for (Carte x:cartes)
            {
                if (y.nombre == x.nombre && y.couleur != x.couleur)//On regarde si c'est le meme nombre et pas la meme couleur
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
}