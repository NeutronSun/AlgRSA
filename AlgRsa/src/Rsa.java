import java.io.IOException;
import java.math.BigInteger;

public class Rsa {
    private BigInteger p = new BigInteger("0");
    private BigInteger q = new BigInteger("0");
    private BigInteger n = new BigInteger("0");
    private BigInteger e = new BigInteger("0");
    private BigInteger d = new BigInteger("0");

    private TheBigFile file;


    public Rsa(TheBigFile file){
        this.file = file;
        setRandomPrime();
        n = p.multiply(q);
        e = coprimes();
    }

    public BigInteger findD(){
        BigInteger k = new BigInteger("1");
        while(true){
            
        }
    }
    public BigInteger phi(){
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    public BigInteger mcm(BigInteger a, BigInteger b){
        if (b.equals(BigInteger.ZERO)) return a;
        return mcm(b,a.mod(b));
    }

    public BigInteger coprimes(){
        BigInteger phi = phi();
        for(BigInteger i = BigInteger.TWO; i.min(phi).equals(i); i = i.add(BigInteger.ONE)){
            if(mcm(i, phi).equals(BigInteger.ONE))
            return i;
        }
        return null;
    }
    public void setRandomPrime(){
        try {
            int lines = file.countLine();
            int rand = (int)(Math.random() * lines) + 1;
            p = new BigInteger(file.getRandomLine(rand));
            do{
                rand = (int)(Math.random() * lines) + 1;
                q = new BigInteger(file.getRandomLine(rand));
            }while(p.equals(q));
        }catch (IOException e){e.printStackTrace();}    
    }


}
