import java.lang.IllegalArgumentException;
import java.util.ArrayList;

class OrangTua extends Manusia {
    private String pekerjaan;
    private ArrayList<Anak> anak;

    public OrangTua(String nama, String tempatLahir, int usia, int tinggiBadan, int beratBadan, String pekerjaan, ArrayList<Anak> anak) {
        super(nama, tempatLahir, usia, tinggiBadan, beratBadan);
        this.pekerjaan = pekerjaan;
        this.anak = anak;
        if (usia < 25) throw new IllegalArgumentException("Usia orang tua tidak boleh kurang dari 25");
    }

    @Override
    public String toString() {
        if (this.getAnak().isEmpty()) {
            return String.format("%s adalah seorang %s yang berusia %d tahun, ia lahir di %s. Saat ini, ia belum mempunyai seorang anak.", this.getNama(), this.getPekerjaan(), this.getUsia(), this.getTempatLahir());
        }
        else {
            return String.format("%s adalah seorang %s yang berusia %d, ia lahir di %s. Saat ini, ia mempunyai %d orang anak.", this.getNama(), this.getPekerjaan(), this.getUsia(), this.getTempatLahir(), this.getAnak().size());
        }
    }

    public String getPekerjaan() {
        return this.pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public ArrayList<Anak> getAnak() {
        return this.anak;
    }

    public void setAnak(ArrayList<Anak> anak) {
        this.anak = anak;
    }
}

class Anak extends Manusia {
    private String derajatSekolah;

    public Anak(String nama, String tempatLahir, int usia, int tinggiBadan, int beratBadan, String derajatSekolah) {
        super(nama, tempatLahir, usia, tinggiBadan, beratBadan);
        this.derajatSekolah = derajatSekolah;
        if (usia > 25) throw new IllegalArgumentException("Usia anak tidak boleh lebih dari 25");
    }

    public String getDerajatSekolah() {
        return this.derajatSekolah;
    }

    public void setDerajatSekolah(String derajatSekolah) {
        this.derajatSekolah = derajatSekolah;
    }
}