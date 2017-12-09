import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class KodeRahasia {
    public static void main(String[] args) {
        bacaInput();
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

    public static boolean palindrom2(String str) {
        if (str.length() == 1 || str.length() == 0) 
            return true;
        else if (str.length() == 2 &&  (str.charAt(0) == str.charAt(1))) 
            return true;
        else if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;
        else 
            return palindrom2(str.substring(1, str.length() - 1));
    }

	public static String clean(String str) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
		str = pattern.matcher(str).replaceAll("");
        str = str.toLowerCase().trim();
        return str;
    }

    public static void bacaInput() {
        ArrayList<Integer> palindroms = new ArrayList<Integer>();
        ArrayList<Integer> bukanPalindroms = new ArrayList<Integer>();
        ArrayList<String> strings = new ArrayList<String>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            strings.add(str);
            if (palindrom2(clean(str))) {
                palindroms.add(i);
            }
            else {
                bukanPalindroms.add(i);
            }
        }

        for (String str: strings) {
            System.out.println(str);
        }

        System.out.println(palindroms.size());

        for (int i: palindroms) {
            System.out.printf("KODE#%d#KODE RAHASIA%n", i + 1);
        }
        for (int i: bukanPalindroms) {
            System.out.printf("KODE#%d#BUKAN KODE RAHASIA%n", i + 1);
        }
    }
}