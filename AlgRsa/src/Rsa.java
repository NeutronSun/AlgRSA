import java.io.IOException;
import java.math.BigInteger;

public class Rsa {
    private BigInteger p = new BigInteger("7");
    private BigInteger q = new BigInteger("11");
    private BigInteger n = new BigInteger("0");
    private BigInteger e = new BigInteger("0");
    private BigInteger d = new BigInteger("0");

    private TheBigFile file;
    private boolean allSetted;


    public Rsa(TheBigFile file) throws IOException{
        this.file = file;
        setRandomPrime();
        n = p.multiply(q);
        e = coprimes();
        d = findD();
        System.out.println("phi(n): " + phi() + "|q: " + q + "|p: " + p + "|n: " + n + "|e: " + e + "|d: " + d);
        allSetted = true;
    }

    public boolean allSetted(){
        return allSetted;
    }

    public BigInteger findD(){
        BigInteger k = BigInteger.TEN.pow(e.toString().length());
        BigInteger phi = phi();
        while(true) {
            if(k.multiply(e).mod(phi).equals(BigInteger.ONE))
                return k;
            k = k.add(BigInteger.ONE);
        }
    } 
    public BigInteger phi(){
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    /*
    public BigInteger mcm(BigInteger a, BigInteger b){
        if (b.equals(BigInteger.ZERO)) return a;
        return mcm(b,a.mod(b));
    }
    */

    public BigInteger coprimes() throws IOException{
        BigInteger phi = phi();
        int lines = file.countLine();
        int rand = (int)(Math.random() * lines) + 1;
        BigInteger prime = new BigInteger(file.getRandomLine(rand));
        /*
        for(BigInteger i = BigInteger.TWO; i.min(phi).equals(i); i = i.add(BigInteger.ONE)){
            if(mcm(i, phi).equals(BigInteger.ONE) && !(i.equals(p) || i.equals(q)))
            return i;
        }
        */
        return prime;
    }
    public void setRandomPrime(){
        try {
            int lines = file.countLine();
            int rand = (int)(Math.random() * lines) + 1;
            p = new BigInteger(file.getRandomLine(rand));
            if(rand < lines)
                rand++; 
            else
                rand--;
            q = new BigInteger(file.getRandomLine(rand));
            
        }catch (IOException e){e.printStackTrace();}    
    }

    public BigInteger encrypt(int x){
        BigInteger msg = new BigInteger(String.valueOf(x));
        System.out.println(msg);
        System.out.println(e);
        System.out.println("msg^n: " + msg.pow(Integer.valueOf(e.toString())));
        return msg.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger msg){
        System.out.println(msg);
        System.out.println(d);
        System.out.println("msg^n: " + msg.pow(Integer.valueOf(d.toString())));
        return msg.modPow(d,n);

    }


}
