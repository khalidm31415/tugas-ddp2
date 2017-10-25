import java.util.Scanner;

public class Tebak{

    // Metod untuk membaca input dengan format pada soal
    // "i,j k,l" -> {i,j,k,l}
    public static int[] bacaInput(String input){
        // Pertama kedua tanda koma diganti dengan spasi
        input = input.replaceAll(",", " ");

        // Lalu, dibuat array string yang berisi indeks-indeks tebakan
        // dengan split input string tadi dengan spasi
        String[] inputStringArr = input.split(" ");

        // Mengubah array string tadi menjadi array integer
        // Elemen pertama dan kedua adalah indeks untuk bilik A
        // Elemen ketiga dan keempat adalah indeks untuk bilik B
        int[] inputArr = new int[inputStringArr.length];
        for (int i = 0; i < inputArr.length; i++){
            inputArr[i] = Integer.parseInt(inputStringArr[i]) - 1;
        }
        return inputArr;
    }

    public static void play(){
        System.out.println("Selamat Datang di Permainan Tebak Bilik!");
        System.out.print("Siapa namamu? ");
        Scanner input1 = new Scanner(System.in);
        String name = input1.nextLine();

        boolean main = true;
        while (main){
            // Mau isi array ditampilkan?
            boolean dispAns;
            System.out.printf("Hai %s, untuk memeriksa apakah permainan ini berjalan dengan baik, apakah kamu ingin melihat isi array yang harus ditebak? (y/n) ", name);
            
            // Loop while dibuat untuk mengatasi kesalahan format input
            while (true){
                Scanner dispAnsInput = new Scanner(System.in);
                String dispAnsStr = dispAnsInput.next();
                if (dispAnsStr.equals("y")){
                    dispAns = true;
                    break;
                }
                else if (dispAnsStr.equals("n")){
                    dispAns = false;
                    break;
                }
                else {
                    System.out.print("Input tidak sesuai, ketik y/n: ");
                    continue;
                }
            }
            
            Player player1 = new Player(name);
            System.out.print("Masukkan ukuran bilik: ");
            Scanner input2 = new Scanner(System.in);
            int n = input2.nextInt();

            // Inisialisasi matrix yang dibutuhkan untuk bermain
            // dan variabel penghitung jumlah tebakan benar
            String[][] bilik = Bilik.bilik(n);
            int[][] tebakArr1 = Matrix.randomArray(n);
            int[][] tebakArr2 = Matrix.shuffleArray(tebakArr1);
            int correctCounter = 0;

            // Jumlah bilik yang harus ditebak adalah n x n
            // jika correctCounter sudah sama dengan n x n
            // artinya pemain sudah berhasil menebak semua bilik dengan benar
            while (player1.getLifePoints() > 0 && correctCounter < (n * n)){
                System.out.println("\nPemain : " + player1.getName());
                System.out.println("Life Points : " + player1.getLifePoints());

                if (dispAns){
                    Matrix.printArray(tebakArr1);
                    System.out.println();
                    Matrix.printArray(tebakArr2);
                    System.out.println();
                }
                Bilik.cetakBilik(bilik);
                
                int i, j, k, l;
                // try dan catch dibuat untuk mengatasi kesalahan format input
                try {
                    System.out.print("Tebak Bilik: ");
                    Scanner input3 = new Scanner(System.in);
                    String tebakanStr = input3.nextLine();
                    int[] tebakan = bacaInput(tebakanStr);
                    i = tebakan[0]; j = tebakan[1];
                    k = tebakan[2]; l = tebakan[3];
                }
                catch (Exception e){
                    System.out.println("Format input salah, formatnya adalah: i,j k,l\n");
                    continue;
                }

                // Mengatasi input indeks yang melebihi batas
                if(i >= n || j >= n || k >= n || l >= n){
                    System.out.println("\nIndeks di luar batas!!!");
                    System.out.printf("Ukuran matrix adalah %d x %d\n\n", n, n);
                    continue;
                }

                // Bilik yang sudah berhasil ditebak dengan benar tidak boleh ditebak lagi
                if ((! bilik[i][j].equals("*")) || (! bilik[k][l + (n + 1)].equals("*"))){
                    System.out.println("\nSalah satu bilik tersebut sudah ditebak dengan benar!!!");
                    System.out.println("Coba tebak bilik yang lain!!!\n");
                    continue;
                }

                // Jika tebakan benar
                if (tebakArr1[i][j] == tebakArr2[k][l]){
                    player1.tebakBenar();
                    correctCounter++;
                    bilik[i][j] = "" + tebakArr1[i][j];
                    bilik[k][l + (n + 1)] = "" + tebakArr2[k][l];
                    System.out.println("Benar!\n");
                }
                // Jika tebakan salah
                else{
                    player1.tebakSalah();
                    System.out.println("Salah!\n");
                }

                // Jika life points sudah habis
                if (player1.getLifePoints() <= 0){
                    System.out.println("\nSayang sekali, life points Kamu sudah habis!!!");
                    System.out.println("Game over\n");
                    break;
                }
                // Jika semua bilik sudah berhasil ditebak dengan benar
                else if (correctCounter == (n * n)){
                    System.out.printf("\nSelamat %s, Kamu berhasil menebak semua bilik dengan benar!!!\n", player1.getName());
                    System.out.println("Skor akhir : " + player1.getScore() + "\n");
                    break;
                }
            }

            System.out.print("Mau main lagi? (y/n) ");
            // Loop while dibuat untuk mengatasi kesalahan format input
            while (true){
                Scanner input4 = new Scanner(System.in);
                String yn = input4.next();
                
                // Kalo gak mau main lagi
                if (yn.equals("n")){
                    main = false;
                    System.out.printf("Terima kasih telah bermain %s!\n", player1.getName());
                    break;
                }
                // Kalo mau main lagi
                else if (yn.equals("y")){
                    System.out.println("Yey! Ayo main lagi!");
                    break;
                }
                else {
                    System.out.print("Input tidak sesuai, ketik y/n: ");
                    continue;
                }
            }  
        }
    }
}