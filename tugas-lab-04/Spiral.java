import java.util.Scanner;

public class Spiral {
    public static void main(String[] args) {
        System.out.println("Masukkan ukuran matriks: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] spimat = Spiral.spiralMatrix(n);
        Spiral.printMatriks(spimat);
    }

    // method ini me-return sebuah matriks spiral seperti di soal
    public static int[][] spiralMatrix(int n) {
        // inisialisasi array dan menentukan jumlah loop
        int[][] spimat = new int[n][n];
        int nloop = n / 2; 

        // untuk n genap
        if (n % 2 == 0) {
            int isi = 0;
            for (int k = 0; k < nloop; k++) {
                
                // isi bagian atas
                for (int i = k; i < n - k; i++) {
                    spimat[k][i] = isi % 10;
                    isi++;
                }

                if (k < nloop - 1){
                // isi bagian kanan
                for (int i = k + 1; i < n - 1 - k; i++) {
                    spimat[i][n-1-k] = isi % 10;
                    isi++;
                }
                }

                // isi bagian bawah
                for (int i = n - 1 - k; i >= 0 + k; i--){
                    spimat[n - 1 - k][i] = isi % 10;
                    isi++;
                }

                if (k < nloop - 1){
                // isi bagian kiri
                for (int i = n - 1 - k - 1; i > 0 + k; i--){
                    spimat[i][k] = isi % 10;
                    isi++;
                }
                }
            }

        }

        // untuk n ganjil
        else if (n % 2 != 0) {
            int isi = 0;
            for (int k = 0; k < nloop; k++) {
                
                // isi bagian atas
                for (int i = k; i < n - k; i++) {
                    spimat[k][i] = isi % 10;
                    isi++;
                }

                // isi bagian kanan
                for (int i = k + 1; i < n - 1 - k; i++) {
                    spimat[i][n-1-k] = isi % 10;
                    isi++;
                }

                // isi bagian bawah
                for (int i = n - 1 - k; i >= 0 + k; i--){
                    spimat[n - 1 - k][i] = isi % 10;
                    isi++;
                }

                // isi bagian kiri
                for (int i = n - 1 - k - 1; i > 0 + k; i--){
                    spimat[i][k] = isi % 10;
                    isi++;
                }
            }

            // isi elemen yang di tengah
            spimat[n/2][n/2] = isi % 10;
        }

        return spimat;
    }

    public static void printMatriks(int[][] matriks) {
        int n = matriks.length;
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matriks[i][j]);
            }
        }
        System.out.println("\n");
    }
}