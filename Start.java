import geneticalgoritm.GeneticAlgoritm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {
        System.out.println("New or old file?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        switch(file) {
            case "new" : GeneticAlgoritm.firstPeople("newPeople");
                break;
            case "old" : System.out.println("Are you sure? Y/N");
                switch(br.readLine()) {
                    case "Y" : GeneticAlgoritm.firstPeople("oldPeople");
                        break;
                    case "N" : main(null);
                        break;
                }
                break;
            default : System.out.println("Enter new or old");
                main(null);
                break;
        }
    }  
}