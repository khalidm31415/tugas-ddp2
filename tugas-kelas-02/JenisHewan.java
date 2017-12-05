class Herbivora extends Hewan {
    public Herbivora(String nama, int ukuran, int jumlahKaki) {
        super(nama, ukuran, jumlahKaki);
    }

    public void makan(Tumbuhan tumbuhan) {
        System.out.printf("Makan %s! Hmm enak!%n", tumbuhan.getNama());
    }
}

class Karnivora extends Hewan {
    public Karnivora(String nama, int ukuran, int jumlahKaki) {
        super(nama, ukuran, jumlahKaki);
    }

    public void makan(Hewan hewan) {
        System.out.printf("Makan %s! Hmm enak!%n", hewan.getNama());
    }
}