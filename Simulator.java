package geneticalgoritm;

public class Simulator {
    
    public static int[] timeOfStop;
    
    public static void start(int[][] bin) {
        int sum = 0;
        for(int i = 0; i < bin.length; i++) {
            timeOfStop[i] = 1;
            for(int j = 0; j < bin[i].length; j++) {
                timeOfStop[i] *= bin[i][j]; 
            }
            sum += timeOfStop[i];
        }
        System.out.println(sum);
        GeneticAlgoritm.P(timeOfStop);
    }
}