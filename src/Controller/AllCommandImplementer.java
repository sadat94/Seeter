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
import View.Client;
import View.Reader;
import View.SeetDraftDatabase;
import java.io.IOException;
import java.util.Arrays;
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
public class AllCommandImplementer {
    
    private Client client;
    private CLFormatter formatter;
    private User user;
    private Reader reader;
    private AllCommandInvoker invoker;
    private AppSeet seet;
    private SeetDraftDatabase seetDatabase;
 

    public AllCommandImplementer (Client newClient, CLFormatter clFormatter, User user) {
        client = newClient;
        formatter = clFormatter;
        this.user = user;
        seetDatabase = new SeetDraftDatabase();
        reader = new Reader();
        setCLFormatter();
        invoker = new AllCommandInvoker(formatter, user);
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
        
        if(!invoker.getAllCommandsMap().containsKey(commandWord)) {
            System.out.println("No command recognised");
        }
        
        seet = new AppSeet(secondWord, message);
        return invoker.runCommands(commandWord);
    }
  
    public boolean fetch() {
        ClientChannel chan = formatter.getChan();
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

        ClientChannel chan = formatter.getChan();
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

    
    
    
    
    
    private void setUser() {
        client.inputUser();
        String name = null;
        try {
            name = reader.getReader().readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = new User(name, "localhost", 8888);
    }

    public void setCLFormatter() {
        setUser();
        formatter = null;

        if (user.getName().isEmpty() || user.getHost().isEmpty()) {
            System.err.println("User/host has not been set.");
            System.exit(1);
        }

        formatter = new CLFormatter(user.getHost(),user.getPort());
    }

    public CLFormatter getFormatter() {
        return formatter;
    }
    
    boolean finished = false;
    boolean state = true;

    public void loop() {

        while (!finished) {

            try {
                menuPrinter(state);
                UserInput userCommand = reader.getCommand();
                state = processCommand(userCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
    public User getUser() {
        return user;
    }  

    public AllCommandInvoker getInvoker() {
        return invoker;
    }
}
