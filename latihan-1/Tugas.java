import java.util.Scanner;
import java.util.ArrayList;

public class Tugas {
  public static void main(String[] args){
    int counter = 1;
    Scanner input = new Scanner(System.in);
    Long n = input.nextLong();
    System.out.println(n);

    // Mengubah input menjadi list
    ArrayList<Long> digits = new ArrayList<Long>();
    while (n > 0) {
      digits.add(n%10);
      n/=10;
    }

    int size = digits.size();

    for (int i = 1; i < digits.size(); i++) {
      if (digits.get(i) == digits.get(i-1)){counter += 1;}
      else {counter = 1;}
      if (counter == 7){
        System.out.println("BERBAHAYA");
        break;
      }
    }
    if (counter < 7){
      System.out.println("TIDAK BERBAHAYA");
    }
  }
}
