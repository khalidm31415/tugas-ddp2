import java.util.Scanner;

public class Tugas2{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    char[] pemain = input.toCharArray();
    System.out.println(pemain);
    int counter = 1;

    for (int i = 1; i < pemain.length; i++){
      if (pemain[i] == pemain[i-1]){counter += 1;}
      else {counter = 1;}
      if (counter == 7){
        System.out.println("BERBAHAYA");
        break;
      }
    }
    if (counter < 7){System.out.println("TIDAK BERBAHAYA");}
  }
}
