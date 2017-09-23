
public class Kalkulator {
    public static void main(String[] args) {
        System.out.println(Kalkulator.hitung(12, "+", 3));
        System.out.println(Kalkulator.hitung(12, "-", 3));
        System.out.println(Kalkulator.hitung(12, "*", 3));
        System.out.println(Kalkulator.hitung(12, "/", 3));
        System.out.println(Kalkulator.hitung(12, "^", 3));
        System.out.println(Kalkulator.hitung(12, "Mod", 3));
        System.out.println(Kalkulator.hitung("log", 100));
        System.out.println(Kalkulator.hitung(36, "V", 2));
        double[] arr = {1,3};
        System.out.println(Kalkulator.hitung("~", arr));
    }

    public static String hitung(double a, String op, double b) {
        switch(op) {
            case "+":
                return a + b + "";

            case "-":
                return a - b + "";

            case "*":
                return a * b + "";

            case "/":
                return a / b + "";

            case "^":
                return Math.pow(a, b) + "";

            case "Mod":
                return a % b + "";

            case "V":
                return Math.pow(a, 1/b) + "";
        }
        return "Maaf, input tidak sesuai";
    }

    public static String hitung(String op, double x) {
        switch(op) {
            case "log":
                return "Logaritma basis 10, output adalah " + Math.log10(x);
        }
        return "Maaf, input tidak sesuai";
    }

    public static String hitung(String op, double[] arr){
        if (op.equals("~")) {
            int sum = 0;
            for (double i: arr) {
                sum += i;
            }
            return sum/arr.length + "";
        }
        return "Maaf, input tidak sesuai";
    }
}