public class RichPigeon {
    public static void main(String[] args){
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " " +
                new Pengeja(){
                    @Override
                    public String eja(Integer angka){
                        switch (angka){
                            case 0: return "nol";
                            case 1: return "satu";
                            case 2: return "dua";
                            case 3: return "tiga";
                            case 4: return "empat";
                            case 5: return "lima";
                            case 6: return "enam";
                            case 7: return "tujuh";
                            case 8: return "delapan";
                            case 9: return "sembilan";
                            case 10: return "sepuluh";
                            case 11: return "sebelas";
                            case 100: return "seratus";
                            case 1000: return "seribu";
                        }

                        if (angka < 20){
                            return eja(angka % 10) + " belas";
                        }

                        else if (angka % 10 == 0 && angka < 100){
                            return eja(angka / 10) + " puluh";
                        }

                        else if (angka % 100 == 0 && angka < 1000){
                            return eja(angka / 100) + " ratus";
                        }

                        else if (angka % 1000 == 0 && angka < 10000){
                            return eja(angka / 1000) + " ribu";
                        }

                        else if (angka > 20 && angka < 100){
                            return eja(angka - (angka % 10)) + " " + eja(angka % 10);
                        }

                        else if (angka > 100 && angka < 1000) {
                            return eja(angka - (angka % 100)) + " " + eja(angka % 100);
                        }

                        else if (angka > 1000 && angka < 10000) {
                            return eja(angka - (angka % 1000)) + " " + eja(angka % 1000);
                        }

                        else {
                            return "gatau";
                        }
                        
                    }
                }.eja(i)
            );
        }            
    }
}