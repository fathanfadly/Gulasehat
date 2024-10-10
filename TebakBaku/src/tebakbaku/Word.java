/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tebakbaku;

/**
 *
 * @author syuja
 */
public class Word {
    private final int id;
    private final String word;
    private final boolean isCorrect;

    /**
     * Constructs a Word object.
     *
     * @param id        The ID of the word.
     * @param word      The word string.
     * @param isCorrect Indicates whether the word is correct or not.
     * @throws IllegalArgumentException If the ID is negative or if the word is null.
     */
    public Word(int id, String word, boolean isCorrect) {
        // Validate input values
        if (id < 0) {
            throw new IllegalArgumentException("ID must be non-negative");
        }
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }

        this.id = id;
        this.word = word;
        this.isCorrect = isCorrect;
    }

    /**
     * Gets the ID of the word.
     *
     * @return The ID of the word.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the word string.
     *
     * @return The word string.
     */
    public String getWord() {
        return word;
    }

    /**
     * Checks if the word is correct.
     *
     * @return True if the word is correct, false otherwise.
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    // Additional methods, if needed...
}