package geneticalgoritm.GA;

import java.io.IOException;

public class Combining {
    
    public Combining(int[][] newInt, int[][] bin, int firstCrossbreeding, int secondCrossbreeding) throws IOException {
        
        if(firstCrossbreeding == -1) {
            FirstPeople firstpeople = new FirstPeople("newPeople");
        }
        
        for(int i = 0; i < 2; i++) {
            bin[firstCrossbreeding][i] = newInt[0][i];
        }
        for(int i = 0; i < 2; i++) {
            bin[secondCrossbreeding][i] = newInt[1][i];
        }
        Save save = new Save(bin);
    }
}
