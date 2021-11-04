import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Rsa{
    private static BigInteger lastPrime = new BigInteger("150000000000000000000000000000000000000000000000973");
    private BigInteger p = new BigInteger("47");
    private BigInteger q = new BigInteger("71");
    private BigInteger n = new BigInteger("0");
    private BigInteger e = new BigInteger("0");
    private BigInteger d = new BigInteger("0");

    {lastPrime = newPrime(lastPrime);}

    public Rsa(){
        p = newPrime(lastPrime);
        System.out.println("setted");
        q = newPrime(lastPrime);
        System.out.println("setted");
        n = p.multiply(q);
        System.out.println("setted");
        e = coprimes();
        System.out.println("setted");
        //d = findD();
        BigInteger phi = phi();
        d = e.modInverse(phi);
        System.out.println("phi(n): " + phi() + "|q: " + q + "|p: " + p + "|n: " + n + "|e: " + e + "|d: " + d);
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

    public BigInteger coprimes(){
        BigInteger prm = q;
        return newPrime(prm);
    }
    public BigInteger newPrime(BigInteger prime){
        BigInteger a = new BigInteger("2");
        do{
            prime = prime.add(BigInteger.TWO);
        }while(!a.modPow(prime.subtract(BigInteger.ONE), prime).equals(BigInteger.ONE));
        lastPrime = prime;
        return prime;
    }

    public String getD(){
        return d.toString();
    }

    public String getN(){
        return n.toString();
    }

    public BigInteger encrypt(String ss) throws UnsupportedEncodingException{
        System.out.println(ss.length());
        ss = ss.replaceAll("<3", new StringBuilder().appendCodePoint(0x1F497).toString());
        byte[] erbite = ss.getBytes("UTF-8");
        for(int i = 0; i < erbite.length; i++){
            System.out.println("byte: " +i+ " " + erbite[i]);
        }
        BigInteger plainText = new BigInteger(erbite);
        System.out.println("non criptato: " + plainText);
        return plainText.modPow(e,n);
    }

    public String decrypt(BigInteger msg){
        msg = msg.modPow(d,n);
        byte[] erbite = msg.toByteArray();
        for(int i = 0; i < erbite.length; i++){
            System.out.println("byte: " +i+ " " + erbite[i]);
        }
        String ss = new String(erbite);
       // System.out.println("msg^n: " + msg.pow(Integer.valueOf(d.toString())));
        return ss;

    }


}
