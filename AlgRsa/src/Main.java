import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Rsa rsa = new Rsa();
        String msg = "";
        while (true) {
            System.out.println("1| Encrypt");
            System.out.println("2| Decrypt");
            switch (in.nextInt()) {

            case 1:
                System.out.print("Enter the message:");
                msg = rsa.encrypt(in.next());
                System.out.println("The encrypted message is: " + msg);
                break;

            case 2:
                System.out.print("Enter the message:");
                System.out.println("the decrypted message is: " + rsa.decrypt(in.next()));
            }
        }

    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
}