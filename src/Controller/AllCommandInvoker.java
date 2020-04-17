/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.AppSeet;
import Model.User;
import Model.UserInput;
import View.CLFormatter;
import View.SeetDraftDatabase;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Publish;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/**
 *
 * @author ss15a
 */
public class AllCommandInvoker {
   
    
    private final HashMap<String, Command> allCommandsMap = new HashMap<>();
   
    private CLFormatter clFormatter;
    private User user;
    private SeetDraftDatabase seetDatabase;
    private AppSeet seet;
    
    public AllCommandInvoker(CLFormatter formatter, User user) {
        clFormatter = formatter;
        this.user = user;
        seetDatabase = new SeetDraftDatabase();
    }
   
    public void addCommands(String commandKeyName, Command commandValue) {
        
        allCommandsMap.put(commandKeyName, commandValue);
        
    }
    
    public boolean runCommands(String commandKeyName) {
        
        Command commandValue = allCommandsMap.get(commandKeyName);
        
            if (commandValue == null) {
            
                throw new IllegalStateException("no command found for" + commandKeyName);
                
            }
            
            return commandValue.execute();     
    }

    public HashMap<String, Command> getAllCommandsMap() {
        return allCommandsMap;
    }
    
    public void addAppCommands() {
       allCommandsMap.put("fetch", (Command) new FetchSeet(this));
       allCommandsMap.put("compose", (Command) new ComposeSeet(this) );
       allCommandsMap.put("body", (Command) new BodySeet(this));
       allCommandsMap.put("send", (Command) new SendSeet(this));
    }
    
    public void menuPrinter(Boolean state) { 
        if(state == true){
            System.out.print(CLFormatter.formatMainMenuPrompt());
        }else if(state == false){
            System.out.println(CLFormatter.formatDraftingMenuPrompt(seetDatabase.getDraftTopic(),seetDatabase.getDraftLines()));
        }
    }
    
    public boolean processCommand(UserInput command) throws IOException{
        String commandWord = command.getFirstWord();
        String secondWord = command.getSecondWord();
        String [] message = command.getMessageWord();
        
        if(commandWord.equals("exit")) {
            System.exit(0);
        }
        
        if(!getAllCommandsMap().containsKey(commandWord)) {
            System.out.println("No command recognised");
        }
        
        seet = new AppSeet(secondWord, message);
        return runCommands(commandWord);
    }
  
    public boolean fetch() {
        ClientChannel chan = clFormatter.getChan();
        String title = seet.getTitle();

        try {
          chan.send(new SeetsReq(title));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SeetsReply rep = null;
        try {
            rep = (SeetsReply) chan.receive();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(
                CLFormatter.formatFetched(title, rep.users, rep.lines));

        return true;
    }

    public boolean compose() {
        String title = seet.getTitle();
        seetDatabase.setDraftTopic(title);
        return false;
    }

    public boolean body() {
        String line = Arrays.stream(seet.getMessage()).
                collect(Collectors.joining());
        seetDatabase.getDraftLines().add(line);

        return false;
    }

    public boolean send() {

        ClientChannel chan = clFormatter.getChan();
        String draftTopic = seetDatabase.getDraftTopic();
        String userId = user.getName();
        List<String> msgList = seetDatabase.getDraftLines();

        try {
            chan.send(new Publish(userId, draftTopic, msgList));
        } catch (IOException e) {
            e.printStackTrace();
        }

        seetDatabase.setDraftTopic(null);
        return true;
    }

    
    
    
    
    
}
