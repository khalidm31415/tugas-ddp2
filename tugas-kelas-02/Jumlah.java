import java.util.Arrays;

public class Jumlah {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(jml(arr));
    } 

    public static int jml(int[] arr){
        if (arr.length == 1) return arr[0];
        else if (arr.length == 2) return arr[0] + arr[1];
        else {
            return jml(Arrays.copyOfRange(arr, 0, arr.length/2)) + jml(Arrays.copyOfRange(arr, arr.length/2, arr.length));
        }
    }
}