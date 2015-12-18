package trafficlight;

public class Simulator {
    
    public int[] timeOfStop;
    
    public Simulator(Bin bin){
        timeOfStopContent(bin);
    }
    
    private void timeOfStopContent(Bin bin) {
        timeOfStop = new int[bin.getSize(bin)];
        int sum = 0;
        for(int i = 0; i < bin.getSize(bin); i++) {
            timeOfStop[i] = 1;
            for(int j = 0; j < bin.getSize(bin); j++) {
                timeOfStop[i] *= bin.getText(bin, i, j); 
            }
            sum += timeOfStop[i];
        }
        sumToScreen(sum);
    }
    
    private void sumToScreen(int summ) {
        System.out.println("Summ = " + summ);
    }
}
