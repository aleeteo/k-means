import java.lang.Math;
import java.util.Random;

public class Metodi{
    //questo metodo si occupa di inizializzare la matrice bidimensionale dati riempiendola con
    //valori double compresi tra 0 e 1
    public static void inizializzaDati(double dati[][]) {
        for (int i = 0; i < dati.length; i++){
            for (int k = 0; k < (dati[i].length); k++){
                //il metodo Math.random genera un numero decimale pseudocasuale compreso tra 0 e 1
                dati[i][k] = Math.random();
            }
        }
    }

    //questo metodo si occupa di inzializzare la matrice bidimensionale centri
    //questa matrice contiene k righe, dove k è il numero di cluster che si decide di creare
    //inizialmente alle reghe di centri vengono assegnate righe della matrice dati senza reimmissione
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

    //questo metodo si occupa di aggiornare i valori del centro di ogni cluster
    //il valore del centro corrisponde alla media dei valori assunti da ogni oggetto appartenete
    //al cluster
    public static void aggiornaCentri(double centri[][], double dati[][], int cluster[]) {
        int[] indC = new int[dati.length];
        int counter = 0;
        double somma = 0;
        for (int i = 0; i < centri.length; i++) {
            counter = 0;
            for (int k = 0; k < dati.length; k++){
                if (cluster[k]== i) {
                    indC[counter] = k + 1;
                    counter++;
                }
            }
            somma = 0;
            for (int k = 0; k < centri[0].length; k++) {
                int j = 0;
                while (j < indC.length && indC[j] != 0) {
                    somma += dati[indC[j] - 1][k];
                    j++;
                }
                // while (indC[j] != 0) {
                //     somma += dati[(indC[j] - 1)][k];
                //     j++;
                // }
                centri[i][k] = somma/j;
            }
            for (int k = 0; k < indC.length; k++) {
                indC[k] = 0;
            }
        }
    }

    //questo metodo si occupa di calcolare la distanza tra due elementi
    //(solitamente un centro e un oggetto)
    //e sfrutta un formula che richiede tutti i valore contenuti nella riga
    public static double calcolaDistanza(double[] dati, double[] centri) {
        double somma = 0, distanza = 0;
        for (int i = 0; i < dati.length; i++) {
            somma += Math.pow((centri[i] - dati[i]), 2);
        }
        distanza = Math.sqrt(somma);
        return distanza;
    }

    //questo metodo si occupa di calcolare il cluster di appartenenza di ogni oggetto
    //questo è possibile calcolando la distanza tramite il metodo precedente
    //e salvando il centro con la distanza minore
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

    //questo metodo calcola il valore della funzione obbiettivo tramite la formula
    //fornita nel whitepaper
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

    //questo metodo si occupa di stampare double a piacere formattandola in modo leggibile
    public static void stampaMatrice(double[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int k = 0; k < matrice[i].length; k++) {
                System.out.print(matrice[i][k]+" ");
            }
            System.out.println("");
        }
    }

    //questo metodo stampa i cluster formattandoli in modo leggibile
    public static void stampaCluster(double[][] dati, double[][] centri, int[] cluster) {
        for (int i = 0; i < centri.length; i++) {
            System.out.println("cluster " + (i+1));
            for (int k = 0; k < dati.length; k++) {
                if (cluster[k] == i) {
                    for (int h = 0; h < dati[0].length; h++) {
                        System.out.print(dati[k][h]);
                    }
                    System.out.println("");
                }
            }
            System.out.println("------------------------------------------");
        }
    }
}
