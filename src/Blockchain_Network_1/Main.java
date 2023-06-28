package Blockchain_Network_1;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        String[] genesisTransaction = {"First"};
        long timestampGenesis = new Date().getTime();
        Block genesisBlock = new Block(0, genesisTransaction, timestampGenesis);
        System.out.println(genesisBlock.getBlockHash());

        String[] block2Transaction = {"Second "};
        long timestamp2= new Date().getTime();
        Block block2 = new Block(genesisBlock.getBlockHash(), block2Transaction, timestamp2);
        System.out.println(block2.getBlockHash());

        String[] block3Transaction = {"Third "};
        long timestamp3 = new Date().getTime();
        Block block3 = new Block(block2.getBlockHash(), block3Transaction, timestamp3);
        System.out.println(block3.getBlockHash());




    }
}
