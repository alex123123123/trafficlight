package geneticalgoritm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneticAlgoritm {
    
    private static int firstCrossbreeding; // Позиция по x первого числа для скрещевания
    private static int secondCrossbreeding; // Позиция по x второго числа для скрещевания
    
    public static int[][] firstPeople(String name) throws IOException { // считывает время для каждой особи из файла oldPeople.txt
        
        Scanner scan = new Scanner(new File(name + ".txt"));
        int vCount = Integer.valueOf(scan.nextLine());
        int[][] timeGR = new int[vCount][2];
        for (int i = 0; i < vCount; i++) {
            String[] arr = scan.nextLine().split("<next>");
            timeGR[i][0] = Integer.parseInt(arr[0]);
            timeGR[i][1] = Integer.parseInt(arr[1]);
        }
        return timeGR;
    }
    
    public static double[] P(int[] timeOfStop, int length) { // Определяет вероятнось для каждой особи
        
        int sum = 0;
        double summ = 0;
        double[] P = new double[timeOfStop.length + 1];
        for(int i : timeOfStop) {
            sum += i;
        }
        for(int i = 1; i < length + 1; i++) {
            P[i] = 360 * timeOfStop[i - 1];
            P[i] /= sum ;
            P[i] += summ;
            summ = P[i];
        }
        P[0] = -1;
        return P;
    }
    
    public static int[][] roulette(int[][] bin, double[] P) { // рулетка
        
        firstCrossbreeding = -1;
        secondCrossbreeding = -1;
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
        return luckyInt;
    }
    
    public static int[][] crossbreeding(int[][] luckyInt, int pos) { //скрещевание
        
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
    
    public static int[][] combining(int[][] newInt, int[][] bin) { // меняет старое время на новое
        
        for(int i = 0; i < 2; i++) {
            bin[firstCrossbreeding][i] = newInt[0][i];
        }
        for(int i = 0; i < 2; i++) {
            bin[secondCrossbreeding][i] = newInt[1][i];
        }
        return bin;
    }
    
    public static void save(int[][] newGeneration) { // сохраняет в файл newPeople.txt
        
        try {
            File file = new File("newPeople.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String d = String.valueOf(newGeneration.length);
            String str = new String(d.getBytes(),"utf-8");
            bw.write(str);
            for(int i = 0; i < Integer.parseInt(str); i++) {
                bw.newLine();
                d = Integer.toString(newGeneration[i][0]);
                String i0 = new String(d.getBytes(),"utf-8"); 
                bw.write(i0);
                bw.write("<next>");
                d = Integer.toString(newGeneration[i][1]);
                String i1= new String(d.getBytes(),"utf-8");
                bw.write(i1);
            }
            bw.close();
        } catch (IOException e){
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        int[][] bin = firstPeople("newPeople"); // числа из файла oldPeople.txt
        int[] timeOfStop = {1, 2, 3, 4}; // числа в массив будут переходить из симулятора
        double[] P = P(timeOfStop, bin.length); // вероятность выпадение каждой особи
        int[][] luckyInt = roulette(bin, P); // luckyInt[2][2], числа для скрещевания
                                             // luckyInt[][0] = врямя зеленого цвета, точно не помню, может и наоборот) 
                                             // luckyInt[][1] = время красного цвета
        int[][] newGeneration = crossbreeding(luckyInt, 2); // пока что там измененный числа ( в скрещеваннии )
        bin = combining(newGeneration, bin);// возврат измененных чисел к bin
        save(bin);// сохранение в файл newPeople.txt
    }
}