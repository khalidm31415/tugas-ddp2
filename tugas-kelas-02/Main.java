import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Anak> anakNaruto = new ArrayList<Anak>();
        OrangTua naruto = new OrangTua("Naruto", "Konoha", 26, 170, 60, "Ninja", anakNaruto);
        Anak boruto = new Anak("boruto", "Konoha", 0, 170, 55, "Belum Sekolah");
        Hewan gurame = new Herbivora("Gurame", 5, 0);
        Karnivora singa = new Karnivora("Singa", 10, 4);
        Tumbuhan bayam = new Tumbuhan("Bayam", 10, false);
        Tumbuhan apel = new Tumbuhan("Apel", 40, true);
        Herbivora sapi = new Herbivora("Sapi", 20, 4);

        System.out.println(naruto);
        System.out.println("Suatu hari, ia pergi ke sebuah restoran untuk makan.");
        naruto.bergerak();
        System.out.println("Di perjalanannya, ia melihat sebuah pohon apel dan seekor singa dan seekor sapi di bawahnya");
        apel.bernafasOksigen();
        singa.bernafasOksigen();
        singa.makan(sapi);
        System.out.println("Sesampainya di restoran, ia memesan gurame dan bayam");
        naruto.makan(gurame);
        naruto.makan(bayam);
        System.out.println("Dua tahun kemudian, ia menikah, dan tahun berikutnya ia dikarunia seoarang anak");
        anakNaruto.add(boruto);
        naruto.setAnak(anakNaruto);
        naruto.setUsia(28);
        System.out.println(naruto);
        System.out.println("Tahun berikutnya, ia dikarunia lagi seorang anak");
        Anak himawari = new Anak("Himawari", "Konoha", 26, 50, 5, "Belum sekolah");
    }
}