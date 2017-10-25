import java.util.Arrays;

public class Bilik{

    // Method untuk membuat matrix bilik
    public static String[][] bilik(int n){
        int lebar = (2 * n) + 1;
        String[][] bilik = new String[n][lebar];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < lebar; j++){
                if (j == n)
                    bilik[i][j] = " ";
                else
                    bilik[i][j] = "*";
            }
        }
        return bilik;
    }

    // Method untuk mencetak bilik
    public static void cetakBilik(String[][] arr){
        int cellWidth = (arr[0].length > 7) ? 2 * arr[0].length : 10;
        System.out.printf("%-" + cellWidth + "s%-" + cellWidth + "s\n", "Bilik A", "Bilik B");
        for (int i = 0; i < arr.length; i++){
            String[] arrayBilikA = Arrays.copyOfRange(arr[i], 0, arr[i].length/2);
            String[] arrayBilikB = Arrays.copyOfRange(arr[i], arr[i].length/2 + 1, arr[i].length);
            String bilikA = String.join(" ", arrayBilikA);
            String bilikB = String.join(" ", arrayBilikB);
            System.out.printf("%-" + cellWidth + "s%-" + cellWidth + "s\n", bilikA, bilikB);
        }
        System.out.println();
    }
}