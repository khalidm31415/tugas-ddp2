import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/**
* Created by reals on 9/15/2017.
*/
public class Kalender {
    int dayOfMonth;
    int Month;
    int Year;

    public Kalender()
    {
        Calendar cal = Calendar.getInstance();
        this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        this.Month = cal.get(Calendar.MONTH);
        this.Year = cal.get(Calendar.YEAR);
    }
    public Kalender(int hari, int bulan, int tahun)
    {
        this.dayOfMonth = hari;
        this.Month = bulan;
        this.Year = tahun;
    }
    // method untuk menambah hari sebanyak hari_tambah pada instance
    public void tambah_hari(int hari_tambah){
        Calendar cal = new GregorianCalendar(this.Year, this.Month, this.dayOfMonth);
        cal.add(Calendar.DAY_OF_MONTH, hari_tambah);
        this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        this.Month = cal.get(Calendar.MONTH);
        this.Year = cal.get(Calendar.YEAR);
    }
    // method untuk menambah tahun sebanyak hari_tahun pada instance
    public void tambah_tahun(int tahun_tambah){
        Calendar cal = new GregorianCalendar(this.Year, this.Month, this.dayOfMonth);
        cal.add(Calendar.YEAR, tahun_tambah);
        this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        this.Month = cal.get(Calendar.MONTH);
        this.Year = cal.get(Calendar.YEAR);
    }
    // method untuk melihat hari pada instance
    public String hari(){
        String[] hari = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        Calendar cal = new GregorianCalendar(this.Year, this.Month, this.dayOfMonth);
        int ke = cal.get(Calendar.DAY_OF_WEEK);
        return hari[ke - 1];
    }
    // method untuk melihat bulan pada instance
    public String bulan(){
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                        "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        Calendar cal = new GregorianCalendar(this.Year, this.Month, this.dayOfMonth);
        int ke = cal.get(Calendar.MONTH);
        return bulan[ke];
    }
    public String ultahDiTahun(int tahun){
        int tahun_tambah = tahun - this.Year;
        Kalender tambah = new Kalender(this.dayOfMonth, this.Month, this.Year);
        tambah.tambah_tahun(tahun_tambah);
        return tambah.hari();
    }
    public static void main(String[] args) {
        Kalender tudei = new Kalender();
        System.out.println("Hari ini: " + tudei.hari() + " " + tudei.dayOfMonth + " " + tudei.bulan() + " " + tudei.Year);
        tudei.tambah_hari(1);
        System.out.println("1 hari setelah hari ini: " + tudei.hari() + " " + tudei.dayOfMonth + " " + tudei.bulan() + " " + tudei.Year);
        tudei.tambah_hari(99);
        System.out.println("100 hari setelah hari ini: " + tudei.hari() + " " + tudei.dayOfMonth + " " + tudei.bulan() + " " + tudei.Year);
        tudei.tambah_hari(9900);
        System.out.println("10.000 hari setelah hari ini: " + tudei.hari() + " " + tudei.dayOfMonth + " " + tudei.bulan() + " " + tudei.Year);
        Kalender ultah = new Kalender(15, 10, 1996);
        System.out.println("Hari lahir: " + ultah.hari() + " " + ultah.dayOfMonth + " " + ultah.bulan() + " " + ultah.Year);
        System.out.println("Hari ultah di 2017: " + ultah.ultahDiTahun(2017));
    }
}