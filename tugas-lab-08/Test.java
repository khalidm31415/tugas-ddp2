import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {
        AreaKosKosan sendowo = new AreaKosKosan();
        // MODIFIKASI DARI SINI
        // Pada area ini, silakan buat minimal 3 Kosan baru untuk area sendowo
        // Contoh Pseudocode : Kosan baru = new Kosan();

        AreaKosKosan.Kosan kosan1 = new AreaKosKosan.Kosan();
        AreaKosKosan.Kosan kosan2 = new AreaKosKosan.Kosan();
        AreaKosKosan.Kosan kosan3 = new AreaKosKosan.Kosan();

        ArrayList<AreaKosKosan.Kosan> daftarKosan = new ArrayList<AreaKosKosan.Kosan>();
        daftarKosan.add(kosan1); daftarKosan.add(kosan2); daftarKosan.add(kosan3);

        sendowo.setDaftarKosan(daftarKosan);

        // BATAS AKHIR MODIFIKASI


        // MODIFIKASI DARI SINI
        // Pada area ini, silakan buat minimal 3 kamar baru untuk minimal satu kosan yang telah kalian buat diatas
        // Contoh Pseudocode : Kamar baru = new Kamar(3, 4, 5000000);

        AreaKosKosan.Kosan.Kamar kamar1 = new AreaKosKosan.Kosan.Kamar(3, 4, 500000);
        AreaKosKosan.Kosan.Kamar kamar2 = new AreaKosKosan.Kosan.Kamar(4, 4, 600000);
        AreaKosKosan.Kosan.Kamar kamar3 = new AreaKosKosan.Kosan.Kamar(4, 5, 700000);
        AreaKosKosan.Kosan.Kamar kamar4 = new AreaKosKosan.Kosan.Kamar(2, 8, 550000);
        AreaKosKosan.Kosan.Kamar kamar5 = new AreaKosKosan.Kosan.Kamar(6, 3, 650000);

        ArrayList<AreaKosKosan.Kosan.Kamar> daftarKamar1 = new ArrayList<AreaKosKosan.Kosan.Kamar>();
        daftarKamar1.add(kamar1); daftarKamar1.add(kamar2); daftarKamar1.add(kamar3);
        kosan1.setDaftarKamar(daftarKamar1);

        ArrayList<AreaKosKosan.Kosan.Kamar> daftarKamar2 = new ArrayList<AreaKosKosan.Kosan.Kamar>();
        daftarKamar2.add(kamar4);
        kosan2.setDaftarKamar(daftarKamar2);

        ArrayList<AreaKosKosan.Kosan.Kamar> daftarKamar3 = new ArrayList<AreaKosKosan.Kosan.Kamar>();
        daftarKamar3.add(kamar5);
        kosan3.setDaftarKamar(daftarKamar3);

        System.out.println("Jumlah kosan di sendowo: " + AreaKosKosan.AplikasiPencariKos.getJumlahKosan(sendowo));
        System.out.println("Jumlah kamar di kosan1: " + AreaKosKosan.AplikasiPencariKos.getJumlahKamar(kosan1));

        for (AreaKosKosan.Kosan.Kamar kamar: kosan1.getDaftarKamar()){
            System.out.println(kamar);
        }
        System.out.println(kamar4);
        System.out.println(kamar5);

        System.out.println("Kamar terluas: ");
        System.out.println(AreaKosKosan.AplikasiPencariKos.getKamarTerluas(sendowo));
        System.out.println("Kamar termurah: ");
        System.out.println(AreaKosKosan.AplikasiPencariKos.getKamarTermurah(sendowo));
        // BATAS AKHIR MODIFIKASI
    }
}