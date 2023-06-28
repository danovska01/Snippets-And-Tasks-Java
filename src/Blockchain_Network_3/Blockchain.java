package Blockchain_Network_3;

import java.util.ArrayList;


public class Blockchain {
    private ArrayList<Block> listOfBlocksInBlockchain;
    public Blockchain() {
        this.listOfBlocksInBlockchain = new ArrayList<>();
    }

    public ArrayList<Block> getListOfBlocksInBlockchain() {
        return listOfBlocksInBlockchain;
    }

    public void setListOfBlocksInBlockchain(ArrayList<Block> listOfBlocksInBlockchain) {
        this.listOfBlocksInBlockchain = listOfBlocksInBlockchain;
    }

    public int size (){
        return listOfBlocksInBlockchain.size();
    }



}
