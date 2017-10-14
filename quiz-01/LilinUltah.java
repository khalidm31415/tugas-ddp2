import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class LilinUltah {

    public static int birthdayCakeCandles(int n, int[] ar) {
        // Mensortir array ar untuk melihat nilai terbesarnya
        Arrays.sort(ar);

        // Menyimpan nilai terbesar array ar ke variabel max
        int max = ar[n - 1];

        // inisiasi variabel jml untuk menghitung banyaknya elemen array ar yang sama dengan nilai max
        int jml = 0;

        // Menghitung banyaknya elemen array ar yang sama dengan nilai max
        for (int i: ar){
            if (i == max)
                jml++;
        }
        return jml;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
