import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Fermat f = new Fermat();
        if(!f.existsFile())
            f.createFile();
        
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("1| Create a new File");
            System.out.println("2| Do RSA encryption");
            switch(in.nextInt()) {

                case 1:
                System.out.print("Enter the number of digits: ");
                int nD = in.nextInt();
                System.out.print("Enter the number of Prime to find: ");
                int nP = in.nextInt();
                f.setNdigits(nD);
                f.setNprime(nP);
                f.findPrimeWith();
            }
        }
        
    }
}
