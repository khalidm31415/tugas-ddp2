import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Bintang{
    public static void main(String[] args) {
        System.out.println("Masukkan m dan n (dipisah dengan spasi): ");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        Bintang.bintangBintang(m, n);
    }

    public static void bintangBintang(int m, int n) {
        for (int i = 1; i <= ((n % 2 == 0) ? (n/2):(n/2 + 1)); i++) {
            System.out.println(StringUtils.repeat(" ", i - 1) + StringUtils.repeat("* ", m));
        }
        for (int i = 1; i <= n/2; i++) {
            System.out.println(StringUtils.repeat(" ", n/2 - i) + StringUtils.repeat("* ", m));
        }
    }
}