public class Account {
    private double balance;
    private double fee = 0.15; // besar fee adalah 15% dari besar transaksi

    public Account()
    {
        this.balance = 0;
    }
    public Account (double newBalance)
    {
        this.balance = newBalance;
    }
    public void deposit (double money)
    {
        this.balance += (money - fee * money);
        System.out.println("Anda menyimpan uang sebesar " + money);
        System.out.println("besar biaya transaksi: " + (fee * money));
        System.out.println("Saldo Anda sekarang adalah: " + this.balance + "\n");
    }
    public void withdraw (double money)
    {
        // Jika besar uang yang akan diambil bernilai negatif
        if (money < 0)
        {
            System.out.println("Besar uang yang ingin anda tarik bernilai negatif: " + money);
            System.out.println("Penarikan tidak bisa dilakukan. Sisa saldo anda: " + this.balance + "\n");
        }
        // Jika uang yang ingin diambil lebih besar dari saldo
        else if (this.balance - money - (fee * money) < 0)
        {
            System.out.println("Anda akan menarik uang sebesar " + money);
            System.out.println("Sisa saldo Anda tidak cukup untuk melakukan transaksi ini");
            System.out.println("Sisa saldo anda adalah: " + this.balance + "\n");
        }
        else
        {
            this.balance -= (money + fee * money);
            System.out.println("Anda menarik uang sebesar " + money);
            System.out.println("besar biaya transaksi: " + (fee * money));
            System.out.println("Saldo Anda sekarang adalah: " + this.balance + "\n");
        }
    }
    public void setBalance(double newBalance)
    {
        this.balance = newBalance;
    }
    public double getBalance()
    {
        return this.balance;
    }
}