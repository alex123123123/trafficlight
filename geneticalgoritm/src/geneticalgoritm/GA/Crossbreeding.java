package geneticalgoritm.GA;

import java.io.IOException;

public class Crossbreeding {
    
    public Crossbreeding(int[][] luckyInt, int pos, int[][] bin, 
            int firstCrossbreeding, int secondCrossbreeding) throws IOException {
        int[] masks = new int[2];
        int[][] newGeneration = new int[2][2];
        masks[0] = (1<<pos)-1;
        masks[1] = ~ masks[0];
        newGeneration[0][0] = (luckyInt[0][0] & masks[1])|(luckyInt[1][0] & 
                masks[0]);
        newGeneration[1][0] = (luckyInt[0][0] & masks[0])|(luckyInt[1][0] & 
                masks[1]);
        newGeneration[0][1] = (luckyInt[0][1] & masks[1])|(luckyInt[1][1] & 
                masks[0]);
        newGeneration[1][1] = (luckyInt[0][1] & masks[0])|(luckyInt[1][1] & 
                masks[1]);
        Combining combining = new Combining(newGeneration, bin, 
                firstCrossbreeding, secondCrossbreeding);
    }
}
