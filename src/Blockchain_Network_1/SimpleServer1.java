package Blockchain_Network_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Properties;

public class SimpleServer1 {
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


        int port = 8002;

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

    private static void handleRequest(Socket clientSocket) throws IOException, SQLException {
        // Read the client's request
        String request = readRequest(clientSocket);
        String responseContent;

        if (request.startsWith("GET /Blockchain_Network_4.blocks/all")) {
            responseContent = getAllBlocksResponse();
        } else if (request.startsWith("GET /block/")) {
            String hash = getHashFromRequest(request);
            responseContent = getBlockByHashResponse(hash);
        } else {
            // Invalid request
            responseContent = "Invalid request!";
        }

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

    private static String readRequest(Socket clientSocket) throws IOException {
        StringBuilder requestBuilder = new StringBuilder();
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line).append("\r\n");
        }

        return requestBuilder.toString();
    }

    private static String getAllBlocksResponse() {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<html><body><h1>All Blocks</h1>");

        for (Block block : blockchain.getListOfBlocksInBlockchain()) {
            responseBuilder.append(block.toString()).append("<br>");
            System.out.println(block);
        }

        responseBuilder.append("</body></html>");

        return responseBuilder.toString();
    }

    private static String getBlockByHashResponse(String hash) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<html><body>");

        for (Block block : blockchain.getListOfBlocksInBlockchain()) {
            if (block.getBlockHash().equals(hash)) {
                responseBuilder.append("<h1>Block with Hash: ").append(hash).append("</h1>");
                responseBuilder.append(block.toString()).append("<br>");
                break;
            }
        }

        responseBuilder.append("</body></html>");

        return responseBuilder.toString();
    }

    private static String getHashFromRequest(String request) {
        int startIndex = request.indexOf("/block/hash/") + "/block/hash/".length();
        int endIndex = request.indexOf(" HTTP/1.1");

        return request.substring(startIndex, endIndex);
    }

    private static String[] getTransactionsIntoArray(ResultSet rs) throws SQLException {
        String transactionsString = rs.getString("transactions");
        int lastIndex = transactionsString.length() - 1;
        String transactionsSubstring = transactionsString.substring(1, lastIndex);
        return transactionsSubstring.split(",");
    }
}
