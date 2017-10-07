public class IceCream {
    private Integer red;
    private Integer green;
    private Integer blue;

    public IceCream(Integer red, Integer green, Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static IceCream merah = new IceCream(255, 0, 0);
    public static IceCream hijau = new IceCream(0, 255, 0);
    public static IceCream biru = new IceCream(0, 0, 255);

    public static IceCream gabung(IceCream satu, IceCream dua, double pos){
        IceCream tiga = IceCream.tebak(satu, dua, pos);
        
        int m = (satu.red + dua.red + tiga.red)/3 ;
        int h = (satu.green + dua.green + tiga.green)/3 ;
        int b = (satu.blue + dua.blue + tiga.blue)/3 ;
        IceCream gabungan = new IceCream(m, h, b);
        String rasa = "entah";
        
        if (gabungan.red == gabungan.blue || gabungan.red == gabungan.green || gabungan.blue == gabungan.green) {
            rasa = "Rendang Goreng";
        }
        else if ((gabungan.red > gabungan.green) && (gabungan.red > gabungan.blue)) {
            rasa = "Strawberry";
        }
        else if ((gabungan.green > gabungan.red) && (gabungan.green > gabungan.blue)) {
            rasa = "Melon";
        }
        else if ((gabungan.blue > gabungan.red) && (gabungan.blue > gabungan.green)) {
            rasa = "Blueberry";
        }

        String pos = String.format("RGB(%d, %d, %d)", gabungan.red, gabungan.green, gabungan.blue);
        System.out.println(String.format("Ice Cream baru dengan warna %s dengan rasa %s, enak sekali!", pos, rasa));
        return gabungan;
    }

    public static IceCream tebak(IceCream A, IceCream B, double pos){
        double md = Math.min(A.red, B.red) + pos * Math.abs(A.red - B.red);
        double hd = Math.min(A.green, B.green) + pos * Math.abs(A.green - B.green);
        double bd = Math.min(A.blue, B.blue) + pos * Math.abs(A.blue - B.blue);

        int m = (int) Math.floor(md);
        int h = (int) Math.floor(hd);
        int b = (int) Math.floor(bd);

        IceCream tebakan = new IceCream(m, h, b);
        System.out.println(String.format("RGB(%d, %d, %d)", tebakan.red, tebakan.green, tebakan.blue));
        return tebakan;
    }

    public static void main(String[] args) {
        IceCream merahBaru = IceCream.merah;
        IceCream hijauBaru = IceCream.hijau;
        IceCream biruBaru = IceCream.biru;
        System.out.println(merahBaru.red);
        System.out.println(hijauBaru.green);
        System.out.println(biruBaru.red);
        IceCream.gabung(merahBaru, hijauBaru, biruBaru);
        IceCream.tebak(merahBaru, hijauBaru, 0.5);
    }
   }