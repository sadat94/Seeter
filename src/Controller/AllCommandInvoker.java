/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.State;
import View.Command;
import java.util.HashMap;
/**
 *
 * @author ss15a
 */
public class AllCommandInvoker {
    
    private final HashMap<String, Command> allCommandsMap = new HashMap<>();
    
   
    public void addCommands(String commandKeyName, Command commandValue) {
        
        allCommandsMap.put(commandKeyName, commandValue);
        
    }
    
    public State runCommands(String commandKeyName) {
        
        Command commandValue = allCommandsMap.get(commandKeyName);
        
            if (commandValue == null) {
            
                throw new IllegalStateException("no command found for" + commandKeyName);
                
            }
            
            return commandValue.execute();
            
    }

    public HashMap<String, Command> getAllCommandsMap() {
        return allCommandsMap;
    }
    
    
}
