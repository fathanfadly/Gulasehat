package tebakbaku;

/**
 *
 * @author syuja
 */
import javax.swing.JFrame;
import java.sql.Connection;                                 

public class FrameManager {
    
    private static Connection databaseConnection;

    public static void setConnection(Connection connection) {
        databaseConnection = connection;
    }

    public static Connection getConnection() {
        return databaseConnection;
    }
        
    public static void navigateToLogin(JFrame currentFrame) {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        currentFrame.dispose();  // Close the current frame
    }

    
    public static void navigateToRegister(JFrame currentFrame) {
        Register registerFrame = new Register();
        registerFrame.setVisible(true);
        registerFrame.pack();
        registerFrame.setLocationRelativeTo(null);
        currentFrame.dispose();  // Close the current frame
    }
    
        public static void navigateToMenu(JFrame currentFrame) {
        Menu menuFrame = new Menu();
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        currentFrame.dispose();  // Close the current frame
    }
        
    public static void navigateToLeaderboard(JFrame currentFrame) {
        Leaderboard leaderboardFrame = new Leaderboard();
        leaderboardFrame.setVisible(true);
        leaderboardFrame.pack();
        leaderboardFrame.setLocationRelativeTo(null);
        currentFrame.dispose();
    }
    
    public static void navigateToGame(JFrame currentFrame) {
        Game gameFrame = new Game();
        gameFrame.setVisible(true);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        currentFrame.dispose(); // Close the current frame
    }
    // Add more methods for other frames as needed

    private static void showFrame(JFrame frame) {
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
    }
}

