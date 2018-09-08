import java.util.ArrayList;
public class Main {
    public Main(ArrayList<Integer> paquet)
    {
        for (int i = 0;i!=5;++i){
            int x = (int)(Math.random()*paquet.size());
            cartes.add(paquet.get(x));
            paquet.remove(x);
            for (Integer y:cartes){
                System.out.print(y+" ");
            }
            System.out.print("\n");
        }
    }
    public int plus_haute_carte()
    {
        int x = 0;
        for (Integer y:cartes)
            if (y > x) x = y;
        return x;
    }
    private ArrayList<Integer> cartes = new ArrayList<Integer>();
}