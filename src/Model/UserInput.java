/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ss15a
 */
public class UserInput {
    
    
    private String input;
    
      /**
     * Create a command object.
     *
     * @param fullCommand The entire line input from the user, such as "load file.exe 1 2 3"
     */
    public UserInput(String fullCommand) {
        input = fullCommand;
    }

    /**
     * Gets a word or command denoted by the index when the full input is split by a delimiter.
     * @param index the index in the array of commands split by spaces
     * @return an individual word
     */
    private String getWordAt(int index) {
        if (input == null || index >= input.split(" ").length) {
            return null;
        }
        return input.split(" ")[index];
    }

    /**
     * Return the command word (the first word) of this command. If the command
     * was not understood, the result is null.
     *
     * @return The command word.
     */
    public String getCommandWord() {
        return getWordAt(0);
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord() {
        return getWordAt(1);
    }
}
