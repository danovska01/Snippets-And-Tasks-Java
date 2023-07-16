package Blockchain_Network_1;

import java.util.Arrays;
import java.util.Date;

public class Block {

    private int nonce;
    private long timeStamp;
    private String[] transactions;

    private String blockHash;
    private String previousHash;

    public Block(long timeStamp, String [] transactions, String previousHash, String blockHash,int nonce ) {
        this.timeStamp = timeStamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.blockHash= blockHash;
        this.nonce = nonce;
    }

    public Block(String[] transactions, String previousHash) {
        this.timeStamp = new Date().getTime();
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.blockHash = calculateHash();
        this.nonce= getNonce();

    }

    public Block(String[] transactions) {
        this.timeStamp = new Date().getTime();
        this.transactions = transactions;
        this.blockHash = calculateGenesisHash();
        this.nonce = 0;
    }

    public String calculateHash() {
        return SHA_256_hash.hash(previousHash + nonce + Arrays.toString(transactions) + timeStamp);
    }

    public String calculateGenesisHash() {
        return SHA_256_hash.hash(nonce + Arrays.toString(transactions) + timeStamp);


    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce() {

    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Block { ").append(System.lineSeparator()).append("timestamp: ").append("'").append(getTimeStamp()).append("'")
                .append(",").append(System.lineSeparator()).append("data: ");
        if (getTransactions().length == 0) {
            sb.append("[],").append(System.lineSeparator());
        } else {
            sb.append("{").append(System.lineSeparator());
            for (int i = 0; i < transactions.length; i++) {
                sb.append("'").append(transactions[i]).append("'").append(System.lineSeparator());

            }
            sb.append("}").append(",").append(System.lineSeparator());
        }

        sb.append("current block hash: ").append("'").append(getBlockHash()).append("'").append(System.lineSeparator()).append("previous block hash: ")
                .append("'").append(getPreviousHash()).append("'").append(System.lineSeparator())
                .append("nonce: ").append(getNonce()).append(System.lineSeparator()).append("}");

        return sb.toString();
    }
}
