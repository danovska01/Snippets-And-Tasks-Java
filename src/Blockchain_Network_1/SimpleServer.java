package Blockchain_Network_1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Properties;

public class SimpleServer {
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


        int port = 8001;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                handleRequest(clientSocket);

                clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        // Read the client's request (optional)
        // You can read and process the request headers or request body if needed


        String blockchainOnServer = blockchain.getListOfBlocksInBlockchain().toString();

        // Prepare the response content
        String responseContent = "<html><body><h1>" + blockchainOnServer + "</h1></body></html>";

        // Prepare the response headers
        String responseHeaders = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + responseContent.length() + "\r\n" +
                "Connection: close\r\n" +
                "\r\n";

        // Send the response
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(responseHeaders.getBytes());
        outputStream.write(responseContent.getBytes());
        outputStream.flush();
    }

    private static String[] getTransactionsIntoArray(ResultSet rs) throws SQLException {
        String transactionsString = rs.getString("transactions");
        int lastIndex = transactionsString.length() - 1;
        String transactionsSubstring = transactionsString.substring(1, lastIndex);
        return transactionsSubstring.split(",");
    }
}
