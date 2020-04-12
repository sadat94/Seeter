/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AllCommandInvoker;
import View.Client;
import View.Command;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author ss15a
 */

public class AllCommandReceiver {
    
    private AllCommandInvoker commandInvoker;

    public AllCommandReceiver() {
        this.commandInvoker =  new AllCommandInvoker();
    }

    
    
    public AllCommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
    
    
    
    public void populateCommand() {
        
         Command exitApp = ()->this.exit();
         Command composeDraft = ()->this.compose();
         
         commandInvoker.addCommands("exit", exitApp);
         commandInvoker.addCommands("compose", composeDraft);
    }  
    
    public State exit() {
        System.exit(0);
        return State.MAIN;
    }
    
    
    public State compose() {
        
        System.out.println("Compose Draft");
        return State.DRAFTING;
        
    }
    
    public State fecth(){
    
        return State.MAIN;
    }
    
    
    public State body() {
        
        return State.DRAFTING;
    }
       
}
