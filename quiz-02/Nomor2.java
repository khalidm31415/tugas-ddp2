import java.io.*;
import java.util.*;

public class Nomor2 {
    public static void main(String[] args) {
        mainMethod();
    }

    public static void jumlahKata(String filedir) throws IOException {
        File file = new File(filedir);
        Scanner input = new Scanner(file);

        TreeMap<String, Integer> dict = new TreeMap<String, Integer>();

        while (input.hasNext()){
            String kata = input.next().toLowerCase();
            if (dict.containsKey(kata)) {
                dict.put(kata, dict.get(kata) + 1);
            }

            else {
                dict.put(kata, 1);
            }
        }
        input.close();

        File output = new File("output.txt");
        FileWriter outputWriter = new FileWriter(output);

        for(String kata: dict.keySet()) {
            String kataDanJumlah = String.format("%s\t%d", (kata.length() <= 3) ? kata + "   ":kata, dict.get(kata));
            System.out.println(kataDanJumlah);
            outputWriter.write(kataDanJumlah + "\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public static void mainMethod(){
        try{
            jumlahKata("input.txt");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}