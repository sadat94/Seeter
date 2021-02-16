/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ss15adx Sadat Safuan
 */
public class SendSeet implements Command {
    
    private final AllCommandImplementer implementer;
    
    public SendSeet(AllCommandImplementer implementer) {
        this.implementer = implementer;
    }

    @Override //Command
    public boolean execute() {
        try {
            return implementer.send();
        } catch (IOException ex) {
            Logger.getLogger(SendSeet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
