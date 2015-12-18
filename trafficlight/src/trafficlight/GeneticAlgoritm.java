package trafficlight;

public class GeneticAlgoritm {
    
    private int firstCrossbreeding;
    private int secondCrossbreeding;
    public Bin newBin;
    
    public GeneticAlgoritm(Bin bin, Simulator simulator) {
        double[] p = P(bin, simulator.timeOfStop);
        int[][] luckyInt = Roulette(bin, p);
        int[][] newGeneration = Crossbreeding(bin, luckyInt);
        newBin = Combining(bin, newGeneration);
    }
    
    private Bin Combining(Bin bin, int[][] newInt) {
        
        for(int i = 0; i < 2; i++) {
            bin.bin[firstCrossbreeding][i] = newInt[0][i];
        }
        for(int i = 0; i < 2; i++) {
            bin.bin[secondCrossbreeding][i] = newInt[1][i];
        }
        return bin;
    }
    
    private int[][] Crossbreeding(Bin bin, int[][] luckyInt) {
        final int pos = 5;
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
        return newGeneration;
    }
    
    private double[] P(Bin bin, int[] timeOfStop) {
        int sum = sumMaker(timeOfStop);
        double summ = 0;
        double[] P = new double[timeOfStop.length + 1];
        for(int i = 1; i < bin.getSize(bin) + 1; i++) {
            P[i] = 360 * timeOfStop[i - 1];
            P[i] /= sum ;
            P[i] += summ;
            summ = P[i];
        }
        P[0] = -1;
        return P;
    }
    
    private int sumMaker(int[] timeOfStop) {
        int sum = 0;
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
        return sum;
    }
    
    private int[][] Roulette(Bin bin, double[] P) {
        firstCrossbreeding = -1;
        secondCrossbreeding = -1;
        int[][] luckyInt = new int[2][2];
        for(int x = 0; x < 2; x++) {
            double randomInt = Math.random() * 360;
            for(int i = 1; i < P.length; i++) {
                if((randomInt > P[i - 1])&&(P[i] <= randomInt)) {
                    for(int y = 0; y < 2; y++) {
                        luckyInt[x][y] = bin.bin[i][y];
                        if(firstCrossbreeding == -1) {
                            firstCrossbreeding = i;
                        } else {
                            secondCrossbreeding = i;
                        }
                    }
                }
            }
        }
        return luckyInt;
    }
}
