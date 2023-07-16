package connect_sql_JDBC;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class connection_MongoDB {
    public static void main(String[] args) {
        // Connect to MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Get the database (if it doesn't exist, it will be created automatically)
        MongoDatabase database = mongoClient.getDatabase("test_db");

        // Create a collection (if it doesn't exist, it will be created automatically)
        MongoCollection<Document> collection = database.getCollection("my_collection");

        // Create a document to insert into the collection
        Document document1 = new Document("name", "John Doe")
                .append("age", 30)
                .append("city", "New York");

        Document document2 = new Document("name", "Jane Smith")
                .append("age", 35)
                .append("city", "Los Angeles");

        // Insert the documents into the collection
        collection.insertOne(document1);
        collection.insertOne(document2);

        // Close the MongoDB connection
        mongoClient.close();
    }
}
