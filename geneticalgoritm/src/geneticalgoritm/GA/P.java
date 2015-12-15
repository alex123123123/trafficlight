package geneticalgoritm.GA;

import java.io.IOException;

public class P {
    
    public P(int[] timeOfStop, int[][] bin) throws IOException {
        int sum = 0;
        double summ = 0;
        double[] P = new double[timeOfStop.length + 1];
        for(int i : timeOfStop) {
            sum += i;
        }
        for(int i = 0; i < timeOfStop.length; i++) {
            timeOfStop[i] = sum - timeOfStop[i];
        }
        sum = 0;
        for(int i : timeOfStop) {
            sum += i;
        }
        for(int i = 1; i < timeOfStop.length + 1; i++) {
            P[i] = 360 * timeOfStop[i - 1];
            P[i] /= sum ;
            P[i] += summ;
            summ = P[i];
        }
        P[0] = -1;
        Roulette roulette = new Roulette(bin, P);
    }
}
