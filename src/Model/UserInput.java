/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    
    
     private final String input;

    public UserInput(String newInput) {
        this.input = newInput;
    }

    /**
     * Return the command word (the first word) of this command. If the command
     * was not understood, the result is null.
     *
     * @return The command word.
     */
    public String getFirstWord() throws IOException {
        return processWord(0);
    }

    public String getSecondWord() throws IOException {
        return processWord(1);
    }

    public String[] getMessageWord() throws IOException {
        List<String> list = processCommand();
        list.remove(0);
        return list.toArray(new String[list.size()]);
    }
    
    public String processWord(int index) throws IOException {
     
        if(input ==  null || index >= input.split(" ").length){
            return null;
        }
        return input.split(" ")[index];
    }

    public List processCommand() throws IOException {

        if (input == null) {
            throw new IOException("Input stream closed while reading.");
        }

        List<String> split = Arrays.stream(input.trim().split("\\ "))
                .map(x -> x.trim()).collect(Collectors.toList());

        return split;
    }

    
    
    
    
    
    
//    private String input;
//    
//      /**
//     * Create a command object.
//     *
//     * @param fullCommand The entire line input from the user, such as "load file.exe 1 2 3"
//     */
//    public UserInput(String fullCommand) {
//        input = fullCommand;
//    }
//
//    /**
//     * Gets a word or command denoted by the index when the full input is split by a delimiter.
//     * @param index the index in the array of commands split by spaces
//     * @return an individual word
//     */
//    private String getWordAt(int index) {
//        if (input == null || index >= input.split(" ").length) {
//            return null;
//        }
//        return input.split(" ")[index];
//    }
//
//    /**
//     * Return the command word (the first word) of this command. If the command
//     * was not understood, the result is null.
//     *
//     * @return The command word.
//     */
//    public String getCommandWord() {
//        return getWordAt(0);
//    }
//
//    /**
//     * @return The second word of this command. Returns null if there was no
//     * second word.
//     */
//    public String getSecondWord() {
//        return getWordAt(1);
//    }
//    
//    public String getDraftMessage(){
//        return getWordAt(2);
//    }


   

}
