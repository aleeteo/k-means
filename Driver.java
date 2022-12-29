public class Driver {
    public static void testInizializzacluster(){
        double dati1[][] = new double[3][3];
        Metodi.inizializzaDati(dati1);
        double centri1[][] = new double[1][3];
        Metodi.inizializzaCluster(centri1, dati1);
        Metodi.stampaMatrice(dati1);
        Metodi.stampaMatrice(centri1);

        double dati2[][] = new double[5][2];
        Metodi.inizializzaDati(dati2);
        double centri2[][] = new double[2][1];
        Metodi.inizializzaCluster(centri2, dati2);
        Metodi.stampaMatrice(dati2);
        Metodi.stampaMatrice(centri2);

        double dati3[][] = new double[4][6];
        Metodi.inizializzaDati(dati3);
        double centri3[][] = new double[2][6];
        Metodi.inizializzaCluster(centri3, dati3);
        Metodi.stampaMatrice(dati3);
        Metodi.stampaMatrice(centri3);

        double dati4[][] = new double[3][4];
        Metodi.inizializzaDati(dati4);
        double centri4[][] = new double[5][4];
        Metodi.inizializzaCluster(centri4, dati4);
        Metodi.stampaMatrice(dati4);
        Metodi.stampaMatrice(centri4);
    }
}
