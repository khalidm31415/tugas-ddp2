public class MakhlukHidup {
    private String nama;

    public MakhlukHidup(String nama) {
        this.nama = nama;
    }

    public void bernafasOksigen() {
        System.out.println("Huu haa huu haa.. (lagi nafas)");
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

class Manusia extends MakhlukHidup {
    private String tempatLahir;
    private int usia;
    private int tinggiBadan;
    private int beratBadan;

    public Manusia(String nama, String tempatLahir, int usia, int tinggiBadan, int beratBadan) {
        super(nama);
        this.tempatLahir = tempatLahir;
        this.usia = usia;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public void bergerak() {
        System.out.println("Bergerak dengan kecepatan Sedang!");
    }

    public void makan(Hewan hewan) {
        System.out.printf("Makan %s bakar! Hmm enak!%n", hewan.getNama());
    }

    public void makan(Tumbuhan tumbuhan) {
        System.out.printf("Makan sup %s! Hmm enak!%n", tumbuhan.getNama());
    }

    public String getTempatLahir() {
        return this.tempatLahir;
    }

    public int getUsia() {
        return this.usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public int getTinggiBadan() {
        return this.tinggiBadan;
    }

    public void setTinggiBadan(int tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public int getBeratBadan() {
        return this.beratBadan;
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = beratBadan;
    }
}

class Tumbuhan extends MakhlukHidup {
    private int tinggi;
    private boolean memilikiBuah;

    public Tumbuhan(String nama, int tinggi, boolean memilikiBuah) {
        super(nama);
        this.tinggi = tinggi;
        this.memilikiBuah = memilikiBuah;
    }

    @Override
    public void bernafasOksigen() {
        System.out.println("Fotosintesis! Fotosintesis! (lagi nafas)");
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public boolean getMemilikiBuah() {
        return this.memilikiBuah;
    }

    public void setMemilikiBuah(boolean memilikiBuah) {
        this.memilikiBuah = memilikiBuah;
    }
}

class Hewan extends MakhlukHidup {
    private int ukuran;
    private int jumlahKaki;

    public Hewan(String nama, int ukuran, int jumlahKaki) {
        super(nama);
        this.ukuran = ukuran;
        this.jumlahKaki = jumlahKaki;
    }

    public void bergerak() {
        System.out.println("Bergerak dengan kecepatan Tinggi!");
    }

    public int getUkuran(){
        return this.ukuran;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public int getJumlahKaki() {
        return this.jumlahKaki;
    }

    public void setjumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }
}