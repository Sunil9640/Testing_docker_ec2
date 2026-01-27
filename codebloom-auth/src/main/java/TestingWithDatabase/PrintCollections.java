package TestingWithDatabase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class PrintCollections {
    public static void main(String[] args) {
        // Connect to MongoDB (adjust URI as needed)
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("codeBloomDatabaseDEVToPRDMongoDB");

            // Print all collection names
            for (String name : database.listCollectionNames()) {
                System.out.println("Collection: " + name);
            }
        }
    }
}
