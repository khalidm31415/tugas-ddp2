import java.util.Scanner;

public class Artifact{
    public static void main(String[] args){
        bacaInputTrusHitungMax();
    }

    public static int knapsack(int[] weights, int[] values, int C, int index){
        if (C == 0 || index == weights.length) return 0;
        if (weights[index] > C) return knapsack(weights, values, C, index + 1);
        
        int ambilMax = values[index] + knapsack(weights, values, C - weights[index], index + 1);
        int gakAmbilMax = knapsack(weights, values, C, index + 1);
        return Math.max(ambilMax, gakAmbilMax);
    }

    public static void bacaInputTrusHitungMax(){
        System.out.println("Masukkan banyak barang dan kapasitas tas (dipisah denga spasi): ");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(); int C = input.nextInt();
        int[] weights = new int[N]; int[] values = new int[N];
        System.out.println("Masukkan harga-harga barang: ");
        Scanner input2 = new Scanner(System.in);
        for (int i = 0; i < N; i++){
            values[i] = input2.nextInt();
        }
        System.out.println("Masukkan berat-berat barang: ");
        Scanner input3 = new Scanner(System.in);
        for (int i = 0; i < N; i++){
            weights[i] = input3.nextInt();
        }
        System.out.println("Nilai keuntungan maksimum yang mungkin didapat adalah: ");
        System.out.println(knapsack(weights, values, C, 0));
    }
}