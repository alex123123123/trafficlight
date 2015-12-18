package trafficlight;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Bin {
    
    public int[][] bin;
    
    public Bin(int vCount) {
        newBin(this, vCount);
    }
    
    public Bin(Bin bin) {
        TaskFileIO.write(bin);
    }
    
    public Bin(String filePath) throws FileNotFoundException {
        TaskFileIO.read(filePath);
    }
    
    public int getText(Bin bin, int i, int j) {
        return bin.bin[i][j];
    }
   
    public int getSize(Bin bin) {
        return bin.bin.length;
    }
    
    private void setSize(Bin bin, int sizeX, int sizeY) {
        bin.bin = new int[sizeX][sizeY];
    }
    
    public void setText(Bin bin, int i, int j, int txt) {
        bin.bin[i][j] = txt;
    }
    
    private void newBin(Bin bin, int vCount) {
        setSize(bin, vCount, 2);
    }
    
    public String toUTF8(int value) {
        String str = String.valueOf(value);
        try {
            str = new String(str.getBytes(),"utf-8");
        } catch (UnsupportedEncodingException ex) {
            System.err.toString();
        }
        return str;
    }
}
