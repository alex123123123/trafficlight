package geneticalgoritm.GA;

import geneticalgoritm.Simulator.Simulator;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FirstPeople {
    
    public FirstPeople(String name) throws IOException {
        
        Scanner scan = new Scanner(new File(name + ".txt"));
        int vCount = Integer.valueOf(scan.nextLine());
        int[][] bin = new int[vCount][2];
        for (int i = 0; i < vCount; i++) {
            String[] arr = scan.nextLine().split("<next>");
            bin[i][0] = Integer.parseInt(arr[0]);
            bin[i][1] = Integer.parseInt(arr[1]);
        }
        Simulator simulator = new Simulator(bin);
    }
}
