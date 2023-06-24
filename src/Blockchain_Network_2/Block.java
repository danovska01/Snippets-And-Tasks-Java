package Blockchain_Network_2;

import java.util.Arrays;

public class Block {

    private String[] transactions;
    private int blockHash;
    private int previousHash;

    public Block(String[] transactions, int previousHash) {
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.blockHash = Arrays.hashCode(new int[]{Arrays.hashCode(transactions), this.previousHash});
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public int getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(int blockHash) {
        this.blockHash = blockHash;
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "transactions=" + Arrays.toString(transactions) +
                ", blockHash=" + blockHash +
                ", previousHash=" + previousHash +
                '}';
    }
}
