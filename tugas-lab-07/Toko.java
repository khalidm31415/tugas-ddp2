import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashMap;

public class Toko {
    private Scanner reader;
    private String nama;
    private Gudang gudang;
    private boolean running;

    public Toko(String nama, Gudang gudang) {
        reader = new Scanner(System.in);
        this.nama = nama;
        this.gudang = gudang;
        running = false;
    }

    public void buka() {
        ArrayList<Barang> keranjangBelanja = new ArrayList<Barang>();
        running = true;

        while(running) {
            printMenu();
            int pilihan = 0;
            try{
                pilihan = Integer.parseInt(reader.nextLine());
            }
            catch (Exception e){
                running = false;
                continue;
            }

            switch(pilihan) {
                case 1: // Cetak daftar barang
                    cetakDaftarBarang();
                    break;
                case 2: // Beli barang
                    cetakDaftarBarang();

                    System.out.print("Pilih nomor barang yang ingin dibeli: ");
                    int nomorBarangBeli = Integer.parseInt(reader.nextLine());
                    Barang yangMauDiBeli = beliBarang(nomorBarangBeli, keranjangBelanja);
                    
                    System.out.printf("\n%s berhasil ditambahkan ke dalam keranjang belanja!\n\n",yangMauDiBeli);
                    break;
                case 3: // Hapus barang dari keranjang belanja
                    if (keranjangBelanja.isEmpty()) {
                        System.out.println("\nKeranjang belanja anda kosong!\n");
                        break;
                    }
                    cetakKeranjangBelanja(keranjangBelanja);
                    
                    System.out.print("Hapus barang: ");
                    int nomorBarangHapus = Integer.parseInt(reader.nextLine());
                    Barang yangMauDiHapus = hapusBarang(nomorBarangHapus, keranjangBelanja);
                    System.out.printf("\n%s berhasil dihapus dari keranjang belanja\n\n", yangMauDiHapus);
                    break;
                case 4: // Cetak kwitansi
                    cetakKwitansi(keranjangBelanja);
                    break;
                case 5: // Keluar
                default:
                    running = false;
                    break;
            }
        }
    }

    private void cetakDaftarBarang() {
        System.out.println("\nDaftar Barang");
        for (int i = 0; i < this.gudang.daftarBarang.size(); i++){
            System.out.printf("(%d) %s - %d\n", i + 1, this.gudang.daftarBarang.get(i), this.gudang.daftarBarang.get(i).hargaBarang);
        }
        System.out.println();
    }

    private void cetakKeranjangBelanja(List<Barang> keranjangBelanja) {
        System.out.printf("\nKeranjang Belanja %s\n\n", nama);
        int i = 1;
        for (Barang barang: keranjangBelanja){
            System.out.printf("(%d) %s %d\n", i, barang, barang.hargaBarang);
            i++;
        }
        System.out.println();
        
    }

    private Barang beliBarang(int nomorBarang, List<Barang> keranjangBelanja) {
        Barang yangMauDiBeli = this.gudang.daftarBarang.get(nomorBarang - 1).clone();
        yangMauDiBeli.diskonHarga();
        keranjangBelanja.add(yangMauDiBeli);
        return yangMauDiBeli;
    }

    private Barang hapusBarang(int nomorBarang, List<Barang> keranjangBelanja) {
        Barang yangMauDiHapus = keranjangBelanja.remove(nomorBarang - 1);
        return yangMauDiHapus;
    }

    private void cetakKwitansi(List<Barang> keranjangBelanja) {
        if (keranjangBelanja.isEmpty()){
            System.out.println("\nKeranjang belanja anda kosong!\n");
        }
        else{
            System.out.printf("\nKwitansi Toko %s\n\n", nama);           

            ArrayList<Barang> keranjangBelanjaUnik = new ArrayList<Barang>();
            for (Barang barang: keranjangBelanja){
                if (keranjangBelanjaUnik.contains(barang)){
                    continue;
                }
                else {
                    keranjangBelanjaUnik.add(barang);
                }
            }

            
            for (Barang barang: keranjangBelanjaUnik){
                System.out.printf("(%d) %s %d\n", Collections.frequency(keranjangBelanja, barang), barang, barang.hargaBarang);
            }
            
            System.out.println();

            int totalBiaya = 0;
            for (Barang barang: keranjangBelanja){
                totalBiaya += barang.hargaBarang;
            }

            System.out.printf("Total biaya: %d\n\n", totalBiaya);
        }
    }

    private void printMenu() {
        System.out.println("Toko " + nama);
        System.out.println("Menu");
        System.out.println("(1) Cetak daftar barang");
        System.out.println("(2) Beli barang");
        System.out.println("(3) Hapus barang dari keranjang belanja");
        System.out.println("(4) Cetak kwitansi");
        System.out.println("(5) Keluar");
        System.out.print("Pilihan Anda: ");
    }
    
    /**
     * Main method untuk menjalankan program.
     *
     * @param args
     */

    public static void main(String[] args) {
        Aksesoris powerbank = new Aksesoris(3, "Asus Zenpower", 235000, "Powerbank 99.000 MAh");

        // Persiapkan barang-barang yang akan dijual
        List<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(powerbank);

        Gudang.masukin("daftarBarang.txt", daftarBarang);

        Gudang gudang = new Gudang(daftarBarang);
        // Buka toko
        Toko toko = new Toko("Kom.com", gudang);
        toko.buka();
    }
}