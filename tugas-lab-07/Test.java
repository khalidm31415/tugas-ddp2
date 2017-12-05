import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Test{
    public static void main(String[] args){
        List<Barang> daftarBarang = new ArrayList<Barang>();
        Aksesoris acc1 = new Aksesoris(3, "Asus Zenpower", 2, "Powerbank 99.000 MAh");
        Aksesoris acc2 = new Aksesoris(3, "Asus Zenpower", 2, "Powerbank 99.000 MAh");
        daftarBarang.add(acc1);
        daftarBarang.add(acc2);
        System.out.println(daftarBarang);
        System.out.println(Collections.frequency(daftarBarang, new Aksesoris(3, "Asus Zenpower", 2, "Powerbank 99.000 MAh")));
        Set<Barang> daftarBarangSet = new HashSet<Barang>(daftarBarang);
        System.out.println(daftarBarangSet);
        System.out.println(Collections.frequency(daftarBarangSet, new Aksesoris(3, "Asus Zenpower", 2, "Powerbank 99.000 MAh")));
    }
}