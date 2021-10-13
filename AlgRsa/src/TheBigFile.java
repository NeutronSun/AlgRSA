import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TheBigFile {
    private File file;

    public TheBigFile(){
        file = new File("primes.txt");
    }

    public boolean fileExists(){
        return file.exists();
    }

    public void write(String[] s) throws IOException{
        FileWriter fw = new FileWriter(file);
        for(String p : s)
        fw.write(p + "\n");
        fw.close();
    }

    public int countLine() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
    public String getRandomLine(int rand) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for(int i = 0; i <rand; i++) {
            if(i == rand-1)
            return reader.readLine();
        }
        reader.close();
        return "null";
    }
}
