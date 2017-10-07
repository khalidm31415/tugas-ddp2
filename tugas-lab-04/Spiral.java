import java.util.Scanner;

public class Spiral {
    public static void main(String[] args) {
        System.out.println("Masukkan ukuran matriks: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] spimat = Spiral.spiralMatrix(n);
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + spimat[i][j]);
            }
        }
        System.out.println("\n");
    }

    public static int[][] spiralMatrix(int n) {
        int[][] spimat = new int[n][n];
        int nloop = n / 2; 


        if (n % 2 == 0) {
            int isi = 0;
            for (int k = 0; k < nloop; k++) {
                
                // isi bagian atas
                for (int i = k; i < n - k; i++) {
                    System.out.println("" + k + " " + i);
                    System.out.println(isi);
                    spimat[k][i] = isi % 10;
                    isi++;
                }

                if (k < nloop - 1){
                // isi bagian kanan
                for (int i = k + 1; i < n - 1 - k; i++) {
                    System.out.println("" + i + " " + (n-1-k));
                    System.out.println(isi);
                    spimat[i][n-1-k] = isi % 10;
                    isi++;
                }
                }

                // isi bagian bawah
                for (int i = n - 1 - k; i >= 0 + k; i--){
                    System.out.println("" + (n - 1 - k) + " " + i);
                    System.out.println(isi);
                    spimat[n - 1 - k][i] = isi % 10;
                    isi++;
                }

                if (k < nloop - 1){
                // isi bagian kiri
                for (int i = n - 1 - k - 1; i > 0 + k; i--){
                    System.out.println("" + i + " " + k);
                    System.out.println(isi);
                    spimat[i][k] = isi % 10;
                    isi++;
                }
                }
            }

        }

        //else if (n % 2 != 0) {

        //}



        return spimat;
    }
}