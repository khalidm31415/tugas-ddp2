public class Barang {
    protected int id;
    protected String name;
    protected int hargaBarang;

    public Barang(int id, String name, int hargaBarang){
        this.id = id;
        this.name = name;
        this.hargaBarang = hargaBarang;
    }

    public Barang clone(){
        Barang barangClone = new Barang(this.id, this.name, this.hargaBarang);
        return barangClone;
    }

    @Override
    public boolean equals(Object o){
        Barang barangLain = (Barang) o;
        if (this.name.equals(barangLain.name)){
            return true;
        }
        else{
            return false;
        }
    }

    public void diskonHarga(){
    }

    public static void main(String[] args){
        CPU cpu = new CPU("Intel", "Core i5", "2.7");
        Memory memory = new Memory("DDR3", 4);
        HardDisk hd = new HardDisk("HDD", 100);

        PerangkatKeras kompi = new PerangkatKeras(1, "Lenovo Thinkpad", 1000, cpu, memory, hd);
        System.out.println(kompi.cpu);
        System.out.println(kompi.memory);
        System.out.println(kompi.hd);

        OS marshmellow = new OS("Android", "5.1");
        PerangkatLunak wolframAlpha = new PerangkatLunak(2, "Wolfram Alpha", 15, marshmellow, "Books and Reference");
        System.out.println(wolframAlpha.os);
        System.out.println(wolframAlpha.jenis);

        Aksesoris acc = new Aksesoris(3, "Asus Zenpower", 2, "Powerbank 99.000 MAh");
        System.out.println(acc.deskripsi);
    }
}

class PerangkatKeras extends Barang {
    CPU cpu; Memory memory; HardDisk hd;

    public PerangkatKeras(int id, String name, int hargaBarang, CPU cpu, Memory memory, HardDisk hd){
        super(id, name, hargaBarang);
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
    }

    public PerangkatKeras clone(){
        PerangkatKeras perangkatKerasClone = new PerangkatKeras(this.id, this.name, this.hargaBarang, this.cpu, this.memory, this.hd);
        return perangkatKerasClone;
    }

    public String toString(){
        return this.name;
    }

    public void diskonHarga(){
        this.hargaBarang = (int) Math.floor((1 - 0.1) * this.hargaBarang);
    }
}

class PerangkatLunak extends Barang {
    OS os; String jenis;

    public PerangkatLunak(int id, String name, int hargaBarang, OS os, String jenis){
        super(id, name, hargaBarang);
        this.os = os;
        this.jenis = jenis;
    }

    public PerangkatLunak clone(){
        PerangkatLunak perangkatLunakClone = new PerangkatLunak(this.id, this.name, this.hargaBarang, this.os, this.jenis);
        return perangkatLunakClone;
    }

    public String toString(){
        return this.name;
    }

    public void diskonHarga(){
        this.hargaBarang = (int) Math.floor((1 - 0.15) * this.hargaBarang);
    }
}

class Aksesoris extends Barang {
    String deskripsi;

    public Aksesoris(int id, String name, int hargaBarang, String deskripsi){
        super(id, name, hargaBarang);
        this.deskripsi = deskripsi;
    }

    public Aksesoris clone(){
        Aksesoris accClone = new Aksesoris(this.id, this.name, this.hargaBarang, this.deskripsi);
        return accClone;
    }

    public String toString(){
        return this.name;
    }

    public void diskonHarga(){
        this.hargaBarang = (int) Math.floor((1 - 0.05) * this.hargaBarang);
    }
}