import java.lang.Math;
import java.util.Random;

public class Metodi{
    public static void inizializzaDati(double dati[][]) {
        for (int i = 0; i < dati.length; i++){
            for (int k = 0; k < (dati[i].length); k++){
                dati[i][k] = Math.random();
            }
        }
    }

    public static void inizializzaCluster(double centri[][], double dati[][]) {
        int k = centri.length;
        if (k > dati.length) {
            System.out.println("k non può essere maggiore del numero di dati inseriti");
            System.exit(0);
        }
        Random r = new Random();

        int[] ind = new int[dati.length];
        for (int i = 0; i < ind.length; i++) {
            ind[i] = i;
        }

        int j = ind.length -1, l = 0;
        for (int i = 0; i < k; i++) {
            l = r.nextInt(j);
            for (int h = 0; h < centri[i].length; h++) {
                centri[i][h] = dati[l][h];
            }
            for (int h = l; h < (ind.length -1); h++) {
                ind[h] = ind[h+1];
            }
            j--;
        }
    }

    public static void aggiornaCentri(double centri[][], double dati[][], int cluster[]) {
        int indC = new ind[dati.length];
        int indT = 0, somma = 0, media = 0;
        for (int i = 0; i < centri.length; i++) {
            indT = 0;
            for (int k = 0; k < dati.length; k++){
                if (cluster[k]==centri[i]) {
                    indC[indT] = i;
                    intT++;
                }
            }
            for (int k = 0; k < centri[0].length; k++) {
                somma += dati
            }
        }
    }
}
