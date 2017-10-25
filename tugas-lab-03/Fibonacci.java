import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Mau print bilangan fibonacci ke-berapa?");
        //Scanner input = new Scanner(System.in);
        //long n = input.nextLong();
        //System.out.println("Bilangan fibonacci ke " + n + ": " + fib(n));
        System.out.println("asfasf".toSentenceCase());
    }

    public static long fib(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else if (n >= 3) {
            return fib(n - 1) + fib(n - 2);
        }
        else {
            return 0;
        }
    }
}