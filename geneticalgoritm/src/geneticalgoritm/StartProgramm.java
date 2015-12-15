package geneticalgoritm;

import geneticalgoritm.GA.FirstPeople;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartProgramm {
    
    public static int counter;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        counter = 0;
        String b = br.readLine();
        FirstPeople fp = new FirstPeople(b);
    }
    
}
