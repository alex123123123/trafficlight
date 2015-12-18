package trafficlight;

import java.io.FileNotFoundException;

public class Iterate {

    private int counter; 
    
    public Iterate(int num) throws FileNotFoundException {
        counter = num;
        Iterate firstStep = new Iterate();
    }
    
    public Iterate() throws FileNotFoundException {
        boolean bool = isEnough();
        if(bool) {
            algoritmStep();
        }
    }
    
    private boolean isEnough() {
        boolean bool = true;
        if(counter > 9) {
            bool = false;
        } else {
            counter++;
        }
        return bool;
    }
    
    private void algoritmStep() throws FileNotFoundException {
        Bin bin = new Bin("oldPeople");
        Simulator simulator = new Simulator(bin);
        GeneticAlgoritm GA = new GeneticAlgoritm(bin, simulator);
        Iterate nextStep = new Iterate();
    }
    
}
