import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Gudang {
    List<Barang> daftarBarang;

    public Gudang(List<Barang> daftarBarang){
        this.daftarBarang = daftarBarang;
    }

    public static void masukin(String fileDir, List<Barang> daftarBarang){
        try{
            File f = new File(fileDir);
            Scanner in = new Scanner(f);
            while (in.hasNext()){
                String str = in.nextLine();
                String[] strArray = str.split(",");

                int id; String name; int hargaBarang;

                try {
                    id = Integer.parseInt(strArray[0]);
                    name = strArray[2];
                    hargaBarang = Integer.parseInt(strArray[3]);
                }
                catch (Exception e){
                    continue;
                }

                for (int i = 0; i < strArray.length; i++) {
                    strArray[i] = strArray[i].trim();
                }
                //System.out.println(Arrays.asList(strArray));

                switch(strArray[1]){
                    case "PerangkatKeras":
                        String[] specCPU = strArray[4].split(" ");
                        String brand = specCPU[0];
                        String jenisCPU = (specCPU.length == 4) ? specCPU[1] : specCPU[1] + specCPU[2];
                        String clock = (specCPU.length == 4) ? specCPU[2] : specCPU[3];
                        CPU cpu = new CPU(brand, jenisCPU, clock);

                        String[] specMemory = strArray[5].split(" ");
                        String jenisMemory = (specMemory.length == 3) ? specMemory[0] : "";
                        int kapasitas = (specMemory.length == 3) ? Integer.parseInt(specMemory[1]) : Integer.parseInt(specMemory[0]);
                        Memory memory = new Memory(jenisMemory, kapasitas);

                        String[] specHD = strArray[6].split(" ");
                        String tipe = (specHD.length == 3) ? specHD[0] : "";
                        int kapasitasHD = (specHD.length == 3) ? Integer.parseInt(specHD[1]) : Integer.parseInt(specHD[0]);
                        HardDisk hd = new HardDisk(tipe, kapasitasHD);

                        Barang perangkatKeras = new PerangkatKeras(id, name, hargaBarang, cpu, memory, hd);
                        daftarBarang.add(perangkatKeras);
                        break;

                    case "PerangkatLunak":
                        String[] specOS = strArray[4].split(" ");
                        String nameOS = specOS[0];
                        String version = specOS[1];
                        OS os = new OS(nameOS, version);

                        String jenisPerangkatLunak = strArray[5];

                        Barang perangkatLunak = new PerangkatLunak(id, name, hargaBarang, os, jenisPerangkatLunak);
                        daftarBarang.add(perangkatLunak);
                        break;

                    case "Aksesoris":
                        String deskripsi = strArray[4];
                        Barang acc = new Aksesoris(id, name, hargaBarang, deskripsi);

                        daftarBarang.add(acc);
                        break;

                    default:
                        break;
                }
            }
            //System.out.println(daftarBarang);
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }
}