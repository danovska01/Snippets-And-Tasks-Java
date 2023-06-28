package Blockchain_Network_3;

import java.sql.*;
import java.util.*;

public class CreateBlock {

    static Block lastBlock;

    public static void main(String[] args) throws SQLException {

        //CONNECT TO THE DATABASE, IN THIS CASE WORKBENCH MYSQL
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "Badger3802!!"); // HERE YOU SET USER AND PASSWORD
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchain_network", props);//CONNECT TO THE DB
        PreparedStatement stmt = connection.prepareStatement("SELECT block_id, timestamp, transactions, current_block_hash, previous_block_hash, nonce FROM blockchain_network ORDER BY block_id DESC LIMIT 1;");
        ResultSet rs = stmt.executeQuery();


        //FETCH LAST BLOCK FROM THE DATABASE IF THERE IS ANY AND STORE IT INTO "static Block lastBlock"
        if (rs.next()) {
            String transactionsString = rs.getString("transactions");
            int lastIndex = transactionsString.length() - 1;
            String transactionsSubstring = transactionsString.substring(1, lastIndex);
            String[] transactions = transactionsSubstring.split(",");
            String previousBlockHash = rs.getString("previous_block_hash");
            String blockHash = rs.getString("current_block_hash");
            long timeStamp = rs.getLong("timestamp");
            int nonce = rs.getInt("nonce");
            lastBlock = new Block(timeStamp, transactions, previousBlockHash, blockHash, nonce);
        }
        // Close the ResultSet and PreparedStatement
        rs.close();
        stmt.close();

        //CHECK IF THERE IS BLOCK ZERO, IF THERE IS NO BLOCK ZERO, WE CREATE IT
        if (lastBlock == null) {
            String[] initialValues = {"Block 0", "ZERO BLOCK INITIALIZED!"};
            Block zeroBlock = new Block(initialValues);
            PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO blockchain_network (timestamp, transactions, current_block_hash, previous_block_hash, nonce) VALUES (?, ?, ?, ?, ?);");
            insertStmt.setString(1, String.valueOf(zeroBlock.getTimeStamp()));
            insertStmt.setString(2, Arrays.toString(zeroBlock.getTransactions()));
            insertStmt.setString(3, zeroBlock.getBlockHash());
            insertStmt.setString(4, zeroBlock.getPreviousHash());
            insertStmt.setString(5, String.valueOf(zeroBlock.getNonce()));
            insertStmt.executeUpdate();
            insertStmt.close();
            System.out.println("ZERO BLOCK CREATED! ");
        } else {
            //IF A BLOCK IS CREATED ALREADY AND STORED IN THE DATABASE, WE GET IT AS "lastBlock" AND BASED ON IT, WE CREATE A NEW ONE
            List<String> transactionsList = new ArrayList<>();
            System.out.println("Enter MESSAGE/S as simulation of TRANSACTION MESSAGE/S, each on a new line. Type 'end' to finish.");
            System.out.println("If you want no messages , just type 'end' to finish.");
            String message = sc.nextLine();
            while (!message.equals("end")) {
                transactionsList.add(message);
                message = sc.nextLine();
            }
            String[] transactions = transactionsList.toArray(new String[0]);

            //CREATE A NEW BLOCK BY GETTING THE LAST ONE FROM THE DATABASE, BASED ON IT AND INPUT TRANSACTIONS
            Block newBlock = new Block(transactions, lastBlock.getBlockHash());

            //INSERT THE NEWLY CREATED BLOCK IN THE DATABASE
            PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO blockchain_network (timestamp, transactions, current_block_hash, previous_block_hash, nonce) VALUES (?, ?, ?, ?, ?);");
            insertStmt.setString(1, String.valueOf(newBlock.getTimeStamp()));
            insertStmt.setString(2, Arrays.toString(newBlock.getTransactions()));
            insertStmt.setString(3, newBlock.getBlockHash());
            insertStmt.setString(4, lastBlock.getBlockHash());
            insertStmt.setString(5, String.valueOf(lastBlock.getNonce()+1));
            insertStmt.executeUpdate();
            insertStmt.close();
            System.out.println("NEW BLOCK CREATED!");

        }
        // Close the connection
        connection.close();
    }
}
