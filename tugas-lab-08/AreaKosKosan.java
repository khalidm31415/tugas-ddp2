import java.util.List;
import java.util.Collections;

public class AreaKosKosan {
    private List<Kosan> daftarKosan;

    public AreaKosKosan(){
    }

    public void setDaftarKosan(List<Kosan> daftarKosan){
        this.daftarKosan = daftarKosan;
    }

    public List<Kosan> getDaftarKosan(){
        return this.daftarKosan;
    }

    static class Kosan {
        private List<Kamar> daftarKamar;

        public Kosan(){
        }

        public void setDaftarKamar(List<Kamar> daftarKamar){
            this.daftarKamar = daftarKamar;
        }

        public List<Kamar> getDaftarKamar(){
            return this.daftarKamar;
        }

        static class Kamar {
            private int panjangRuangan, lebarRuangan, hargaPerBulan;

            public Kamar(int panjangRuangan, int lebarRuangan, int hargaPerBulan){
                this.panjangRuangan = panjangRuangan;
                this.lebarRuangan = lebarRuangan;
                this.hargaPerBulan = hargaPerBulan;
            }

            public String toString(){
                return String.format("Ruangan ini berukuran %d x %d meter persegi, harga %d per bulan", panjangRuangan, lebarRuangan, hargaPerBulan);
            }

            public int getPanjangRuangan(){
                return this.panjangRuangan;
            }

            public int getLebarRuangan(){
                return this.lebarRuangan;
            }

            public int getHargaPerBulan(){
                return this.hargaPerBulan;
            }
        }
    }

    static class AplikasiPencariKos {
        public static int getJumlahKosan(AreaKosKosan areaKosKosan){
            return areaKosKosan.daftarKosan.size();
        }

        public static int getJumlahKamar(Kosan kosan){
            return kosan.daftarKamar.size();
        }

        public static int getPanjangKamar(AreaKosKosan.Kosan.Kamar kamar){
            return kamar.getPanjangRuangan();
        }

        public static int getLebarKamar(AreaKosKosan.Kosan.Kamar kamar){
            return kamar.getLebarRuangan();
        }

        public static int getLuasKamar(AreaKosKosan.Kosan.Kamar kamar){
            return kamar.getPanjangRuangan() * kamar.getLebarRuangan();
        }

        public static int getHargaPerBulan(AreaKosKosan.Kosan.Kamar kamar){
            return kamar.getHargaPerBulan();
        }

        public static int getTotalKamar(AreaKosKosan areaKosKosan){
            int total = 0;
            for (Kosan kosan: areaKosKosan.daftarKosan){
                total += kosan.daftarKamar.size();
            }
            return total;
        }

        public static AreaKosKosan.Kosan.Kamar getKamarTerluas(AreaKosKosan areaKosKosan){
            AreaKosKosan.Kosan.Kamar kamarTerluas = new AreaKosKosan.Kosan.Kamar(0, 0, 0);
            for (Kosan kosan: areaKosKosan.daftarKosan){
                for (AreaKosKosan.Kosan.Kamar kamar: kosan.daftarKamar){
                    if (AplikasiPencariKos.getLuasKamar(kamar) > (AplikasiPencariKos.getLuasKamar(kamarTerluas))){
                        kamarTerluas = kamar;
                    }
                }
            }
            return kamarTerluas;
        }

        public static AreaKosKosan.Kosan.Kamar getKamarTermurah(AreaKosKosan areaKosKosan){
            AreaKosKosan.Kosan.Kamar kamarTermurah = areaKosKosan.getDaftarKosan().get(0).getDaftarKamar().get(0);
            for (Kosan kosan: areaKosKosan.daftarKosan){
                for (AreaKosKosan.Kosan.Kamar kamar: kosan.daftarKamar){
                    if (AplikasiPencariKos.getHargaPerBulan(kamar) < (AplikasiPencariKos.getHargaPerBulan(kamarTermurah))){
                        kamarTermurah = kamar;
                    }
                }
            }
            return kamarTermurah;
        }
    }
}