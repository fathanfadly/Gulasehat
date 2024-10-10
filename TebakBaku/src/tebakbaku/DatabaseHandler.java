/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tebakbaku;
/**
 *
 * @author syuja
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class DatabaseHandler {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_quiz_baku";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";    
    
    // Variable to store the current username for the session
    private static String currentUsername;
    private static int currentUserId;
    
    // Method to establish the database connection
    public static Connection establishConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            // Handle the exception (e.g., database connection issue)
            e.printStackTrace();
            return null;
        }
    }
    // Other methods...
    
    //method to login a user to the database
    public static boolean loginUser(String username, String password) {
        try (Connection connection = establishConnection()) {
            if (connection != null) {
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            // User is authenticated, set the current username
                            currentUsername = username;
                            currentUserId = resultSet.getInt("user_id");
                            return true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Method to register the user in the database
    public static boolean registerUser(Connection connection, String username, String password) {
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();

            // If the registration was successful
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Handle the exception (e.g., duplicate username, database connection issue)
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get the current username for the session
    public static String getCurrentUsername() {
        return currentUsername;
    }
    
        public static int getCurrentUserId() {
        return currentUserId;
    }
    
    public static List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM words")) {

            List<Word> trueWords = new ArrayList<>();
            List<Word> falseWords = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String word = resultSet.getString("word");
                boolean isCorrect = resultSet.getBoolean("is_correct");

                Word newWord = new Word(id, word, isCorrect);

                if (isCorrect) {
                    trueWords.add(newWord);
                } else {
                    falseWords.add(newWord);
                }
            }

            // Shuffle the trueWords and falseWords lists
            Collections.shuffle(trueWords);
            Collections.shuffle(falseWords);

            // Select 5-7 true words and the rest from false words
            int trueWordsCount = Math.min(7, trueWords.size());
            int falseWordsCount = Math.max(0, 20 - trueWordsCount);

            // Ensure that the total count is not exceeding the available words
            int totalWordsCount = Math.min(20, trueWordsCount + falseWordsCount);

            words.addAll(trueWords.subList(0, trueWordsCount));
            words.addAll(falseWords.subList(0, totalWordsCount - trueWordsCount));
            Collections.shuffle(words);

        } catch (SQLException e) {
            e.printStackTrace();
    }
    
            // Debugging: Print all 20 words
        System.out.println("All Words from Database:");
        for (Word word : words) {
            System.out.println(word.getWord());
        }
    
    return words;   
    }
    
    public static boolean updatePlayerScore(int userId, int score) {
        String selectQuery = "SELECT * FROM scores WHERE user_id = ?";
        String updateQuery = "UPDATE scores SET score = score + ? WHERE user_id = ?";
        String insertQuery = "INSERT INTO scores (user_id, score) VALUES (?, ?)";

        try (Connection connection = establishConnection()) {
            // Check if the user already has a score
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setInt(1, userId);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // User already has a score, update the existing record
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                            updateStatement.setInt(1, score);
                            updateStatement.setInt(2, userId);

                            int rowsAffected = updateStatement.executeUpdate();
                            return rowsAffected > 0;
                        }
                    } else {
                        // User doesn't have a score, insert a new record
                        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                            insertStatement.setInt(1, userId);
                            insertStatement.setInt(2, score);

                            int rowsAffected = insertStatement.executeUpdate();
                            return rowsAffected > 0;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception (e.g., database connection issue)
            e.printStackTrace();
            return false;
        }
    }

    public static int getPlayerScore(int userId) {
        String query = "SELECT score FROM scores WHERE user_id = ?";

        try (Connection connection = establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("score");
                }
            }

        } catch (SQLException e) {
            // Handle the exception (e.g., database connection issue)
            e.printStackTrace();
        }

        // Return a default value (e.g., 0) if no score is found
        return 0;
    }

    public static List<LeaderboardEntry> getLeaderboard() {
        List<LeaderboardEntry> leaderboardEntries = new ArrayList<>(); 

        String query = "SELECT users.username, COALESCE(SUM(scores.score), 0) AS total_score " +
                       "FROM users " +
                       "LEFT JOIN scores ON users.user_id = scores.user_id " +
                       "GROUP BY users.user_id " +
                       "ORDER BY total_score DESC";

        try (Connection connection = establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int totalScore = resultSet.getInt("total_score");

                leaderboardEntries.add(new LeaderboardEntry(username, totalScore));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leaderboardEntries;
    }    
    
}

