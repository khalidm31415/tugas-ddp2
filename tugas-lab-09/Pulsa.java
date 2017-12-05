import java.util.Scanner;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;   

public class Pulsa {  
    public static void main (String[] args) {  
        try {  
            File f = new File("input.txt");
            Scanner in = new Scanner(f);
            String tanggal = in.nextLine();

            try {
                String[] tanggalArray = tanggal.split("/");
                int dd = Integer.parseInt(tanggalArray[0]);
                int mm = Integer.parseInt(tanggalArray[1]);
                int yyyy = Integer.parseInt(tanggalArray[2]);

                if (dd > 31 || mm > 12 || yyyy > 9999){
                    throw new NumberFormatException("Terdapat kesalahan penulisan tanggal");
                }
            }
            catch (NumberFormatException nfe) {
                throw new NumberFormatException("Terdapat kesalahan penulisan tanggal");
            }

            ArrayList<String> howard = new ArrayList<String>();
            ArrayList<String> jarvis = new ArrayList<String>();
            ArrayList<String> friday = new ArrayList<String>();
            ArrayList<String> pepper = new ArrayList<String>();
            ArrayList<String> happy = new ArrayList<String>();

            int totalHoward = 0;
            int totalJarvis = 0;
            int totalFriday = 0;
            int totalPepper = 0;
            int totalHappy = 0;

            int counter = 0;
            while (in.hasNext()) {
                counter++;                
                String line = in.nextLine();
                String provider = line.split(" ")[0];
                char tipe = line.split(" ")[1].charAt(0);
                String nom = line.split(" ")[1].substring(1);
                int nominal;
                try {
                    nominal = Integer.parseInt(nom);
                }
                catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Terdapat kesalahan penulisan nominal");
                }
                if (provider.equals("Jarvis") || provider.equals("Friday")){
                    nominal++;
                    if (tipe == 'V') nominal++;
                    if (counter % 10 == 0 && nominal > 50) nominal = (int) Math.ceil(0.9 * nominal); 
                }
                else {
                    nominal += 2;
                    if (tipe == 'V') nominal++;
                    if (counter % 10 == 0 && nominal > 50) nominal = (int) Math.ceil(0.9 * nominal); 
                }
                if (provider.equals("Howard")) {howard.add(Integer.toString(nominal)); totalHoward += nominal;}
                else if (provider.equals("Jarvis")) {jarvis.add(Integer.toString(nominal)); totalJarvis += nominal;}
                else if (provider.equals("Friday")) {friday.add(Integer.toString(nominal)); totalFriday += nominal;}
                else if (provider.equals("Pepper")) {pepper.add(Integer.toString(nominal)); totalPepper += nominal;}
                else if (provider.equals("Happy")) {happy.add(Integer.toString(nominal)); totalHappy += nominal;}
                else {
                    throw new ProviderException(String.format("Provider %s tidak terdaftar", provider));
                }
            }    
   
            in.close(); 

            File howardFile = new File("howard.txt");
            File jarvisFile = new File("jarvis.txt");
            File fridayFile = new File("friday.txt");
            File pepperFile = new File("pepper.txt");
            File happyFile = new File("happy.txt");

            howardFile.createNewFile();
            jarvisFile.createNewFile();
            fridayFile.createNewFile();
            pepperFile.createNewFile();
            happyFile.createNewFile();

            FileWriter howardWriter = new FileWriter(howardFile);
            FileWriter jarvisWriter = new FileWriter(jarvisFile);
            FileWriter fridayWriter = new FileWriter(fridayFile);
            FileWriter pepperWriter = new FileWriter(pepperFile);
            FileWriter happyWriter = new FileWriter(happyFile);

            howardWriter.write(String.format("%s Total penjualan = Rp %d,000 (%s)", tanggal, totalHoward, String.join("+", howard)));
            jarvisWriter.write(String.format("%s Total penjualan = Rp %d,000 (%s)", tanggal, totalJarvis, String.join("+", jarvis)));
            fridayWriter.write(String.format("%s Total penjualan = Rp %d,000 (%s)", tanggal, totalFriday, String.join("+", friday)));
            pepperWriter.write(String.format("%s Total penjualan = Rp %d,000 (%s)", tanggal, totalPepper, String.join("+", pepper)));
            happyWriter.write(String.format("%s Total penjualan = Rp %d,000 (%s)", tanggal, totalHappy, String.join("+", happy)));

            howardWriter.flush();
            jarvisWriter.flush();
            fridayWriter.flush();
            pepperWriter.flush();
            happyWriter.flush();

            howardWriter.close();
            jarvisWriter.close();
            fridayWriter.close();
            pepperWriter.close();
            happyWriter.close();
        }   

        catch (IOException ioe) {
            throw new IOException("Ada error");
        } 
        catch (ProviderException pe){
            System.out.println(pe);
        }
    } 
}

class ProviderException extends Exception {
    public ProviderException(String message) {
        super(message);
    }
}