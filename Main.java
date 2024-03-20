import java.*;
import java.lang.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner t = new Scanner(System.in);

    // chiedo e prendo da tastiera le dimensioni della matrice dati
    // m è la quantità di oggetti da inserire
    // n è il numero di features di ogni oggetto
    System.out.println("quanti oggetti vuoi inserire?");
    int m = t.nextInt();
    System.out.println("quante feature per oggetto?");
    int n = t.nextInt();

    // creo la matrice dati delle dimensioni appena inserite e
    // la inizializzo con il metodo inizializzaDati
    double[][] dati = new double[m][n];
    Metodi.inizializzaDati(dati);

    // creo la variabile obbiettivo che indica il valore della funzione
    // obbiettivo
    double obbiettivo = 0;
    // creo l'array cluster, contenente l'indice del cluster (matrice centri
    // creata in seguito) di ogni variabile
    int[] cluster = new int[m];

    // chiedo e prendo da tastiera la quantità di k di cluster desiderati
    // dall'utente e inizializzo la matrice centri di dimensioni [k][n] (con n
    // già inserito precedentemente) e inserendo al suo interno degli oggetti
    // casuali, senza reimmissione dalla matrice dati
    System.out.println("quanti cluster vuoi creare?");
    int k = t.nextInt();
    double[][] centri = new double[k][n];
    Metodi.inizializzaCluster(centri, dati);

    // Driver.testInizializzacluster();

    System.out.println("------------------------------------------");
    System.out.println("matrice dati");
    Metodi.stampaMatrice(dati);
    System.out.println("------------------------------------------");

    System.out.println("matrice centri");
    Metodi.stampaMatrice(centri);
    System.out.println("------------------------------------------");

    for (int i = 0; i < 10; i++) {
      Metodi.calcolaCluster(dati, centri, cluster);
      Metodi.aggiornaCentri(centri, dati, cluster);
      System.out.println("matrice centri aggiornata");
      Metodi.stampaMatrice(centri);
      System.out.println("------------------------------------------");

      obbiettivo = Metodi.calcolaObbiettivo(dati, centri, cluster);
      System.out.println("obbiettivo");
      System.out.println(obbiettivo);
      System.out.println("------------------------------------------");

      Metodi.stampaCluster(dati, centri, cluster);
    }
  }
}
