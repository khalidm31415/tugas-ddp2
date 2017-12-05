public class Anagram{
    public static void main(String[] args){
        printArray(perms("ayam"));
    }

    public static String[] perms(String str){
        // Kalo panjang stringnya 1 atau 0, return array yang isinya str yang diinput
        if(str.length() <= 1){
            String[] arr = {str};
            return arr;
        }
        // Idenya, perms(abc) = gabungan(a + perms(bc), b + perms(ac), c + perms(ab))
        // di mana perms(bc) = [bc, cb]
        else{
            String[][] perm = new String[str.length()][factorial(str.length() - 1)];
            for (int i = 0; i < str.length(); i++){
                String s = str.substring(i, i + 1);
                String[] subPerm = perms(str.replaceFirst(s, ""));
                perm[i] = insert(s,subPerm);
            }
            return join(perm);
        }
    }

    // Menambahkan string str di depan semua elemen dari arr
    public static String[] insert(String str, String[] arr){
        String[] inserted = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            inserted[i] = str + arr[i];
        return inserted;
    }

    // Menggabungkan semua elemen dari array of string array menjadi satu array
    public static String[] join(String[][] arr){
        String[] joined = new String[arr.length * arr[0].length];
        int i = 0;
        for (String[] subArr: arr){
            for(String str: subArr){
                joined[i] = str;
                i++;
            }
        }
        return joined;
    }

    // Mencetak semua elemen dari sebuah array
    public static void printArray(String[] arr){
        for (String str: arr)
            System.out.println(str);
        System.out.println();
    }

    // Menghitung faktorial
    public static int factorial(int n){
        if (n == 0 || n == 1)
            return 1;
        else 
            return n * factorial(n - 1);
    }
}