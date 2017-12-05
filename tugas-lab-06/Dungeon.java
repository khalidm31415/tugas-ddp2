import java.util.Scanner;
import java.util.ArrayList;

public class Dungeon{
    public static void main(String[] args){
        play();
    }

    public static char[][][] bacaInput(){
        char[][][] dungeonArrays;

        System.out.println("Masukkan banyaknya peta: ");
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        dungeonArrays = new char[T][][];

        for(int i = 0; i < T; i++){
            System.out.println("Masukkan ukuran peta: ");
            Scanner ukuran = new Scanner(System.in);
            int N = ukuran.nextInt(); int M = ukuran.nextInt();

            dungeonArrays[i] = new char[N][M];

            System.out.println("Masukkan peta: ");
            for (int j = 0; j < N; j++){
                Scanner dungeon = new Scanner(System.in);
                dungeonArrays[i][j] = dungeon.nextLine().toCharArray();
            }
        }
        return dungeonArrays;
    }

    public static int[] indexS(char[][] dungeonArray){
        for(int i = 0; i < dungeonArray.length; i++){
            for(int j = 0; j < dungeonArray[i].length; j++){
                if (dungeonArray[i][j] == 'S'){
                    int[] ind = {i, j};
                    return ind;
                }
            }
        }
        int[] ind = {-1, -1};
        return ind;
    }

    public static int[][] indexJejak(char[][] dungeonArray){
        ArrayList<int[]> indices = new ArrayList<int[]>();
        for(int i = 0; i < dungeonArray.length; i++){
            for(int j = 0; j < dungeonArray[i].length; j++){
                if (dungeonArray[i][j] == '*' || dungeonArray[i][j] == 'S'){
                    int[] ind = {i, j};
                    indices.add(ind);
                }
            }
        }
        int[][] indicesArray = indices.toArray(new int[indices.size()][]);
        return indicesArray;
    }

    public static boolean cariJalanKeluar(char[][] dungeonArray){
        int[][] marks = indexJejak(dungeonArray);

        // Base case ada jalan keluar
        for (int[] mark: marks){
            int x = mark[0]; int y = mark[1];

            int atasX = x; int atasY = y +1;
            int bawahX = x; int bawahY = y - 1;
            int kiriX = x - 1; int kiriY = y;
            int kananX = x + 1; int kananY = y;

            try{
                char atas = dungeonArray[atasX][atasY];
                if (atas == 'X') return true;
            }
            catch (Exception e){}

            try{
                char bawah = dungeonArray[bawahX][bawahY];
                if (bawah == 'X') return true;
            }
            catch (Exception e){}

            try{
                char kiri = dungeonArray[kiriX][kiriY];
                if (kiri == 'X') return true;
            }
            catch (Exception e){}

            try{
                char kanan = dungeonArray[kananX][kananY];
                if (kanan == 'X') return true;
            }
            catch (Exception e){}

        }

        // Base case gak ada jalan keluar
        int counter = 0;
        for (int[] mark: marks){
            int x = mark[0]; int y = mark[1];

            int atasX = x; int atasY = y +1;
            int bawahX = x; int bawahY = y - 1;
            int kiriX = x - 1; int kiriY = y;
            int kananX = x + 1; int kananY = y;

            try{
                char atas = dungeonArray[atasX][atasY];
                if (atas == '.') break;
            }
            catch (Exception e){}

            try{
                char bawah = dungeonArray[bawahX][bawahY];
                if (bawah == '.') break;
            }
            catch (Exception e){}

            try{
                char kiri = dungeonArray[kiriX][kiriY];
                if (kiri == '.') break;
            }
            catch (Exception e){}

            try{
                char kanan = dungeonArray[kananX][kananY];
                if (kanan == '.')  break;
            }
            catch (Exception e){}

            counter++;
        }
        if (counter == marks.length) return false;

        // Recursive case
        for (int[] mark: marks){
            int x = mark[0]; int y = mark[1];

            int atasX = x; int atasY = y +1;
            int bawahX = x; int bawahY = y - 1;
            int kiriX = x - 1; int kiriY = y;
            int kananX = x + 1; int kananY = y;

            try{
                char atas = dungeonArray[atasX][atasY];
                if (atas == '.') dungeonArray[atasX][atasY] = '*';
            }
            catch (Exception e){}

            try{
                char bawah = dungeonArray[bawahX][bawahY];
                if (bawah == '.') dungeonArray[bawahX][bawahY] = '*';
            }
            catch (Exception e){}

            try{
                char kiri = dungeonArray[kiriX][kiriY];
                if (kiri == '.') dungeonArray[kiriX][kiriY] = '*';
            }
            catch (Exception e){}

            try{
                char kanan = dungeonArray[kananX][kananY];
                if (kanan == '.')  dungeonArray[kananX][kananY] = '*';
            }
            catch (Exception e){}
        }
        return cariJalanKeluar(dungeonArray);
    }

    public static int hitungA(char[][] dungeonArray){
        int[][] marks = indexJejak(dungeonArray);

        // Base case gak ada artifacts
        int counter = 0;
        for (int[] mark: marks){
            int x = mark[0]; int y = mark[1];

            int atasX = x; int atasY = y +1;
            int bawahX = x; int bawahY = y - 1;
            int kiriX = x - 1; int kiriY = y;
            int kananX = x + 1; int kananY = y;

            try{
                char atas = dungeonArray[atasX][atasY];
                if (atas == '.' || atas == 'A') break;
            }
            catch (Exception e){}

            try{
                char bawah = dungeonArray[bawahX][bawahY];
                if (bawah == '.' || bawah == 'A') break;
            }
            catch (Exception e){}

            try{
                char kiri = dungeonArray[kiriX][kiriY];
                if (kiri == '.' || kiri == 'A') break;
            }
            catch (Exception e){}

            try{
                char kanan = dungeonArray[kananX][kananY];
                if (kanan == '.' || kanan == 'A')  break;
            }
            catch (Exception e){}

            counter++;
        }
        if (counter == marks.length) return 0;


        // Recursive case
        int jumlahAsekitar = 0;
        for (int[] mark: marks){
            int x = mark[0]; int y = mark[1];

            int atasX = x; int atasY = y +1;
            int bawahX = x; int bawahY = y - 1;
            int kiriX = x - 1; int kiriY = y;
            int kananX = x + 1; int kananY = y;

            try{
                char atas = dungeonArray[atasX][atasY];
                if (atas == '.') dungeonArray[atasX][atasY] = '*';
                else if (atas == 'A'){
                    jumlahAsekitar++;
                    dungeonArray[atasX][atasY] = '*';
                }
            }
            catch (Exception e){}

            try{
                char bawah = dungeonArray[bawahX][bawahY];
                if (bawah == '.') dungeonArray[bawahX][bawahY] = '*';
                else if (bawah == 'A'){
                    jumlahAsekitar++;
                    dungeonArray[bawahX][bawahY] = '*';
                }
            }
            catch (Exception e){}

            try{
                char kiri = dungeonArray[kiriX][kiriY];
                if (kiri == '.') dungeonArray[kiriX][kiriY] = '*';
                else if (kiri == 'A'){
                    jumlahAsekitar++;
                    dungeonArray[kiriX][kiriY] = '*';
                }
            }
            catch (Exception e){}

            try{
                char kanan = dungeonArray[kananX][kananY];
                if (kanan == '.')  dungeonArray[kananX][kananY] = '*';
                else if (kanan == 'A'){
                    jumlahAsekitar++;
                    dungeonArray[kananX][kananY] = '*';
                }
            }
            catch (Exception e){}
        }
        return jumlahAsekitar + hitungA(dungeonArray);
    }

    public static void play(){
        char[][][] dungeons = bacaInput();
        int[] jumlahArtifacts = new int[dungeons.length];
        boolean[] bisaKeluarAtauNggak = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++){
            jumlahArtifacts[i] = hitungA(dungeons[i]);
            bisaKeluarAtauNggak[i] = cariJalanKeluar(dungeons[i]);
        }

        for (int i = 0; i < dungeons.length; i++){
            System.out.printf("Peta Dungeon %d#\n", i + 1);
            System.out.println(jumlahArtifacts[i]);
            String stringBisaKeluarAtauNggak = (bisaKeluarAtauNggak[i]) ? "Bisa keluar":"Tidak bisa keluar";
            System.out.println(stringBisaKeluarAtauNggak);
        }

        int counter = 0;
        for (int i = 0; i < dungeons.length; i++){
            if (! bisaKeluarAtauNggak[i]){
                jumlahArtifacts[i] = -1;
                counter++;
            }
        }
        if (counter == dungeons.length) {
            System.out.println("“Flame Princess dan Finn tidak jadi pergi ke dungeon dan pada akhirnya bermain episode Burning Low");
        }
        else{
            int maxArtifacts = 0;
            int maxIndex = 0;
            for (int i = 0; i < dungeons.length; i++){
                if (jumlahArtifacts[i] > maxArtifacts){
                    maxArtifacts = jumlahArtifacts[i];
                    maxIndex = i;
                }
            }
            System.out.printf("Dungeon yang dipilih adalah dungeon nomor %d", maxIndex + 1);
        }
    }
}