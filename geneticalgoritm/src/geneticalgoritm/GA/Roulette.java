package geneticalgoritm.GA;

import java.io.IOException;

public class Roulette {

    public Roulette(int[][] bin, double[] P) throws IOException {
        int firstCrossbreeding = -1;
        int secondCrossbreeding = -1;
        int[][] luckyInt = new int[2][2];
        for(int x = 0; x < 2; x++) {
            double randomInt = Math.random() * 360;
            for(int i = 1; i < P.length; i++) {
                if((randomInt > P[i - 1])&&(P[i] <= randomInt)) {
                    for(int y = 0; y < 2; y++) {
                        luckyInt[x][y] = bin[i][y];
                        if(firstCrossbreeding == -1) {
                            firstCrossbreeding = i;
                        } else {
                            secondCrossbreeding = i;
                        }
                    }
                }
            }
        }
        Crossbreeding crosbreeding = new Crossbreeding(luckyInt, 5, bin, 
                firstCrossbreeding, secondCrossbreeding);
    }
}
