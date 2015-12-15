package geneticalgoritm.Simulator;

import geneticalgoritm.GA.P;
import java.io.IOException;

public class Simulator {
    
    public Simulator(int[][] bin) throws IOException {
        int sum = 0;
        int[] timeOfStop = new int[bin.length];
        for(int i = 0; i < bin.length; i++) {
            timeOfStop[i] = 1;
            for(int j = 0; j < bin[i].length; j++) {
                timeOfStop[i] *= bin[i][j]; 
            }
            sum += timeOfStop[i];
        }
        System.out.println(sum);
        P p = new P(timeOfStop, bin);
    }
}
