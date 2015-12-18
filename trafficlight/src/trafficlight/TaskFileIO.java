package trafficlight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskFileIO {
    
    public static Bin read(String filePath) throws 
            FileNotFoundException{
        Scanner scan = new Scanner(new File(filePath + ".txt"));
        int vCount = Integer.valueOf(scan.nextLine());
        Bin bin = new Bin(vCount);
        for (int i = 0; i < vCount; i++) {
            String[] arr = scan.nextLine().split("<next>");
            bin.setText(bin, i, 0, Integer.parseInt(arr[0]));
            bin.setText(bin, i, 1, Integer.parseInt(arr[1]));
        }
        return bin;
    }
    
    public static void write(Bin bin) {     
        try {
            File file = new File("newPeople.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String str = bin.toUTF8(bin.getSize(bin));
            bw.write(str);
            for(int i = 0; i < Integer.parseInt(str); i++) {
                bw.newLine();
                String i0 = bin.toUTF8(bin.getText(bin, i, 0));
                bw.write(i0);
                bw.write("<next>");
                String i1 = bin.toUTF8(bin.getText(bin, i, 1));
                bw.write(i1);
            }
            bw.close();
        } catch (IOException e){
            System.err.toString();
        }
    }
}
