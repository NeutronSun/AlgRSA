import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TheBigFile fl = new TheBigFile();
        Fermat f = new Fermat(fl);
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("1| Create a new File");
            System.out.println("2| Do RSA encryption");
            switch(in.nextInt()) {

                case 1:
                f.findPrimeWith();
                break;

                case 2:
                if(!fl.fileExists()){
                    System.out.println("Unable to find the file with the prime numbers for the RSA algorithm, please create it.");
                    f.findPrimeWith();
                }
                Rsa rsa = new Rsa(fl);
                return;
            }
        }
        
    }
}
