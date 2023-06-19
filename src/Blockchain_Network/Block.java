package Blockchain_Network;

import java.util.Arrays;
import java.util.Date;


public class Block {

    private int index;

    private int previousHash;
    private int blockHash;
    private long timestamp;
    private String [] transactions;



    public int getBlockHash() {
        return blockHash;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public Block(int previousHash, String[] transactions, long timestamp) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        Object [] contents = {Arrays.hashCode(transactions), previousHash};
        this.blockHash=Arrays.hashCode(contents);
        this.timestamp = new Date().getTime();
    }


}
