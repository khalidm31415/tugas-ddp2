public class Main {
    public static void main(String[] args) {
        Account agung = new Account();
        Account david = new Account(1000);
        System.out.println("Saldo agung " + agung.getBalance());
        System.out.println("Saldo david " + david.getBalance() + "\n");
        david.withdraw(200);
        david.withdraw(-10);
        david.withdraw(2000);
    }
}