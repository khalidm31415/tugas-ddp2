public class Rekursif{
    public static void main(String[] args){
        System.out.println("abc".toCharArray());
        System.out.println(banyak("aabbccddegha"));
        System.out.println(kali(12,3));
        System.out.println(bilSegitiga(3));
        System.out.println(reverse("abcd"));
        System.out.println(jumlahA("ababffaba"));
        System.out.println(jumlahGenap(12345678));
    }

    public static int banyak(String a){
        if(a.length() > 1){
            if (a.charAt(0) == a.charAt(1))
                return 1 + banyak(a.substring(1));
            else
                return banyak(a.substring(1));
        }
        else 
            return 0;
    }

    public static int kali(int a, int b){
        if (a == 1)
            return b;
        else if (a > 1)
            return b + kali(a - 1, b); 
        return 0;
    }

    public static int bilSegitiga(int N){
        if (N == 1)
            return 1;
        else if (N < 1)
            return 0;
        else
            return N + bilSegitiga(N - 1);
    }

    public static String reverse(String str){
        if (str.length() == 1)
            return str;
        else
            return reverse(str.substring(1)) + str.charAt(0);
    }

    public static int jumlahA(String str){
        if (str.charAt(0) == 'a'){
            if (str.length() == 1)
                return 1;
            else
                return 1 + jumlahA(str.substring(1));
        }
        else 
            return jumlahA(str.substring(1));
    }

    public static int jumlahGenap(int x){
        if ((x < 10) && (x % 2 == 0))
            return 1;
        else if (x > 10){
            if ((x % 10) % 2 == 0)
                return 1 + jumlahGenap(x / 10);
            else 
                return jumlahGenap(x / 10);
        }
        else
            return 0;
    }
}