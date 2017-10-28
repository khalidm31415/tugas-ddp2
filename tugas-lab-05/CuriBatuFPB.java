public class CuriBatuFPB{
    public static void main(String[] args){
        System.out.println(play(3, 5, 12));
    }

    public static int play(int alice, int bob, int n){
        int aliceAmbil = gcd(alice, n);
        int sisaAlice = n - aliceAmbil;
        System.out.printf("Alice mengambil %d batu, sisa %d\n", aliceAmbil, sisaAlice);

        // Kalo Alice bisa menghabiskan semua batu yang ada, 
        // artinya ga ada yang tersisa untuk Bob, maka Alice menang
        if (sisaAlice == 0){
            System.out.println("Alice menang!!!");
            return 0;
        }
        int bobAmbil = gcd(sisaAlice, bob);
        int sisaBob = sisaAlice - bobAmbil;
        System.out.printf("Bob mengambil %d batu, sisa %d\n", bobAmbil, sisaBob);

        // Kalo Bob bisa menghabiskan semua batu yang ada, 
        // artinya ga ada yang tersisa untuk Bob, maka Bob menang
        if (sisaBob == 0){
            System.out.println("Bob Menang!!!");
            return 1;
        }    
        // Kalo di stage pertama belum ada yang menang, lanjut stage berikutnya
        else{
            return play(alice, bob, sisaBob);
        }
    }

    public static int gcd(int a, int b){
        if (a < b){
            if (b % a == 0)
                return a;
            else 
                return gcd(a, b % a);
        }
        else if (a == b)
            return a;
        else
            return gcd(b, a);
    }
}