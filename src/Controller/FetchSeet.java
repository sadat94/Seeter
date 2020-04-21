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
public class FetchSeet implements Command{
    
    private AllCommandImplementer implementer;
    
     public FetchSeet(AllCommandImplementer implementer) {
        this.implementer = implementer;
    }
    
    @Override
    public boolean execute() {
        try {
            return implementer.fetch();
        } catch (IOException ex) {
            Logger.getLogger(FetchSeet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FetchSeet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
}
