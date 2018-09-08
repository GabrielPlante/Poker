import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {
        ArrayList<Integer> paquet = new ArrayList<Integer>();
        for (int i = 1;i!=14;++i)
        {
            paquet.add(i);
        }
        System.out.print(paquet+"\n");
        Main joueur1 = new Main(paquet);
        System.out.print(paquet+"\n");
        Main joueur2 = new Main(paquet);
        System.out.print(paquet+"\n");
        String gagnant = "Le joueur "+((joueur1.plus_haute_carte()>joueur2.plus_haute_carte()) ? "1" : "2") + " gagne !";
        System.out.print(gagnant);
    }
}
