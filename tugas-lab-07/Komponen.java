class CPU {
    String brand; String jenis; String clock;

    public CPU(String brand, String jenis, String clock){
        this.brand = brand;
        this.jenis = jenis;
        this.clock = clock;
    }

    public String toString(){
        return brand + " " + jenis + " " + clock + " GHz";
    }
}

class Memory {
    String jenis; int kapasitas;

    public Memory(String jenis, int kapasitas){
        this.jenis = jenis;
        this.kapasitas = kapasitas;
    }

    public String toString(){
        return jenis + " " + kapasitas + " GB";
    }
}

class HardDisk {
    String tipe; int kapasitas;

    public HardDisk(String tipe, int kapasitas){
        this.tipe = tipe;
        this.kapasitas = kapasitas;
    }

    public String toString () {
        return tipe + " " + kapasitas + " GB";
    }
}

class OS {
    String name, version;

    public OS(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String toString(){
        return name + " " + version;
    }
}