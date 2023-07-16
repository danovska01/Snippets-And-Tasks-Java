package Blockchain_Network_1;

import java.sql.*;
import java.util.Properties;

public class BlockchainView {
    static Blockchain blockchain = new Blockchain();

    public static void main(String[] args) throws SQLException {
        //CONNECT TO THE DATABASE BY SETTING USER, PASSWORD, TABLE NAME
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "Badger3802!!");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/blockchain_network", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT timestamp, transactions, current_block_hash, previous_block_hash, nonce FROM blockchain_network ORDER BY block_id;");
        ResultSet rs = stmt.executeQuery();

        //CHECK ALL BLOCKS FROM THE DATABASE AND INSERT THEM INTO THE "Blockchain blockchain"
        while (rs.next()) {
            String[] transactions = getTransactionsIntoArray(rs);
            String previousBlockHash = rs.getString("previous_block_hash");
            String blockHash = rs.getString("current_block_hash");
            long timeStamp = rs.getLong("timestamp");
            int nonce = rs.getInt("nonce");
            Block block = new Block(timeStamp, transactions, previousBlockHash, blockHash, nonce);
            blockchain.getListOfBlocksInBlockchain().add(block);
        }

        // Print the blockchain
        System.out.println(blockchain.getListOfBlocksInBlockchain().toString());
    }

    private static String[] getTransactionsIntoArray(ResultSet rs) throws SQLException {
        String transactionsString = rs.getString("transactions");
        int lastIndex = transactionsString.length() - 1;
        String transactionsSubstring = transactionsString.substring(1, lastIndex);
        return transactionsSubstring.split(",");
    }
}
