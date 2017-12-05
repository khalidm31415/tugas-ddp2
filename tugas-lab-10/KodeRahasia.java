import java.util.Scanner;
import java.util.ArrayList;

public class KodeRahasia {
    public static void main(String[] args) {
        System.out.println(palindrom(clean("ababa")));
        System.out.println(palindrom("khalid"));
        System.out.println(palindrom("nababan"));
        System.out.println(palindrom("123"));
        System.out.println(palindrom(clean("A tin mug for a jar of gum, Nita.")));
        System.out.println(palindrom(clean("Draw, O coward!")));
    }

    public static boolean palindrom(String str) {
        boolean pal = true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - (i + 1))) {
                pal = false;
                break;
            }
        }
        return pal;
    }

    public static String clean(String str) {
        String[] tandaBaca = {".", ",", "!", "?", "(", ")", "&", "%", " "};
        for (String c: tandaBaca) {
            str = str.replace(c, "");
        }
        str = str.toLowerCase().trim();
        return str;
    }

    public static void bacaInput() {
        ArrayList<Integer> palindroms = new ArrayList<Integer>();
        ArrayList<Integer> bukanPalindroms = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            if (palindrom(clean(str))) {
                palindroms.add(i);
            }
            else {
                bukanPalindroms.add(i);
            }
        }
        
    }
}