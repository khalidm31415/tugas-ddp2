public class Player{
    private String name;
    private int lifePoints;
    private int score;

    public Player(String name){
        // Inisialisasi nama, life points, dan score
        this.name = name;
        this.lifePoints = 40;
        this.score = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public int getLifePoints(){
        return this.lifePoints;
    }

    // Penambahan score dan life points jika tebakan benar
    // sesuai soal
    public void tebakBenar(){
        this.lifePoints += 5;
        this.score += 10;
    }

    // Pengurangan life points dan score jika tebakan salah
    // sesuai dengan soal
    public void tebakSalah(){
        this.lifePoints -= 5;
        this.score -= 5;
    }
}