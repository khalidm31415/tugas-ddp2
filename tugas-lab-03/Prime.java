public class Prime {
    public static void main(String[] args) {
        int[] arr3 = {10177, 10839};
        for (int i: arr3){
            if (Prime.millerRabinPrimeTest(i))
                System.out.println("Prime: " + i);
            else
                System.out.println("Not Prime: " + i);
        }
    }

    // Method untuk men-generate bilangan bulat acak dengan range 2 sampai max sebanyak size
    public static int[] random(int max, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                int r = (int) (Math.random() * max + 2);
                if (Prime.contains(arr, r)) {
                    continue;
                }
                arr[i] = r;
                break;
            }
        }
        return arr;
    }

    // Method untuk memeriksa apakah sebuah bil. bulat terdapat dalam sebuah array
    public static boolean contains(int[] arr, int k) {
        for (int i: arr){
            if (i == k){
                return true;
            }
        }
        return false;
    }

    // Method untuk menulis n - 1 sebagai (2^k)*q
    public static int[] twoPowerQ(int n){
        int[] kq = new int[2];
        int q = n - 1;
        int k = 0;
        while (q % 2 == 0){
            q = q / 2;
            k = k + 1;
        }
        kq[0] = k; kq[1] = q;
        return kq;
    }

    public static int gcd(int a, int b){
        if (b > a){
            int temp = b; b = a; a = temp; 
        }
        int r = a % b;
        
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    // Method untuk memeriksa apakah sebuah bil. bulat p merupakan bil. prima
    public static boolean millerRabinPrimeTest(int p){
        int[] small = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,
                        73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,
                        151,157,163,167,173,179,181,191,193,197,199,211,223,227};
        for (int c: small){
            if ((p > c) && (p % c == 0)) {
                return false;
            }
            else if (p == c)
                return true;
        }
        int[] arr = Prime.random(p, 10);
        int k = Prime.twoPowerQ(p)[0];
        int q = Prime.twoPowerQ(p)[1];
        for (int a: arr){
            if (Prime.gcd(a, p) > 1 && Prime.gcd(a,p) < p){
                System.out.println("Check #1"); 
                return false;
            }
            int a_ = ((int) Math.pow(a, q)) % p;
            if (a_ == 1)
                continue;
            int i = 0;
            for (; i <= k - 1;){
                if (a_ == (p - 1))
                    break;
                a_ = (a_ * a_) % p;
                i = i + 1;
            }
            System.out.println(i == k - 1);
            System.out.println(i == k);
            
        }
        return true;
    }
}