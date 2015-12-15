package geneticalgoritm.GA;

import geneticalgoritm.Simulator.Simulator;
import static geneticalgoritm.StartProgramm.counter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    
    public Save(int[][] bin) throws IOException {
        
        try {
            File file = new File("newPeople.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String d = String.valueOf(bin.length);
            String str = new String(d.getBytes(),"utf-8");
            bw.write(str);
            for(int i = 0; i < Integer.parseInt(str); i++) {
                bw.newLine();
                d = Integer.toString(bin[i][0]);
                String i0 = new String(d.getBytes(),"utf-8"); 
                bw.write(i0);
                bw.write("<next>");
                d = Integer.toString(bin[i][1]);
                String i1= new String(d.getBytes(),"utf-8");
                bw.write(i1);
            }
            bw.close();
        } catch (IOException e){
        }
        if(counter > 9) {
            System.exit(counter);
        } else {
            counter++;
            Simulator simulator = new Simulator(bin);
        }
    }
}
