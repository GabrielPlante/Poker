import java.util.ArrayList;
public class Main {
    public Main(ArrayList<Carte> paquet)
    {
        for (int i = 0;i!=5;++i){
            int x = (int)(Math.random()*paquet.size());
            cartes.add(paquet.get(x));
            paquet.remove(x);
        }
        for (Carte y:cartes){
            System.out.print(y.nombre+" ");
        }
        System.out.print("\n");
    }
    public int valeur_main()
    {
        if (paire() != 0)
            return 14+paire();
        else return plus_haute_carte();

    }
    private int paire()
    {
        for (Carte y:cartes)
        {
            for (Carte x:cartes)
            {
                if (y.nombre == x.nombre && y.couleur != x.couleur)
                    return x.nombre;
            }
        }
        return 0;
    }
    private int plus_haute_carte()
    {
        int x = 0;
        for (Carte y:cartes)
            if (y.nombre > x) x = y.nombre;
        return x;
    }
    private ArrayList<Carte> cartes = new ArrayList<>();
}