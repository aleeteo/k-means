import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        System.out.println("quanti dati vuoi inserire?");
        int m = t.nextInt();
        System.out.println("quante feature per dato?");
        int n = t.nextInt();

        double[][] dati = new double[m][n];
        Metodi.inizializzaDati(dati);

        double obbiettivo = 0;
        int[] cluster = new int[m];

        System.out.println("quanti cluster vuoi creare?");
        int k = t.nextInt();
        double[][] centri = new double[k][n];
        Metodi.inizializzaCluster(centri, dati);
    }
}
