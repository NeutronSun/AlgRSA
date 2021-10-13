import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class Fermat {
    private TheBigFile file;
    private int nPrime;
    private int nDigits;

    public Fermat(TheBigFile file){
        nPrime = 0;
        nDigits = 0;
        this.file = file;
    }
    
    public void setNprime(int n){
        nPrime = n;
    }

    public void setNdigits(int n){
        nDigits = n;
    }

    public void findPrimeWith() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int nD = in.nextInt();
        System.out.print("Enter the number of Prime to find: ");
        int nP = in.nextInt();
        setNdigits(nD);
        setNprime(nP);
        BigInteger start = new BigInteger("10");
        start = start.pow(nDigits);
        start = start.add(start.divide(BigInteger.TWO));
        if(start.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
            start = start.add(new BigInteger("1"));
        }
        String[] p = new String[nPrime+1];
        for(BigInteger i = start, cont = BigInteger.ZERO; cont.min(BigInteger.valueOf(nPrime)).equals(cont); i = i.add(BigInteger.TWO)){
            if(littleFermatTheorem(i)){
                p[cont.intValue()] = i.toString();
                cont = cont.add(BigInteger.ONE);
            }
        }
        file.write(p);
    }

    public boolean littleFermatTheorem(BigInteger p){
        BigInteger a = BigInteger.TWO;
        if(a.modPow(p.subtract(BigInteger.ONE), p).equals(BigInteger.ONE))
        return true;
        return false;
    }


}
