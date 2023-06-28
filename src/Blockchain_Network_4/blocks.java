package Blockchain_Network_4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
//import javax.xml.bind.DatatypeConverter;

class block
{
    int index,nonce;
    float currency;
    String timestamp,previousHash,hash;
    block(int index, String timestamp, String previousHash, float currency)
    {
        this.index=index;
        this.currency=currency;
        this.timestamp=timestamp;
        this.previousHash=previousHash;
        this.hash=calculateHash();
        this.nonce=0;
    }
    public static String getHash(byte[] inputBytes, String algorithm)
    {
        String hashValue="";
        try{
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes= messageDigest.digest();
            //hashValue =DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }
        catch(NoSuchAlgorithmException e)
        {
        }
        return hashValue;
    }

    String calculateHash()
    {
        String c_str=previousHash+timestamp+currency+Integer.toString(index)+Integer.toString(nonce);
        return getHash(c_str.getBytes(),"SHA-256");
    }
    public void mineBlock(int dificulty)
    {
        StringBuilder sb = new StringBuilder(dificulty);
        for (int i = 0; i < dificulty; ++i) {
            sb.append("0");
        }
        String result = sb.toString();
        //  System.out.println(result);
        //   System.out.println(hash.substring(0,dificulty));
        while(!(hash.substring(0,dificulty)).equals(result))
        {
            nonce++;
            hash=calculateHash();
            //  System.out.println(hash);
        }

    }
}
public class blocks {

    List<block> chain;
    int difficulty=1;

    public block getLatestBlock()
    {
        return chain.get(chain.size()-1);
    }
    public blocks() {
        chain = new ArrayList<block>();
        chain.add(new block(0,"1/03/2016","Genisis Blockchain_Network_4.block",0));
    }
    public void addBlock(block newBlock)
    {
        newBlock.previousHash=getLatestBlock().hash;
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
        System.out.println("Mined");
        System.out.println("Hash= "+newBlock.hash);
        System.out.println("Timestamp= "+newBlock.timestamp);
        System.out.println("Index= "+Integer.toString(newBlock.index));
        System.out.println("PreviousHash= "+newBlock.previousHash);
        System.out.println("nonce= "+newBlock.nonce);
        System.out.println("Currency="+newBlock.currency);
    }

    public boolean isChainValid()
    {
        for(int i=chain.size()-1;i>0;i--)
        {
            if(!chain.get(i).hash.equals(chain.get(i).calculateHash()))
            {
                return false;
            }
            if(!chain.get(i).previousHash.equals(chain.get(i-1).hash))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(" ");
        blocks a=new blocks();
        a.addBlock(new block(1, "1/03/2016", "Genisis Blockchain_Network_4.block", 0));
        a.addBlock(new block(2, "5/03/2016", "", 45));
        a.addBlock(new block(3, "7/04/2016", "", 56));
        a.chain.get(1).currency=450.7f;
        System.out.println("Chain Valid :: "+a.isChainValid());
    }
}