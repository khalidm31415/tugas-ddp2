import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Matrix{
    // Method untuk membuat matrix n x n dengan isi bil. bulat acak
    public static int[][] randomArray(int n){
        Random rnd = new Random();
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = rnd.nextInt(10);
            }
        }
        return arr;
    }

    // Method untuk mencetak array integer
    public static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method untuk mengacak array
    public static int[][] shuffleArray(int[][] arr){
        int[][] shuffled = new int[arr.length][arr[0].length];

        // Pertama semua elemen dalam array dimasukkan ke dalam ArrayList
        ArrayList<Integer> shuffleList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                shuffleList.add(arr[i][j]);
            }
        }

        // Lalu, ArrayList ini di-shuffle dengan method Collection.shuffle()
        Collections.shuffle(shuffleList);

        // Setelah itu, elemen-elemen ArrayList yang sudah di-acak ini,
        // dimasukkan satu per satu ke dalam array baru
        int k = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                shuffled[i][j] = shuffleList.get(k);
                k++;
            }
        }
        return shuffled;
    }
}