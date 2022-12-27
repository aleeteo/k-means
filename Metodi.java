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
        int[] indC = new int[dati.length];
        int indT = 0;
        for (int i = 0; i < centri.length; i++) {
            indT = 0;
            for (int k = 0; k < dati.length; k++){
                if (cluster[k]== i) {
                    indC[indT] = k + 1;
                    indT++;
                }
            }
            int somma = 0;
            for (int k = 0; k < centri[0].length; k++) {
                int j = 0;
                while (indC[j] != 0) {
                    somma += dati[indC[j]][k];
                    j++;
                }
                centri[i][k] = somma/j;
            }
        }
    }

    public static double calcolaDistanza(double[] dati, double[] centri) {
        double somma = 0, distanza = 0;
        for (int i = 0; i < dati.length; i++) {
            somma += Math.pow((centri[i] - dati[i]), 2);
        }
        distanza = Math.sqrt(somma);
        return distanza;
    }

    public static void calcolaCluster(double[][] dati, double[][] centri, int[] cluster) {
        double min = 0, distanza = 0;
        int nuovoCentro = 0;
        for (int i = 0; i < dati.length;i++) {
            min = calcolaDistanza(dati[i], centri[0]);
            for (int k = 0; k < centri.length; k++) {
                distanza = calcolaDistanza(dati[i], centri[k]);
                if (distanza < min) {
                    min = distanza;
                    nuovoCentro = k;
                }
            }
            cluster[i] = nuovoCentro;
        }
    }

    public static double calcolaObbiettivo(double[][] dati, double[][] centri, int[] cluster) {
        double sommaParziale = 0, somma = 0;
        for (int i = 0; i < centri.length; i++) {
            sommaParziale = 0;
            for (int k = 0; k < dati.length; k++) {
                if (cluster[k] == i) {
                    sommaParziale += calcolaDistanza(dati[k], centri[i]);
                }
            }
            somma += sommaParziale;
        }
        return somma;
    }
}
