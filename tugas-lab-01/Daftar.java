import java.util.Scanner;

public class Daftar {
    public static void main(String[] args) {
        System.out.print("input: ");
        Scanner input = new Scanner(System.in);
        input.next();
        String firstname = input.next();
        String lastname = input.next();
        System.out.println("Data customer berhasil dimasukkan");
        System.out.println("nama: " + firstname + " " + lastname);
        System.out.println("email: " + lastname.toLowerCase() + "." + firstname.toLowerCase() + "@bingbing.com");
    }
}