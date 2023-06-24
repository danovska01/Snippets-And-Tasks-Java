package Blockchain_Network_2;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Block>blockChain = new ArrayList<>();

        //Block 0
        String[]initialValues = {"Block 0 ", "values"};
        Block zeroBlock = new Block(initialValues,0);
        blockChain.add(zeroBlock);

        System.out.println("The Genesis Block is: " + zeroBlock.toString());
        System.out.println("The entire blockchain is: " + blockChain.toString());

        //First Block
        String[]block1Values = {"Block 1", "values"};
        Block firstBlock = new Block(block1Values, zeroBlock.getBlockHash());
        blockChain.add(firstBlock);

        System.out.println("The First Block is: " + firstBlock.toString());
        System.out.println("The entire blockchain is: " + blockChain.toString());


    }
}