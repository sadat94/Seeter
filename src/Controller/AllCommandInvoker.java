/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Internationalisation.Internationalisation;
import Model.SeetProgram;
import java.util.HashMap;

/**
 *
 * @author ss15adx Sadat Safuan
 */
public class AllCommandInvoker {
   
    
    private final HashMap<String, Command> allCommandsMap = new HashMap<>();
    private AllCommandImplementer implementer;
    private SeetProgram seet;
    private static Internationalisation internationalise;
    
    
    public AllCommandInvoker(AllCommandImplementer allCommandsImplementation) {
        
        implementer = allCommandsImplementation;
        
        this.internationalise = new Internationalisation();
        
    }
   
    
    public boolean runCommands(String commandKeyName) {
        
        Command commandValue = allCommandsMap.get(commandKeyName);
        
            if (commandValue == null) {
            
                throw new IllegalStateException(internationalise.no_command_found + commandKeyName);
                
            }
            
            return commandValue.execute();     
    }
    
    
    public void allCommandsRegister() {
        
       allCommandsMap.put("fetch", (Command) new FetchSeet(implementer));
       allCommandsMap.put("compose", (Command) new ComposeSeet(implementer) );
       allCommandsMap.put("body", (Command) new BodySeet(implementer));
       allCommandsMap.put("send", (Command) new SendSeet(implementer));
       
    }
        
    
    public String listEverything() {
        
        String list = "";
        for (String a : allCommandsMap.keySet()) {
            list += a + " ";
        }
        return list;
    }
    
 
   
    public HashMap<String, Command> getAllCommandsMap() {
        
        return allCommandsMap;
        
    }
    
    
}
