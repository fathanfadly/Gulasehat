package tebakbaku;
/**
 *
 * @author syuja
 */
import java.sql.Connection;

public class TebakBaku {        

    public static void main(String[] args) {
        // Establish a connection to the database
        try (Connection connection = DatabaseHandler.establishConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database.");

                // Create the Login frame and set its properties
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                loginFrame.pack();
                loginFrame.setLocationRelativeTo(null); // Center the frame

                // Set the database connection in the Login frame
                loginFrame.setDatabaseConnection(connection);

                // Set the FrameManager for navigation
                FrameManager.setConnection(connection);

            } else {
                System.err.println("Failed to establish a connection to the database.");
            }
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}

