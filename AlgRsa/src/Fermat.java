import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class Fermat {
    private File file = new File("primes.txt");
    private int nPrime;
    private int nDigits;

    public Fermat(){
        nPrime = 0;
        nDigits = 0;
    }

    public boolean existsFile(){
        return file.exists();
    }

    public void createFile() throws IOException{
        file.createNewFile();
    }

    public void setNprime(int n){
        nPrime = n;
    }

    public void setNdigits(int n){
        nDigits = n;
    }

    public void findPrimeWith() throws IOException{
        FileWriter fw = new FileWriter(file, false);
        BigInteger start = new BigInteger("10");
        start = start.pow(nDigits).add(start.divide(BigInteger.TWO));
        if(start.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
            start = start.add(new BigInteger("1"));
        }
        for(BigInteger i = start, cont = BigInteger.ZERO; cont.min(BigInteger.valueOf(nPrime)).equals(cont); i = i.add(BigInteger.TWO)){
            if(littleFermatTheorem(i)){
                fw.write(i.toString() + "\n");
                cont = cont.add(BigInteger.ONE);
            }
        }
        fw.flush();
    }

    public boolean littleFermatTheorem(BigInteger p){
        BigInteger a = BigInteger.TWO;
        if(a.modPow(p.subtract(BigInteger.ONE), p).equals(BigInteger.ONE))
        return true;
        return false;
    }


}
