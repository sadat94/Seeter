/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.UserInput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ss15a
 */
public class Reader {
    
     private BufferedReader reader;

    public Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public UserInput getCommand() throws IOException {
        return new UserInput(reader.readLine());
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
    
}
