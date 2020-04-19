/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.AppSeet;
import java.util.HashMap;

/**
 *
 * @author ss15a
 */
public class AllCommandInvoker {
   
    
    private final HashMap<String, Command> allCommandsMap = new HashMap<>();
    private AllCommandImplementer implementer;
   
//    private CLFormatter clFormatter;
//    private User user;
//    private SeetDraftDatabase seetDatabase;
    private AppSeet seet;
    
    public AllCommandInvoker(AllCommandImplementer allCommandImpl) {
        
        implementer = allCommandImpl;
        
  //      clFormatter = formatter;
    //    this.user = user;
       // seetDatabase = new SeetDraftDatabase();
    }
   
//    public void addCommands(String commandKeyName, Command commandValue) {
//        
//        allCommandsMap.put(commandKeyName, commandValue);
//        
//    }
    
    public boolean runCommands(String commandKeyName) {
        
        Command commandValue = allCommandsMap.get(commandKeyName);
        
            if (commandValue == null) {
            
                throw new IllegalStateException("no command found for" + commandKeyName);
                
            }
            
            return commandValue.execute();     
    }
    
    public void addAppCommands() {
       allCommandsMap.put("fetch", (Command) new FetchSeet(implementer));
       allCommandsMap.put("compose", (Command) new ComposeSeet(implementer) );
       allCommandsMap.put("body", (Command) new BodySeet(implementer));
       allCommandsMap.put("send", (Command) new SendSeet(implementer));
    }
    
//    public void commandRegister() {
//        
//        Command sendCommand = new SendSeet(implementer);
//        Command fetchCommand = new FetchSeet(implementer);
//        Command composeCommand = new ComposeSeet(implementer);
//        Command bodyCommand = new BodySeet(implementer);
//        
//        
//        addCommands("send", sendCommand);
//        addCommands("fetch", fetchCommand);
//        addCommands("compose", composeCommand);
//        addCommands("body", bodyCommand);
//        
//        
        //OR USING LAMBA ::
        
//        Command send = implementer::send;
//        Command fetch = implementer::fetch;
//        Command compose = implementer::compose;
//        Command body = implementer::body;
//        
//         
//        addCommands("send", send);
//        addCommands("fetch", fetch);
//        addCommands("compose", compose);
//        addCommands("body", body);
        
    
    
    
    //USING runCommands method
    
//    public void runCommandsGet() {
//        
//        runCommands("send");
//        runCommands("fetch");
//        runCommands("compose");
//        runCommands("body");
//        
//    }
    
    
    //OR USING executeCommands method
    
//    public void executeCommandsGet() {
//        
//        executeCommands("send");
//        executeCommands("fetch");
//        executeCommands("compose");
//        executeCommands("body");
//        
//    }
    
    
//    public String listEverything() {
//        
//        String list = "";
//        for (String a : allCommandsMap.keySet()) {
//            list += a + " ";
//        }
//        return list;
//    }
//    
    
    //Alternative to runCommands method declared above
    
//    public boolean executeCommands(UserInput commandName) throws IOException {
//        
//        String commandWord = commandName.getFirstWord();
//        String secondWord = commandName.getSecondWord();
//        String [] message = commandName.getMessageWord();
//        
//      //  Command command = allCommandsMap.get(commandName);
//        
//        if (allCommandsMap.containsKey(commandName)) {
//        
//         //   command.execute();
//            
//            seet = new AppSeet(secondWord, message);
//            runCommands(commandWord);
//       
//        }
//        
//     //   else   
//            
//       //      System.out.println("Invalid Command, please enter a valid one"); 
//
//        return true; //allCommandsMap.get(commandName);
//      
//      //return true;
//        
//    }
    
    

    //public HashMap<String, Command> getAllCommandsMap() {
      //  return allCommandsMap;
    //}
    
    
    
//    public void menuPrinter(Boolean state) { 
//        if(state == true){
//            System.out.print(CLFormatter.formatMainMenuPrompt());
//        }else if(state == false){
//            System.out.println(CLFormatter.formatDraftingMenuPrompt(seetDatabase.getDraftTopic(),seetDatabase.getDraftLines()));
//        }
//    }
//    
   
   
    public HashMap<String, Command> getAllCommandsMap() {
        return allCommandsMap;
    }

    
    
    
    
    
}
